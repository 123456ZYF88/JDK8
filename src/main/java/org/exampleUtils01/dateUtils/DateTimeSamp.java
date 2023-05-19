package org.exampleUtils01.dateUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Author ZhangYiFan
 * @Date 2023/5/19 14:00
 * @description: 时间戳操作
 * @Version 1.0
 */
public class DateTimeSamp {
    /**
     * @author zhangYiFan
     * @param timestampString  字符时间参数
     * @param formats 时间格式
     * @return 毫秒及时间戳
     */
    public static long TIME_STAMP(String timestampString, String formats) {
        LocalDateTime parse = LocalDateTime.parse(timestampString, DateTimeFormatter.ofPattern(formats));
        return parse.toInstant(ZoneOffset.of("+8")).toEpochMilli();//东8
    }

    /**转换字符串 yyyyMMddHHmmss
     * Java将Unix时间戳 转换 成指定格式日期字符串 现在是毫秒级时间戳，只需改变乘数为1000就可转换为秒级时间戳
     * @param timestampString 时间戳 如：e"1678374000000";
     * @param formats 要格式化的格式 默认："yyyyMMddHHmmss";
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String TimeStamp2Date(String timestampString, String formats) {
        if (formats.isEmpty()) {
            formats = DTMode.YYYYMMDDHHMMSS;
        }
        Long timestamp = Long.parseLong(timestampString) * 1;
        return   new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
    }

    /**
     * 计算本月第一天0点的时间戳
     * @return
     */
    public static Long timeStampDateAdd() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONDAY), calendar.get(Calendar.DAY_OF_MONTH), 0, 0,0);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        long tt = calendar.getTime().getTime();
        System.out.println(tt);
        return tt;
    }

    /**
     * 获取上n个小时整点小时的毫秒级时间戳
     *
     * @param n 往前几个小时
     * @return 十位时间戳
     */
    public static long getLastHourTime(int n) {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);

        ca.set(Calendar.MILLISECOND, 0);
        ca.set(Calendar.HOUR_OF_DAY, ca.get(Calendar.HOUR_OF_DAY) - n);
        return   ca.getTimeInMillis()  ;
    }

}
