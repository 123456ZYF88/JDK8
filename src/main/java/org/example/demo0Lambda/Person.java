package org.example.demo0Lambda;

import lombok.Data;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2021/12/28 19:14
 */
@Data
public class Person {
    private String name;
    private int age;
    private int height;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
