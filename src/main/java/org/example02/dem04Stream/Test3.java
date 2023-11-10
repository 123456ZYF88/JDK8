package org.example02.dem04Stream;

import lombok.Data;
import org.apache.poi.ss.formula.functions.Function;
import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * @Author ZhangYiFan
 * @Date 2023/5/17 10:09
 * @description: 操作流Stream的结果操作
 * @Version 1.0
 */
public class Test3 {

    //小结
    /*收集Stream流中的结果
    到集合中: Collectors.toList()/Collectors.toSet()/Collectors.toCollection()
    到数组中: toArray()/toArray(int[]::new)
    聚合计算:
    Collectors.maxBy/Collectors.minBy/Collectors.counting/Collectors.summingInt/Collectors.averagingInt
    分组: Collectors.groupingBy
    分区: Collectors.partitionBy
    拼接: Collectors.joinging
*/


    //掌握Stream流中的结果到集合中
/*    Stream流提供 collect 方法，其参数需要一个 java.util.stream.Collector<T, A, R> 接口对象来指定收集到哪
    种集合中。java.util.stream.Collectors 类提供一些方法，可以作为 Collector`接口的实例：
    public static <T> Collector<T, ?, List<T>> toList() ：转换为 List 集合。
    public static <T> Collector<T, ?, Set<T>> toSet() ：转换为 Set 集合。*/


    // 将流中数据收集到集合中
    @Test
    public void testStreamToCollection() {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "bb");
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
        for (String o : strings) {
            System.out.println("o.length()  = " + o.length());
        }

    }

    /**
     * 对流中数据进行聚合计算%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
     */
    @Test
    public void testStreamToOther() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 88),
                new Student("迪丽热巴", 57, 99),
                new Student("柳岩", 52, 77));

        //最大值
//        Optional<Student> collect = studentStream.collect(Collectors.maxBy((a1, a2) ->
//                a1.getAge() - a2.getAge()));
//        System.out.println(collect.toString());

//        //获取最新值
//        Optional<Student> collect = studentStream.collect(Collectors.minBy((a1, a2) -> a1.getAge() - a2.getAge()));
//        System.out.println(collect.toString());

//        //求总和
//        int collect = studentStream.collect(Collectors.summingInt(s -> s.getAge()));
//        System.out.println("collect = " + collect);

        //平均值
//        Double collect = studentStream.collect(Collectors.averagingInt(s -> s.getScore()));
//        System.out.println("collect = " + collect);

        //统计数量
        Long collect = studentStream.collect(Collectors.counting());
        System.out.println("collect = " + collect);
    }


    /*
     * 对流中的数据分组%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
     * */
    @Test
    public void testGroup() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 59),
                new Student("迪丽热巴", 57, 99),
                new Student("柳岩", 52, 77));

        //按不同成绩先进行分组
//        Map<Integer, List<Student>> collect = studentStream.collect(Collectors.groupingBy(Student::getAge));
//        System.out.println(collect);
        //将分数大于60和小于60分两个组
        Map<String, List<Student>> collect1 = studentStream.collect(groupingBy((s) -> {
            if (s.getScore() > 60) {
                return "及格";
            } else {
                return "不及格";
            }
        }));
        // System.out.println(collect1);

        collect1.forEach((k, v) -> System.out.println(k + "::" + v));
    }

    @Data
    class SalesPlan {
        private String id;
        private String type;
        private String Name;
        private String Data;
        private int Num;

        public SalesPlan(String id, String type, String name, String data, int num) {
            this.id = id;
            this.type = type;
            Name = name;
            Data = data;
            Num = num;
        }
    }

    @Data
    class SalesPlan2 {
        private String type;
        private String Name;
        private String Data;
        private int Num;

        public SalesPlan2(String type, String name, String data, int num) {
            this.type = type;
            Name = name;
            Data = data;
            Num = num;
        }

        public SalesPlan2() {
        }
    }


    @Test
    public void testGroup2() {



        Stream<SalesPlan> studentStream = Stream.of(
                new SalesPlan("赵丽颖", "正常合同", "焦油", "20231025", 100),
                new SalesPlan("杨颖", "正常合同", "焦油", "20231025", 100),
                new SalesPlan("迪丽热巴", "预计划", "焦油", "20231025", 100),
                new SalesPlan("柳岩", "预计划", "工业萘", "20231025", 100),
                new SalesPlan("柳岩", "预计划", "工业萘", "20231026", 100),
                new SalesPlan("柳岩", "预计划", "工业萘", "20231026", 100),
                new SalesPlan("柳岩", "预计划", "工业萘", "20231026", 100));
//        Map<String, Map<String, Map<String, Integer>>> collect = studentStream.collect(groupingBy(SalesPlan::getType, groupingBy(SalesPlan::getName, groupingBy(SalesPlan::getData, summingInt(SalesPlan::getNum)))));
//        collect.forEach((k, v) -> System.out.println(k + "::" + v));
        Map<String, List<SalesPlan>> collect = studentStream.collect(groupingBy(v ->
                v.getId() + "_" + v.getName()));
       // collect.forEach((k, v) -> System.out.println(k + "::" + v));
        List<SalesPlan> b = new ArrayList<>();
        collect.forEach((k, v) ->
                b.add( v.get(0))
                );
        System.out.println(b);
        Map<String, Map<String, List<SalesPlan>>> collect1 = b.stream().collect(groupingBy(SalesPlan::getType,groupingBy(SalesPlan::getName)));
        collect1.forEach((k, v) -> System.out.println(k + "::" + v));
    }

    /**
     * 合并分组
     */
    @Test
    public void testGroup3() {

        List<SalesPlan> salesPlans = new ArrayList<>();
        salesPlans.add(    new SalesPlan("赵丽颖", "正常合同", "焦油", "20231025", 100) );
        salesPlans.add(   new SalesPlan("赵丽颖", "正常合同", "焦油", "20231025", 100));
                salesPlans.add(        new SalesPlan("杨颖", "正常合同", "焦油", "20231025", 100));
                        salesPlans.add(      new SalesPlan("迪丽热巴", "预计划", "焦油", "20231025", 100));
                                salesPlans.add(      new SalesPlan("柳岩", "预计划", "工业萘", "20231025", 100));
                                        salesPlans.add(     new SalesPlan("柳岩", "预计划", "工业萘", "20231026", 100));
                                                salesPlans.add(     new SalesPlan("柳岩", "预计划", "工业萘", "20231026", 100));
                                                        salesPlans.add(     new SalesPlan("柳岩", "预计划", "工业萘", "20231026", 100));
        System.out.println(salesPlans);
        Stream<SalesPlan> studentStream = salesPlans.stream();


        Map<String, List<SalesPlan>> collect1 = studentStream.collect(groupingBy(v -> v.getType() + "_" + v.getName() + "_" + v.getData()));
        // collect1.forEach((k, v) -> System.out.println(k + "::" + v));
        List<SalesPlan2> s = new ArrayList<>();

        for (Map.Entry<String, List<SalesPlan>> entry : collect1.entrySet()) {
            String k = entry.getKey();
            List<SalesPlan> v = entry.getValue();
            SalesPlan2 salesPlan2 = new SalesPlan2();
            for (SalesPlan i : v) {
                salesPlan2.setName(i.getName());
                salesPlan2.setType(i.getType());
                salesPlan2.setData(i.getData());
                System.out.println(i.getNum());
                salesPlan2.setNum(salesPlan2.getNum() + i.getNum());
            }
            s.add(salesPlan2);
        }
        Map<String, Map<String, List<SalesPlan2>>> b  = s.stream().collect(groupingBy(SalesPlan2::getType, groupingBy(SalesPlan2::getName)));

        b.forEach((k, v) -> System.out.println(k + "::" + v));
        System.out.println(salesPlans);

    }
    /**
     * 合并分组
     */
    @Test
    public void testGroup4() {

        List<SalesPlan> salesPlans = new ArrayList<>();
        salesPlans.add(    new SalesPlan("赵丽颖", "正常合同", "焦油", "20231025", 100) );
        salesPlans.add(   new SalesPlan("赵丽颖", "正常合同", "焦油", "20231025", 100));
        salesPlans.add(        new SalesPlan("杨颖", "正常合同", "焦油", "20231025", 100));
        salesPlans.add(      new SalesPlan("迪丽热巴", "预计划", "焦油", "20231025", 100));
        salesPlans.add(      new SalesPlan("柳岩", "预计划", "工业萘", "20231025", 100));
        salesPlans.add(     new SalesPlan("柳岩", "预计划", "工业萘", "20231026", 100));
        salesPlans.add(     new SalesPlan("柳岩", "预计划", "工业萘", "20231026", 100));
        salesPlans.add(     new SalesPlan("柳岩", "预计划", "工业萘", "20231026", 100));
        System.out.println(salesPlans);
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        List<SalesPlan> salesPlans2 = new ArrayList<>();
        salesPlans.forEach(v-> {
                    if (seen.putIfAbsent(v.getId() + v.getName(), Boolean.TRUE) == null) {
                        salesPlans2.add(v);
                    }
                }
        );

        salesPlans2.forEach(System.out::println);
    }



    /*
     * 多级分组%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
     * */
    @Test
    public void testCustomGroup() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 59),
                new Student("迪丽热巴", 57, 99),
                new Student("柳岩", 52, 77));

        int i =1;
        while (i <2){
            System.out.println(i);
            i++;
        }
    }
    // 对流进行分区%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @Test
    public void testPartition() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 59),
                new Student("迪丽热巴", 57, 99),
                new Student("柳岩", 52, 77));

        Map<Boolean, List<Student>> collect = studentStream.collect(Collectors.partitioningBy(s -> s.getAge() > 90));
        System.out.println(collect);

    }


    //对流进行拼接%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //Collectors.joining 会根据指定的连接符，将所有元素连接成一个字符串。
    @Test
    public void testJoining() {
        Stream<Student> studentStream = Stream.of(
                new Student("赵丽颖", 58, 95),
                new Student("杨颖", 56, 59),
                new Student("迪丽热巴", 57, 99),
                new Student("柳岩", 52, 77));
        String collect = studentStream
                .map(Student::getName)
                .collect(Collectors.joining("<>", "><", "<<"));
        System.out.println("collect = " + collect);
    }

}
