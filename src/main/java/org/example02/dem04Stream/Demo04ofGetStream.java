package org.example02.dem04Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author ZhangYiFan
 * @Date 2023/3/15 17:04
 * @description:
 * @Version 1.0
 */
public class Demo04ofGetStream {
    public static void main(String[] args) {
// Stream中的静态方法: static Stream of(T... values)
        Stream<String> aa = Stream.of("aa", "bb", "cc");

        String[] arr = {"aa","bb","cc"};
        Stream<String> bb = Stream.of(arr);



        System.out.println(aa);
        System.out.println(bb);
    }
}
