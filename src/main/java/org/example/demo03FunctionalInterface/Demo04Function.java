package org.example.demo03FunctionalInterface;

import java.util.function.Function;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2022/4/1 14:30
 */
public class Demo04Function {
    public static void main(String[] args) {
        test(Integer::parseInt);
    }
    public static void test(Function<String,Integer> function){
        Integer in = function.apply("10");
        System.out.println("in: " + (in +5));
    }
}
