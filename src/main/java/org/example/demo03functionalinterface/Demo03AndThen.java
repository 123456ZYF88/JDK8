package org.example.demo03functionalinterface;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:运行结果将会首先打印完全大写的HELLO，然后打印完全小写的hello。
 * 当然，通过链式写法可以实现更多步骤的组合。
 * @date 2022/4/1 14:14
 */
public class Demo03AndThen {
    public static void main(String[] args) {
        //Lambd表达式
        test((s) -> {
            System.out.println(s.toLowerCase());//大写
        },s -> {
            System.out.println(s.toUpperCase());//小写
        });
        //Lambda表达式简写 如果只有一个方法 大括号就可以取消
        test(s -> System.out.println(s.toLowerCase()), s -> System.out.println(s.toLowerCase()));
    }
    public static void test (Consumer<String> c1, Consumer<String > c2){
         String str = "HelloWord";
//         c1.accept(str);
//         c2.accept(str);
//        c1.andThen(c2).accept(str);
        c2.andThen(c1).accept(str);
    }
}
