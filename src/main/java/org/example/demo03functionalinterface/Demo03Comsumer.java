package org.example.demo03functionalinterface;

import java.util.Locale;
import java.util.function.Consumer;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 消费者
 * @date 2022/4/1 13:33
 */
public class Demo03Comsumer {
    public static void main(String[] args) {

        test(s -> {
            System.out.println(s.toLowerCase(Locale.ROOT));
        });
    }
    public static void test (Consumer<String> consumer){
        consumer.accept("HelloWorld");
    }
}
