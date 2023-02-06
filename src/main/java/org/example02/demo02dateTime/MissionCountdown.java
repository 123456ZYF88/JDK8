package org.example02.demo02dateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 任务倒计时
 * @date 2022/5/19 10:38
 */
public class MissionCountdown {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// 自定义时间格式
        String dbTime = "2022年5月20日16：18";
        String resultStr = "";
        Pattern p = Pattern.compile("月(\\w+)日");
        Matcher m = p.matcher(dbTime);
        int day1 = 0;
        while (m.find()) {
            day1 = Integer.parseInt(m.group(1));
        }
        String nowDay = simpleDateFormat.format(new Date());
        int day2 = Integer.parseInt(nowDay.substring(nowDay.lastIndexOf("-") + 1));
        if (day1 - day2 == 2) {
            resultStr = "后天" + dbTime.substring(dbTime.lastIndexOf("日") + 1);
        } else if (day1 - day2 == 1) {
            resultStr = "明天" + dbTime.substring(dbTime.lastIndexOf("日") + 1);
        } else if (day1 - day2 == 0) {
            resultStr = "今天" + dbTime.substring(dbTime.lastIndexOf("日") + 1);
        } else {
            resultStr = dbTime;
        }
        System.out.println(resultStr);
    }
}
