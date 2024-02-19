package org.example.demo0Lambda;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 有参有返回值的Lambda
 * @date 2021/12/28 19:13
 */
public class Demo05Lambda {
    public static void main(String[] args) {
        /*
        * 1. 小括号内参数的类型可以省略
            2. 如果小括号内有且仅有一个参数，则小括号可以省略
            3. 如果大括号内有且仅有一个语句，可以同时省略大括号、return关键字及语句分号(必须同时)*/
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("刘德华", 58, 174));
        persons.add(new Person("张学友", 58, 176));
        persons.add(new Person("刘德华", 54, 171));
        persons.add(new Person("黎明", 53, 178));


        Collections.sort(persons,(Person o1,Person o2) -> o2.getAge() - o1.getAge());

        persons.forEach(t -> System.out.println(t));

    }

}
