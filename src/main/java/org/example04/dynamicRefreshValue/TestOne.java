package org.example04.dynamicRefreshValue;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/test")
@Api(value = "测试接口")
public class TestOne {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ConfigurableEnvironment environment;

    @ApiOperation(value = "自定义修改配置")
    @PostMapping("/update")
    public String calcHistoryUseEle(String name, String value){
        System.out.println("参数名Name= "+name);
        System.out.println("参数值value= "+value);

        //配置转换
        RefreshEnvironment.updateValue(name,value);

        applicationContext.publishEvent(new AnoValueRefreshPostProcessor.ConfigUpdateEvent(this,name));
        return "成功";


    }



}
