package org.example.demo0Lambda;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2021/12/21 16:59
 */
public class Demo01Lambdaintro {
    public static void main(String[] args) {
        //很冗余匿名的方法
        //lambda表达式 体现的是函数式编程思想 ，只需要将要执行的代码放到函数中（函数就是类中的方法）
        //Lambda 就是一个匿名函数，只需要吧代码放到Lambda表达式中

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("原始的线程1");
            }
        }).start();


        // Lambda表达式
        new Thread(() -> {
            System.out.println("sdsdsd");
        }).start();
        //Lambda 表达式的缓存 ： 可以简化匿名内部类 ，语法更简单

    }
}
