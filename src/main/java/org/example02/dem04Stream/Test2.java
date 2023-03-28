package org.example02.dem04Stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ZhangYiFan
 * @Date 2023/3/16 9:17
 * @description:
 * @Version 1.0
 */
public class Test2 {

    @Test
    /**
     * 该方法接收一个 Consumer 接口函数，会将每一个流元素交给该函数进行处理
     * void forEach(Consumer<? super T> action);
     */
    public void testFoEach(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");

//        one.stream().forEach((String s)->{
//            System.out.println(s);
//        });

          //  one.stream().forEach(s -> System.out.println(s));

        one.stream().forEach(System.out::println);
    }

    @Test
    /**
     * long count();该方法返回一个long值代表元素个数。
     */
    public void testCount(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        System.out.println(one.stream().count());
    }

    @Test
    /**
     * Stream<T> filter(Predicate<? super T> predicate);
     * 该接口接收一个 Predicate 函数式接口参数（可以是一个Lambda或方法引用）作为筛选条件。
     */
    public  void testFilter(){
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");

        one.stream().filter(s -> s.length()==2).forEach(System.out::println);
    }


}
