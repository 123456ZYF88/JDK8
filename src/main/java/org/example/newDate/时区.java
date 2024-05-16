package org.example.newDate;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;



/**
 * @author zhangyf
 * @date 2024/5/13 20:00
 */

public class 时区 {
    // Java8 中加入了对时区的支持，LocalDate、LocalTime、LocalDateTime是不带时区的
    // 带时区的日期时间类分别为：ZonedDate、ZonedTime、ZonedDateTime

    // 其中每个时区都对应着 ID，ID的格式为 “区域/城市” 。例如 ：Asia/Shanghai 等

    // ZoneId：该类中包含了所有的时区信息

    @Test
    public void test01() {
        // 获取所有的时区ID
        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        //不待时间，获取计算机当前时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);//now = 2024-05-13T20:08:05.930


        //操作带时区的类
       // now(Clock.systemUTC());
        ZonedDateTime bz = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("bz = " + bz);//2024-05-13T12:09:48.769Z

        //now（）:使用计算机的默认的时区，创建时间
        ZonedDateTime now1 = ZonedDateTime.now();
        System.out.println("now1 = " + now1);//now1 = 2024-05-13T20:13:06.959+08:00[Asia/Shanghai]

        //指定地区时区创建时间
        ZonedDateTime now2 = ZonedDateTime.now(ZoneId.of("America/Vancouver"));
        System.out.println("now2 = " + now2);//now2 = 2024-05-13T05:13:06.960-07:00[America/Vancouver]
    }


}
