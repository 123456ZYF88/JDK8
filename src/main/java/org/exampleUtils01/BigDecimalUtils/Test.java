package org.exampleUtils01.BigDecimalUtils;

import org.apache.commons.lang3.Validate;

import java.util.*;

/**
 * @Author ZhangYiFan
 * @Date 2023/3/28 14:24
 * @description:
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

//        System.out.println(new BigDecimal("123.4", new MathContext(4,
//                RoundingMode.HALF_UP)));
//        System.out.println(new BigDecimal("123.4", new MathContext(2,
//                RoundingMode.HALF_UP)));
//        System.out.println(new BigDecimal("123.4", new MathContext(2,
//                RoundingMode.CEILING)));
//        System.out.println(new BigDecimal("123.4", new MathContext(1,
//                RoundingMode.CEILING)));


        String s = create("123", "123", 123, 48 * 60 * 60 * 1000 * 24 * 30);
        System.out.println(s);

    }
    public static <T> String create(String id, String subject, T data, long ttl) {


        Date now = new Date();
        Date expirationDate =  addMilliseconds(now, (int) ttl);
        return  expirationDate.toString();
    }
    public static Date addMilliseconds(  Date date, final int amount) {
        return add(date, Calendar.MILLISECOND, amount);

    }
    private static Date add(final Date date, final int calendarField, final int amount) {
        validateDateNotNull(date);
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }
    private static void validateDateNotNull(final Date date) {
        Validate.notNull(date, "The date must not be null");
    }

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
