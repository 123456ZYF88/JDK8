package org.example04.dynamicRefreshValue;


import java.lang.annotation.*;

/**
 *  自定义注解，用来需要修饰需要支持动态刷新的场景
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface RefreshValue {

}
