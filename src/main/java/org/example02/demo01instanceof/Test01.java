package org.example02.demo01instanceof;


/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2022/4/27 12:39
 */

//instanceof 严格来说是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例，用法为：
// 其中 obj 为一个对象，Class 表示一个类或者一个接口，当 obj 为 Class 的对象
// ，或者是其直接或间接子类，或者是其接口的实现类，结果result 都返回 true，否则返回false。
//  boolean result = obj instanceof Class;

public class Test01 {
    public static void main(String[] args) {
        int a =1;
        //System.out.println(a instanceof Integer);//必须是一个对象

        Integer i = 1;
        System.out.println(i instanceof Integer);//封装类一个对象

        String simpleStr = "This is a simple string";
        System.out.println(simpleStr instanceof String); //true

        //Object myObj = {} ;
        //System.out.println(myObj instanceof Object);
    }
}
