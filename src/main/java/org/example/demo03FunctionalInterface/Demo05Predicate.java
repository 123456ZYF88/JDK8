package org.example.demo03FunctionalInterface;

import java.util.function.Predicate;

/**
 * Predicate接口
 * 使用Lambda判断一个人名如果超过3个字就认为是很长的名字
 *
 * @author zhangyf
 * @date 2024/4/1 13:40
 */

public class Demo05Predicate {
    public static void main(String[] args) {
        test(s -> s.length() > 3, "古力娜扎");
    }

    public static void test(Predicate<String> predicate, String name) {
        boolean test = predicate.test(name);
        System.out.println("名字答于3不" + test);
    }

}
