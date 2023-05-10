package org.example02.dem04Stream;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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

     /*   //将字符串转成Integer
        Stream<Integer> stream = original.map((String s) -> {
            return Integer.parseInt(s);
        });*/
        original.map(Integer::parseInt).forEach(System.out::println);
    }

    /**
     * 功能描述 排序
     *
     * @param
     * @return void
     * @author
     * @date 2023/5/10
     */
    @Test
    public void testSorted() {
        // sorted(): 根据元素的自然顺序排序
// sorted(Comparator<? super T> comparator): 根据比较器指定的规则排序
        Stream<Integer> original = Stream.of(11, 66, 33, 55);
        // original.sorted().forEach(System.out::println);
       /* original.sorted((Integer a1,Integer a2) ->{
            return a2-a1;
        }).forEach(System.out::println);*/
        original.sorted((a1, a2) -> a2 - a1).forEach(System.out::println);

    }

    /**
     * 功能描述 去重操作
     *
     * @param
     * @return void
     * @author
     * @date 2023/5/10
     */
    @Test
    public void testDistinct() {
        Stream<Integer> original = Stream.of(11, 11, 33, 55, 77);
        original.distinct().forEach(System.out::println);

        Stream<String> originals = Stream.of("11", "11", "33", "55");

        originals.distinct().forEach(System.out::println);

    }

    /**
     * 功能描述 对象去重
     * 注意需要重写 equals 和 hashcode方法 @Data会操作
     *
     * @param
     * @return void
     * @author
     * @date 2023/5/10
     */
    @Test
    public void testDistinct2() {
        Stream<Person> stream = Stream.of(
                new Person("a", 12),
                new Person("a", 12),
                new Person("张学友", 56),
                new Person("张学友", 56),
                new Person("黎明", 52),
                new Person("黎明", 52)
        );

        stream.distinct().forEach(System.out::println);

    }

    /**
     * 如果需要判断数据是否匹配指定的条件，可以使用 Match 相关方法。方法签名：
     * boolean allMatch(Predicate<? super T> predicate);
     * boolean anyMatch(Predicate<? super T> predicate);
     * boolean noneMatch(Predicate<? super T> predicate);
     * 功能描述
     *
     * @param
     * @return void
     * @author
     * @date 2023/5/10
     */
    @Test
    public void testMatch() {

        boolean b = Stream.of(5, 3, 6, 1)
                //.allMatch( a -> a>2); 全部判断 需要全部满足
                //.anyMatch(a-> a<7); 一个满足
                .noneMatch(a -> a < 0);
        //所有元素不满足
        System.out.println(b);

    }

    /**
     * 如果需要找到某些数据，可以使用 find 相关方法。方法签名：
     * Optional<T> findFirst();
     * Optional<T> findAny();
     * 功能描述
     *
     * @param
     * @return void
     * @author
     * @date 2023/5/10
     */
    @Test
    public void testfind() {
        Stream<Integer> first = Stream.of(5, 3, 6, 1);
        //返回第一个元素
        //Optional<Integer> first1 = first.findFirst();

        //findAny和findFirst区别在于First能保证总取第一个,而findAny在并行条件下,不能保证取到的是第一个
        Optional<Integer> first1 = first.findAny();

        System.out.println(first1.get());
    }

    @Test
    public void testMaxAndMin() {
        //最大 max获取排序后的第一个值
        Optional<Integer> max = Stream.of(5, 3, 6, 1).max((a1, a2) -> a1 - a2);
        System.out.println(max.get());
        //最小 min获取排序后的最后一个值
        Optional<Integer> min = Stream.of(5, 3, 6, 1).min((a1, a2) -> a1 - a2);
        System.out.println(min.get());
    }

    //用的多

    /**
     * 如果需要将所有数据归纳得到一个数据，可以使用 reduce 方法。方法签名：
     * T reduce(T identity, BinaryOperator<T> accumulator);
     * 一种循环的使用，每次的操作前后量个变量，前一个变量是上一次的return  第一个变量是0开始
     * 功能描述
     *
     * @param
     * @return void
     * @author
     * @date 2023/5/10
     */
    @Test
    public void testReduce() {
        //int reduce = Stream.of(4, 5, 3, 9).reduce(0,(x,y)->x+y);
        int reduce = Stream.of(4, 5, 3, 9).reduce(0, Integer::sum);
        System.out.println(reduce);

        //reduce 获取最大值

    }


    @Test
    protected void testMapReduce() {
        Integer reduce = Stream.of(
                new Person("刘德华", 58),
                new Person("张学友", 56),
                new Person("郭富城", 54),
                //获得年龄，相加
                new Person("黎明", 52)).map(s -> s.getAge()).reduce(0, Integer::sum);
        System.out.println(reduce);


        Person person = Stream.of(
                new Person("刘德华", 58),
                new Person("张学友", 56),
                new Person("郭富城", 54),
                //去最大
                new Person("黎明", 52)).max((a1, a2) -> a1.getAge() - a2.getAge()).get();
        System.out.println(person);

        Optional<Integer> person2 = Stream.of(
                new Person("刘德华", 58),
                new Person("张学友", 56),
                new Person("郭富城", 54),
                // Integer::max
                new Person("黎明", 52)).map(s -> s.getAge()).reduce(Math::max);
        System.out.println(person2.get());

        // 统计 数字2 出现的次数
        Optional<Integer> count = Stream.of(1, 2, 2, 1, 3, 2).map(s -> {
            if (s == 1) {
                return 1;
            } else {
                return 0;
            }
        }).reduce(Integer::sum);

        System.out.println(count.get());


    }

    /**
     * 如果需要将Stream中的Integer类型数据转成int类型，可以使用 mapToInt 方法。
     * IntStream mapToInt(ToIntFunction<? super T> mapper);
     * 功能描述
     *
     * @param
     * @return void
     * @author
     * @date 2023/5/10
     */
    @Test
    public void testMapToInt() {
// Integer占用的内存比int多,在Stream流操作中会自动装箱和拆箱
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        //把大于3的和打印出来
//        Integer result = stream
//                .filter(i -> i.intValue() > 3)
//                .reduce(0, Integer::sum);
//        System.out.println(result);

       // 先将流中的Integer数据转成int,后续都是操作int类型  减少自动装箱
        IntStream longStream = stream.mapToInt( Integer::intValue);
        longStream.filter(s-> s>3).forEach(System.out::println);
    }
    /** 如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat ： (只能和两个)
     * 这是一个静态方法，与 java.lang.String 当中的 concat 方法是不同的。
     * 功能描述
     * @author
     * @date 2023/5/10
     * @param
     * @return void
     */
    @Test
    public void testContact() {
        Stream<String> streamA = Stream.of("张三");
        Stream<String> streamB = Stream.of("李四");
        Stream<String> concat = Stream.concat(streamB, streamA);
        //以前的数据不能操作
        concat.forEach(System.out::println);
    }

}
