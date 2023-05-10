package org.example02.dem04Stream;

import lombok.Data;

import java.util.Objects;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 测试类
 * @date 2023/5/10 20:14
 */
@Data
public class Person {
    private String name;
    //名称
    private int  age;

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }


}
