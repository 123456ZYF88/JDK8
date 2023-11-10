package org.exampleUtils01.BigDecimalUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ZhangYiFan
 * @Date 2023/3/28 14:24
 * @description:
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(new BigDecimal("123.4", new MathContext(4,
                RoundingMode.HALF_UP)));
        System.out.println(new BigDecimal("123.4", new MathContext(2,
                RoundingMode.HALF_UP)));
        System.out.println(new BigDecimal("123.4", new MathContext(2,
                RoundingMode.CEILING)));
        System.out.println(new BigDecimal("123.4", new MathContext(1,
                RoundingMode.CEILING)));
    }

    @org.junit.jupiter.api.Test
    public void Test1(){
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(20);
        lista.add(3);
        lista.add(5);
        lista.add(6);
        lista.add(14);
        lista.add(19);
        Collections.sort(lista);
        getContinuousNum(lista);

    }
    //将存放数字的List，判断List中的数字是否是连续的，并分组输出连续的数字
    public static void getContinuousNum(List<Integer> lista){
        List<Integer> listb = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (i == 0){
                listb.add(lista.get(i));
            }else {
                if (lista.get(i) - lista.get(i-1) == 1){
                    listb.add(lista.get(i));
                }else {
                    System.out.println(listb);
                    listb.clear();
                    listb.add(lista.get(i));
                }
            }
        }
        System.out.println(listb);
    }
   //   将存放数字的List排序,判断List中的数字是否是连续的,并分组输出连续的数字
    public static void getContinuousNum2(List<Integer> lista){
        List<Integer> listb = new ArrayList<>();
        Collections.sort(lista);
        for (int i = 0; i < lista.size(); i++) {
            if (i == 0){
                listb.add(lista.get(i));
            }else {
                if (lista.get(i) - lista.get(i-1) == 1){
                    listb.add(lista.get(i));
                }else {
                    System.out.println(listb);
                    listb.clear();
                    listb.add(lista.get(i));
                }
            }
        }
        System.out.println(listb);
    }







}
