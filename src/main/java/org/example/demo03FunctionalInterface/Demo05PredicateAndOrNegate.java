package org.example.demo03FunctionalInterface;

import java.util.function.Predicate;

/**
 * Predicate默认方法
 *
 * @author zhangyf
 * @date 2024/4/1 13:53
 */

public class Demo05PredicateAndOrNegate {
    // 使用Lambda表达式判断一个字符串中即包含W,也包含H

    // 使用Lambda表达式判断一个字符串中包含W或者包含H

    // 使用Lambda表达式判断一个字符串中即不包含W
    public static void main(String[] args) {
      /*  test((String s)->{
            return s.contains("W");
        },(String s)->{
            return s.contains("H");
        });*/
        test(s -> s.contains("H"), s -> s.contains("W"));
    }

    public static void test(Predicate<String> predicate, Predicate<String> predicate1) {
        String result = "elloWorld";
        // 使用Lambda表达式判断一个字符串中即包含W,也包含H
   /*     boolean out = predicate.test(result);
        boolean test = predicate.test(result);
        if (out && test){
            System.out.println("即包含W,也包含H");
        }*/
     /*   boolean test = predicate.and(predicate1).test(result);
        if (test){
            System.out.println("即包含W,也包含H");
        }*/

        //使用Lambda表达式判断一个字符串中包含W或者包含H
        // 与and的“与”类似，默认方法or实现逻辑关系中的“或
     /*   boolean test = predicate.or(predicate1).test(result);
        if (test){
            System.out.println("包含W或者包含H");
        }*/

        //“与”、“或”已经了解了，剩下的“非”（取反）也会简单。 negate

        boolean test = predicate.negate().test(result);
        if (test) {
            System.out.println("不包含H");
        }
    }
}
