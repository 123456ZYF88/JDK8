package org.example02.dem04Stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Author ZhangYiFan
 * @Date 2023/3/15 16:44
 * @description:
 * @Version 1.0
 */
public class Demo04GetStream {
    public static void main(String[] args) {
        //集合获取流
        // Collection接口中的方法: default Stream<E> stream() 获取流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Set<String> set = new HashSet<>();

        Stream<String> stream1 = set.stream();

        Vector<String> vector = new Vector<>();

        Stream<String> stream2 = vector.stream();


      //  java.util.Map 接口不是 Collection 的子接口，所以获取对应的流需要分key、value或entry等情况：

        //Map 获取流
        Map<String,String> map = new HashMap<>();

        Stream<String> stream3 = map.keySet().stream();
        Stream<String> stream4 = map.values().stream();
        Stream<Map.Entry<String, String>> stream5 = map.entrySet().stream();
    }
}
