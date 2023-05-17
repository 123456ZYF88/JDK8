package org.example02.dem04Stream;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author ZhangYiFan
 * @Date 2023/3/15 10:51
 * @description:
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
// 一个ArrayList集合中存储有以下数据:张无忌,周芷若,赵敏,张强,张三丰
// 需求:1.拿到所有姓张的 2.拿到名字长度为3个字的 3.打印这些数据
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
// 1.拿到所有姓张的
        ArrayList<String> zhangList = new ArrayList<>(); // {"张无忌", "张强", "张三丰"}
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }
// 2.拿到名字长度为3个字的
        ArrayList<String> threeList = new ArrayList<>(); // {"张无忌", "张三丰"}
        for (String name : zhangList) {
            if (name.length() == 3) {
                threeList.add(name);
            }
        }
// 3.打印这些数据
        for (String name : threeList) {
            System.out.println(name);
        }
    }


    /** 现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以下
     若干操作步骤：
     * 功能描述
     * @author
     * @date 2023/5/10
     * @param
     * @return void
     */
    @Test
    public void test2() {
/*

        // List.of 接口 jdk 9特性
        List<String> one = List.of("迪丽热巴", "宋远桥", "苏星河", "老子", "庄子", "孙子", "洪七公");

        List<String> two = List.of("古力娜扎", "张无忌", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三");
        //*1. 第一个队伍只要名字为3个字的成员姓名；
        //      2. 第一个队伍筛选之后只要前3个人；
        Stream<String> stringStream = one.stream().limit(3).filter(s -> s.length() == 3);


        */
/*3. 第二个队伍只要姓张的成员姓名；
            4. 第二个队伍筛选之后不要前2个人；*//*

        Stream<String> zhang = two.stream().filter(s -> s.startsWith("张")).skip(2);
        //   5. 将两个队伍合并为一个队伍；
       Stream<String> concat = Stream.concat(stringStream, zhang);

       //    6. 根据姓名创建 Person 对象；
        //            7. 打印整个队伍的Person对象信息。
        Stream<person1> person1Stream = concat.map(s -> {
            return new person1(s);
        });
        // concat.map(Person1:: new)
        person1Stream.forEach(System.out::println);
*/

    }

}
