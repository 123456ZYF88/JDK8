package org.example.demo03FunctionalInterface;

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
public class Demo03Comsumer {
    public static void main(String[] args) {

        test(s -> {
            System.out.println(s.toLowerCase(Locale.ROOT));
        });
    }
    public static void test (Consumer<String> consumer){
        System.out.println("sssssssssss");
        consumer.accept("HelloWorld");
    }
}
