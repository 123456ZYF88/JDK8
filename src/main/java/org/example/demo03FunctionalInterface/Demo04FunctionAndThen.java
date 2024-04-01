package org.example.demo03FunctionalInterface;

import java.util.function.Function;


public class Demo04FunctionAndThen {

    /*
     * 需求：将字符串转换为整数，再将整数乘以5
     *
     * Integer::parseInt:将字符串转换为整数
     * (Integer i)-> i* 5:将整数乘以5
     *
     * */
    public static void main(String[] args) {
        getName(Integer::parseInt, (Integer i)-> i* 5);
    }
    public static void getName (Function<String,Integer> f1,Function<Integer,Integer> f2){
        Integer apply = f1.andThen(f2).apply("6");
        System.out.print("apply"+apply );
    }
}
