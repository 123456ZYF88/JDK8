package org.example.newDate;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhangyf
 * @date 2024/5/13 17:17
 */

public class DateOrDate {
    //日期比较
    @Test
    public void test01() {
        // 在JDK8中，LocalDate类中使用isBefore()、isAfter()、equals()方法来比较两个日期，可直接进行比较。
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2024, 5, 1);

        System.out.println(now.isAfter(date));
        System.out.println(now.isBefore(date));
        System.out.println(now.equals(date));
        System.out.println( "--------------");

        if (now.isBefore(date)) {
            System.out.println("现在时间早于2024年5月1日");
        } else if (now.isAfter(date)) {
            System.out.println("现在时间晚于2024年5月1日");
        } else {
            System.out.println("现在时间等于2024年5月1日");
        }

    }
    //时间格式化与解析
    @Test
    public void test02() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);//2024-05-13T17:25:36.881
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String format = now.format(dateTimeFormatter);
        System.out.println(format);//2024年05月13日
        String parse = now.format(dateTimeFormatter1);
        System.out.println(parse);//2024-05-13 17:25:36

        LocalDateTime parse1 = LocalDateTime.parse("2024-05-13 17:25:36", dateTimeFormatter1);
        System.out.println(parse1);//2024-05-13T17:25:36

    }
}
