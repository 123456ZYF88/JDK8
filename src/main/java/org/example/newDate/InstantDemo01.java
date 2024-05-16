package org.example.newDate;

import org.junit.jupiter.api.Test;


import java.time.*;
import java.time.temporal.TemporalAdjuster;

/**
 * Instant 时间戳/时间线，内部保存了从1970年1月1日 00:00:00以来的秒和纳秒
 *
 * @author zhangyf
 * @date 2024/5/13 17:27
 */

public class InstantDemo01 {

    /**
     * 时间戳 APi Instant
     */
    @Test
    public void test01() {
        Instant now = Instant.now();
        System.out.println(now);//2024-05-13T11:07:42.621Z

        //时间戳从1970年1月1日 00:00:00开始
        System.out.println(now.getNano());//621000000  纳秒
        System.out.println(now.getEpochSecond());//秒
        System.out.println(now.toEpochMilli());//毫秒
        System.out.println(now.toEpochMilli() / 1000);
        System.out.println(System.currentTimeMillis());


        Instant instant = Instant.ofEpochSecond(1);
        System.out.println(instant);//1970-01-01T00:00:01Z

    }

    /**
     * JDK 8的计算日期时间差类
     */

    @Test
    public void test02() {
        /*
        *Duration/Period类: 计算日期时间差。
            1. Duration：用于计算2个时间(LocalTime，时分秒)的距离
            *
            2. Period：用于计算2个日期(LocalDate，年月日)的距离 */
        //Duration 计算时间的距离
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime time = LocalTime.of(10, 10, 10);
        System.out.println(time);
        Duration between = Duration.between(time, now);
        System.out.println("----------------");
        System.out.println(between);
        System.out.println("相差的天数:" + between.toDays());
        System.out.println("相差的小时数:" + between.toHours());
        System.out.println("相差的分钟数:" + between.toMinutes());
        System.out.println("相差的秒数:" + between.getSeconds());

        //Period 计算日期的差
        LocalDate now1 = LocalDate.now();
        LocalDate localDate = LocalDate.of(2024, 5, 15);
        Period between1 = Period.between(now1, localDate);
        System.out.println(between1);
        System.out.println("相差的天数:" + between1.getDays());
        System.out.println("相差的月数:" + between1.getMonths());
        System.out.println("相差的年数:" + between1.getYears());
    }
    /*
    *
    *between
    * 获取表示两个时间对象之间的持续时间的持续时间。
        这将计算两个时间对象之间的持续时间。如果对象的类型不同，则会根据第一个对象的类型计算持续时间。例如，如果第一个参数是LocalTime，则第二个参数将转换为LocalTime。
        指定的临时对象必须支持SECONDS单位。为了完全准确，应支持NANOS单元或NANO_OF_SECOND字段。
        如果结束在开始之前，则此方法的结果可能是负周期。为了保证获得正的持续时间，请对结果调用abs（）。
        参数：
        startInclusive–起始时刻，inclusive，not null endExclusive–结束时刻，exclusive，not null
        退货：
        a持续时间，不为空
        投掷：
        DateTimeException–如果无法获得temporal之间的秒数
        ArithmeticException–如果计算超出Duration的容量
    * */

    /**
     *  "时间矫正器" :"TemporalAdjuster"
     * 有时我们可能需要获取例如：将日期调整到“下一个月的第一天”等操作。可以通过时间校正器来进行。
     * TemporalAdjuster :时间校正器。
     * TemporalAdjusters :该类通过静态方法提供了大量的常用TemporalAdjuster的实现。
     */
    @Test
    public void test03() {
        // TemporalAdjuster类:自定义调整时间

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);//2024-05-13T19:59:41.611

        //得到下一个月的第一天
        TemporalAdjuster firstDayOfNextMonth =  temporal -> {
            LocalDateTime temporal1 = (LocalDateTime) temporal;
            LocalDateTime localDateTime = temporal1.plusMonths(1).withDayOfMonth(1);
            System.out.println("第一天"+localDateTime);//第一天2024-06-01T19:59:41.611
            return localDateTime;
        };

        LocalDateTime with = now.with(firstDayOfNextMonth);
        System.out.println(with);

    }

}
