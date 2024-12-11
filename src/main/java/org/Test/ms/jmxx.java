package org.Test.ms;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

/**
 * 嘉勉信息
 *
 * @author zhangyf
 * @date 2024/11/14 0:52
 */

public class jmxx {


    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    //答案可以按 任意顺序 返回。
    //给出数字到字母的映射如下（与电话按键相同）注意 1 不对应任何
    //字母。
    //用例
    //1：
    //输入：digits="23"输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    @Test
    public void testOne(){



        String digits = "23";
        String[] string = new String[]{"test"};
        String[] strings = new String[]{"a","b","c"};
        String[] strings1 = new String[]{"d","e","f"};
        String[] strings2 = new String[]{"g","h","i"};
        String[] strings3 = new String[]{"j","k","l"};
        String[] strings4 = new String[]{"m","n","o"};
        String[] strings5 = new String[]{"p","q","r","s"};
        String[] strings6 = new String[]{"t","u","v"};
        String[] strings7 = new String[]{"w","x","y","z"};
        List<String[]> list =  new java.util.ArrayList<>();
        //如果是jdk9以上可以直接使用
       // List<String[]> list = List.of("集合1"，"集合2");
        list.add(string);
        list.add(strings);
        list.add(strings1);
        list.add(strings2);
        list.add(strings3);
        list.add(strings4);
        list.add(strings5);
        list.add(strings6);
        list.add(strings7);


        String[] strings8 = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] strings9 = new String[]{"2","3","4","5","6","7","8","9"};
        //截取字符串转换为List
        String[] strings10 = digits.split("");

        List<String[]> list2 =  new java.util.ArrayList<>();
        //循环输入的数字拿到对应数字的集合
        for (String s : strings10) {
            list2.add( list.get(Integer.parseInt(s)));
        }
        //拿到数字对应的集合
        String[]  out = new String[] {};
        for (String[] strings11 : list2){



        }









    }
}
