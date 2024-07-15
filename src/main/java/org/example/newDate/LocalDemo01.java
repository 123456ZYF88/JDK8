package org.example.newDate;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;

/**
 * 本地时间类
 *
 * @author zhangyf
 * @date 2024/5/13 16:52
 */

public class LocalDemo01 {

    // LocalDate:获取日期时间的信息。格式为 2019-10-16,yyyy-MM-dd(经常使用)
    @Test
    public void test01() {

        LocalDateTime dateTime = LocalDateTime.now();
        //获取年月日字符串
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd")));

        //指定日期
        LocalDate localDate = LocalDate.of(2019, 10, 16);
        //2019-10-16
        System.out.println(localDate);


        //当前日期
        LocalDate localDate1 = LocalDate.now();
        //2024-05-25
        System.out.println(localDate1);

        //获取时间信息
        //2024
        System.out.println(localDate1.getYear());
        //5
        System.out.println(localDate1.getMonthValue());
        //25
        System.out.println(localDate1.getDayOfMonth());
        //SATURDAY
        System.out.println(localDate1.getDayOfWeek());
        //146
        System.out.println(localDate1.getDayOfYear());
        //检查年份是否为闰年。
        //true
        System.out.println(localDate1.isLeapYear());

    }

    // LocalTime:获取日期时间的信息。格式为 10:16:09,HH:mm:ss
    @Test
    public void test02() {
        LocalTime localTime = LocalTime.of(10, 16, 9);
        System.out.println(localTime);
        // 得到指定的时间
        LocalTime time = LocalTime.of(12, 15, 28, 129_900_000);
        System.out.println("time = " + time);

        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1);
        System.out.println(localTime1.getHour());
        System.out.println(localTime1.getMinute());
        System.out.println(localTime1.getSecond());
        System.out.println(localTime1.getNano());
        System.out.println(localTime1.plusHours(2));
        System.out.println(localTime1.minusHours(2));
        System.out.println(localTime1.plusMinutes(2));
        System.out.println(localTime1.minusMinutes(2));
        System.out.println(localTime1.plusSeconds(2));
        System.out.println(localTime1.minusSeconds(2));
        System.out.println(localTime1.plusNanos(2));
        System.out.println(localTime1.minusNanos(2));
    }

    //LocalDateTime :获取日期时间的信息。LocalDateTime格式为yyyy-mm-ddTHH:mm:ss.n
    @Test
    public void test03() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 10, 16, 10, 16, 9);
        System.out.println(localDateTime);//2019-10-16T10:16:09

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);//2024-05-13T17:08:27.455

        System.out.println(localDateTime1.getYear());
        System.out.println(localDateTime1.getMonthValue());
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getDayOfYear());
        //......
    }

    /*对日期时间的修改，对已存在的LocalDate对象，创建它的修改版，最简单的方式是使用withAttribute方法。
    withAttribute方法会创建对象的一个副本，并按照需要修改它的属性。以下所有的方法都返回了一个修改属性的对
    象，他们不会影响原来的对象。*/
    @Test//修改日期
    public void test04() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);


        String format = "202406";
        LocalDateTime localDateTime = now.withYear(Integer.parseInt(format.substring(0, 4)));
        System.out.println("修改年份" + localDateTime);//修改年份2042-05-13T17:13:45.887
        localDateTime = localDateTime.withMonth(Integer.parseInt(format.substring(4, 6)));
        //获取这个月的最后一天
        //localDateTime = localDateTime.withDayOfMonth(localDateTime.getMonth().length(localDateTime.isLeapYear()));
        System.out.println("修改月份" + localDateTime);//修改月份2024-12-13T17:13:45.887


// 假设你已经有了一个LocalDateTime对象
        LocalDateTime localDateTime2 = LocalDateTime.now(); // 获取当前时间

// 将日期设置为当月的最后一天
        LocalDateTime lastDayOfMonth = localDateTime2.with(TemporalAdjusters.lastDayOfMonth());

// 输出结果
        System.out.println("Last day of the month: " + lastDayOfMonth);
        String k1 = "10";
        String[] split = k1.split(",");
        System.out.println(Arrays.toString(split));

        //再当前对象的基础上加上或减去指定的时间
        LocalDateTime localDateTime3 = now.plusDays(5);
        System.out.println("5天后: " + localDateTime3);
        System.out.println("now == localDateTime: " + (now == localDateTime3));
        System.out.println("10年后: " + now.plusYears(10));
        System.out.println("20月后: " + now.plusMonths(20));
        System.out.println("20年前: " + now.minusYears(20));
        System.out.println("5月前: " + now.minusMonths(5));
        System.out.println("100天前: " + now.minusDays(100));
        //减一分钟
        System.out.println("减一分钟: " + now.minusMinutes(1));
        //获得今年第一天
        LocalDateTime localDateTime4 = now.withDayOfYear(1);
        System.out.println(localDateTime4);
    }




}
