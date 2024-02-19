package org.example04.dynamicRefreshValue;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义一个工具类实现配置转换
 */
public class RefreshEnvironment implements EnvironmentAware {
    private static ConfigurableEnvironment environment;

    public static void updateValue(String key,Object newValue){
        //自定义配置文件名称
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.stream().forEach(X-> {
            MapPropertySource mapPropertySource = (MapPropertySource) X;
            if (mapPropertySource.containsProperty(key)){
                String proname = mapPropertySource.getName();
                Map<String, Object> source = mapPropertySource.getSource();
                HashMap<String, Object> map = new HashMap<>(source.size());
                map.putAll(source);
                map.put(key,newValue);
                environment.getPropertySources().replace(proname,new MapPropertySource(proname,map));
            }
        });
    }



    @Override
    public void setEnvironment(Environment environment) {
        RefreshEnvironment.environment  = (ConfigurableEnvironment) environment;
    }
}
