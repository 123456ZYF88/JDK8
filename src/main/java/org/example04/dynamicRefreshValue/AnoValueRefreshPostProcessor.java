package org.example04.dynamicRefreshValue;

import com.alibaba.fastjson.JSONObject;
import lombok.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PropertyPlaceholderHelper;

import java.lang.reflect.Field;
import java.util.*;

public class AnoValueRefreshPostProcessor extends InstantiationAwareBeanPostProcessorAdapter implements EnvironmentAware {
    private Map<String, List<FieldPair>> mapper = new HashMap<>();
    private Environment environment;


    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

        return super.postProcessAfterInstantiation(bean, beanName);
    }

    /**
     * 主要目的就是获取支持动态刷新的配置属性，然后缓存起来
     *
     * @param bean
     */
    private void processMetaValue(Object bean) {
        Class<?> aClass = bean.getClass();
        if (!aClass.isAnnotationPresent(RefreshValue.class)) {
            return;
        }
        try {
            for (Field field : aClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(Value.class)) {
                    Value val = field.getAnnotation(Value.class);
                    List<String> KeyList = pickPropertyKey(val.value(),0);
                    for(String key : KeyList){
                        mapper.computeIfAbsent(key,(k)-> new ArrayList<>()).
                                add(new FieldPair(bean,field,val.value()));
                    }
                }
            }
        }catch (SecurityException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private List<String> pickPropertyKey(String value,int begin){
        int start = value.indexOf("${",begin)+2;
        if (start < 2 ) {
            return new ArrayList<>();
        }
        int middle = value.indexOf(":", start);
        int end = value.indexOf("}", start);

        String key;
        if (middle > 0 && middle <end){
            key = value.substring(start,middle);
        }else {
            key = value.substring(start,end);
        }
        List<String> keys = pickPropertyKey(value, end);
        keys.add(key);
        return keys;
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * description 消费事件，接收到变更事件通过key从缓存中找到需要变更的Field，然后依次刷新
     * @param configUpdateEvent 事件
     */
    @EventListener
    public void updateConfig(ConfigUpdateEvent configUpdateEvent) {
        List<FieldPair> fieldPairs = mapper.get(configUpdateEvent.key);
        if (!CollectionUtils.isEmpty(fieldPairs)){
            fieldPairs.forEach(f->f.updateValue(environment));

        }

    }


    /**
     * description 选择事件机制来实现同步，借助spring Event来完成（自定义事件类）
     */
    public static class ConfigUpdateEvent  extends ApplicationEvent {
    String key;
    public ConfigUpdateEvent(Object source, String key) {
        super(source);
        System.out.println("---"+source);
        this.key = key;
    }
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FieldPair {
        private static PropertyPlaceholderHelper propertyPlaceholderHelper
                = new PropertyPlaceholderHelper("${", "}", ":", true);
        Object bean;
        Field field;
        String value;

        public void updateValue(Environment environment) {
            boolean accessible = field.isAccessible();
            if (!accessible) {
                field.setAccessible(true);
            }

            String updateVal = propertyPlaceholderHelper.replacePlaceholders(value, environment::getProperty);
            try {
                if (field.getType() == String.class) {
                    field.set(bean, updateVal);
                } else {
                    field.set(bean, JSONObject.parseObject(updateVal, field.getType()));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            field.setAccessible(accessible);
        }
    }


}
