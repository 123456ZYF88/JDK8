package org.example.demo03FunctionalInterface;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.function.Consumer;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 消费者
 * java.util.function.Consumer<T> 接口则正好相反，它不是生产一个数据，而是消费一个数据，其数据类型由泛
 * 型参数决定。
 * Consumer消费型接口，可以拿到accept方法参数传递过来的数据进行处理, 有参无返回的接口。
 * @date 2022/4/1 13:33
 */
public class Demo03Consumer {
    public static void main(String[] args) {
        String a = "AAAA";
        Consumer<String> consumer = v -> System.out.println(   v.toLowerCase(Locale.ROOT));
        consumer.accept(a);

        test(v -> System.out.println(v+1));
    }
    public static void test (Consumer<Integer> consumer){
        System.out.println("sssssssssss");
        consumer.accept(1);
    }


    @Test
    public void test2(){

    }
}
