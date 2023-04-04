package org.example02.dem04Stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author ZhangYiFan
 * @Date 2023/3/16 9:17
 * @description: Stream常用方法测试
 * @Version 1.0
 */
public class Test2 {


    @Test
    /**
     * 该方法接收一个 Consumer 接口函数，会将每一个流元素交给该函数进行处理
     * void forEach(Consumer<? super T> action);
     */
    public void testFoEach() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");

//        one.stream().forEach((String s)->{
//            System.out.println(s);
//        });

        //  one.stream().forEach(s -> System.out.println(s));

        one.stream().forEach(System.out::println);
    }


    /**
     * long count();该方法返回一个long值代表元素个数。
     */
    @Test
    public void testCount() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        System.out.println(one.stream().count());
    }


    /**
     * Stream<T> filter(Predicate<? super T> predicate);
     * 该接口接收一个 Predicate 函数式接口参数（可以是一个Lambda或方法引用）作为筛选条件。
     */
    @Test
    public void testFilter() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        one.stream().filter(s -> s.length() == 2).forEach(System.out::println);
    }

    /**
     * 取前几个值
     * 参数是一个long型，如果集合当前长度大于参数则进行截取。否则不进行操作。基本使用：
     */
    @Test
    public void testLimit() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        one.stream().limit(2).forEach(System.out::println);
    }
    /**
     * 如果希望跳过前几个元素，可以使用 skip 方法获取一个截取之后的新流：
     * 如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。基本使用：
     */
    @Test
    public void testSkip() {
        List<String> one = new ArrayList<>();
        Collections.addAll(one, "迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子");
        one.stream().skip(2).forEach(System.out::println);
    }

    /**
     * 将一个流映射到另一个流中
     * 该接口需要一个 Function 函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
     */
    @Test
    public void testMap() {
        Stream<String> original = Stream.of("11", "22", "33");

    }

    @Test
    public void testSorted() {

    }

    @Test
    public void testDistinct() {

    }

    @Test
    public void testMatch() {

    }

    @Test
    public void testfind() {

    }

    @Test
    public void testMax() {

    }

    @Test
    public void testMin() {

    }


}
