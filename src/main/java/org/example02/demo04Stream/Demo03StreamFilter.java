package org.example02.demo04Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZhangYiFan
 * @Date 2023/3/15 10:54
 * @description:
 * @Version 1.0
 */
public class Demo03StreamFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //：获取流、过滤姓张、过滤长度为3
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.stream() //获取流
                .filter(s -> s.startsWith("张"))//过滤姓张
                .filter(s -> s.length() == 3)//过滤长度为3
                .forEach(System.out::println);//输出
    }
}
