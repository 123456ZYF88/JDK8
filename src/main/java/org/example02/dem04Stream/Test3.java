package org.example02.dem04Stream;

import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author ZhangYiFan
 * @Date 2023/5/17 10:09
 * @description: 操作流Stream的结果操作
 * @Version 1.0
 */
public class Test3 {


    //掌握Stream流中的结果到集合中
/*    Stream流提供 collect 方法，其参数需要一个 java.util.stream.Collector<T, A, R> 接口对象来指定收集到哪
    种集合中。java.util.stream.Collectors 类提供一些方法，可以作为 Collector`接口的实例：
    public static <T> Collector<T, ?, List<T>> toList() ：转换为 List 集合。
    public static <T> Collector<T, ?, Set<T>> toSet() ：转换为 Set 集合。*/




    // 将流中数据收集到集合中
    @Test
    public void testStreamToCollection() {
        Stream<String> stream = Stream.of("aa", "bb", "cc","bb");
        // 将流中数据收集到集合中
        //collect收集数据的方法
/*        List<String> collect = stream.collect(Collectors.toList());
        System.out.println(collect);*/

   /*     Set<String> collect = stream.collect(Collectors.toSet());
        System.out.println(collect);*/

//        ArrayList<String> collect = stream.collect(Collectors.toCollection(ArrayList::new));
//        System.out.println("collect = " + collect);

        //set会去重
        HashSet<String> collect = stream.collect(Collectors.toCollection(HashSet::new));
        System.out.println("collect = " + collect);



    }
    /*掌握Stream流中的结果到数组中*/

    @Test
    public void testStreamToArray() {
        Stream<String> stream = Stream.of("aa", "bb", "cc");

        //object类型的不好操作
     /*   Object[] objects = stream.toArray();
        for (Object o : objects){
            System.out.println("o = " + o);
        }*/

        String[] strings = stream.toArray(String[]::new);
        for (String o : strings){
            System.out.println("o.length()  = " + o.length() );
        }

    }

    /**
     * 对流中数据进行聚合计算
     */
    @Test
    public void testStreamToOther() {

    }

}
