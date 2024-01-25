package org.exampleUtils01.dateUtils;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.exampleUtils01.exception.CustomException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.exampleUtils01.dateUtils.DTMode.*;

/**
 * @description: 工具类 - 日期工具类
 * @version V1.0
 */
public final class DateUtil {



    //静态块初始化方式：
    private static DateUtil gson = null;
    static {
        if (gson == null) {
            gson = new DateUtil();
        }
    }
    private DateUtil() {
    }

    /*获取时间yyyMMddHHmmssSSS*/
    public static String getIFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat(DTMode.DATE_SIGN);
        return sdf.format(new Date());
    }

    /**
     * 获取当前日期（零时零分零秒）
     *
     * @return 当前日期（零时零分零秒）
     */
    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    public static Date getCurrentDateTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 获取当前时间（yyyy-MM-dd HH:mm:ss）
     *
     * @return 当前时间
     */
    public static String getCurrentDateTimeString() {
        return day2String(getCurrentDateTime());
    }

    /**分
     * date 多少分钟之前的日期
     *
     * @param date   日期
     * @param minute
     * @return
     */
    public static Date beforMinute(Date date, int minute) {
        return handleMinute(date, -minute);
    }

    /**分
     * date 多少分钟后的日期
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date afterMinute(Date date, int minute) {
        return handleMinute(date, Math.abs(minute));
    }

    /**
     * 处理日期
     *
     * @param date   日期
     * @param minute 分钟
     * @return
     */
    private static Date handleMinute(Date date, int minute) {
        if (null == date) {
            date = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);
        return cal.getTime();
    }

    /**天
     * date  多少天之前或之后的日期
     *
     * @param date 日期
     * @param day 多少天 可以为负
     * @param dateFormat 时间格式
     * @return
     */
    public static Date beforeAndAfterDay(Date date, int day,String dateFormat) {
        Date nowDate = handleDay(date, day);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
        return nowDate;
    }

    /**
     * 月 多少月之前或之后的日期
     *
     * @param date  日期
     * @param month 多少月 可以为负
     * @param dateFormat 时间格式
     * @return
     */
    public static Date beforeAndAfterMonth(Date date, int month,String dateFormat) {
        Date nowDate = handleMonth(date, month);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
        return nowDate;
    }

    /**
     * 年 多少年之前或之后的日期
     *
     * @param date 日期
     * @param year 多少年 可以为负
     * @param dateFormat 时间格式
     * @return
     */
    public static Date beforeAndAfterYear(Date date, int year,String dateFormat) {
        Date nowDate = handleYear(date, year);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
        return nowDate;
    }


    /**
     * 时 多少年之前或之后的日期
     *
     * @param date   日期
     * @param minute
     * @param dateFormat 时间格式
     * @return
     */
    public static Date beforeAndAfterHour(Date date, int minute,String dateFormat) {
        Date nowDate = handleHour(date, minute);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
            return new Date();
        }
        return nowDate;
    }


    /**
     * @description: 获取当前日期的年or月份or周or日等
     * @param: date
     * @param calendarInt
     * @return 根据calendarInt返回对应结果
     */
    public static int getDaysOfMonth2(String date,int calendarInt) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy");
        try {
            calendar.setTime(simpleDate.parse(date)); //要计算你想要的月份，改变这里即可
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getActualMaximum(calendarInt);
    }

    /**
     * 月
     * @param date
     * @return 该月有多少天
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);//获取月中的天，取最大值，比如1月就是31
    }



    /**
     * 月
     * @param date 时间
     * @param dateFormat 时间格式
     * @return 返回该月有多少天
     */
    public static int getDaysOfMonth(String date,String dateFormat) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat(dateFormat);
        try {
            calendar.setTime(simpleDate.parse(date)); //要计算你想要的月份，改变这里即可
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH); //获取月中的天，取最大值，比如1月就是31
    }



    /**
     * 年 该年的最后一月
     * @param date
     * @return 返回最大月，
     */
    public static int getDaysOfMonth2(String date) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy");
        try {
            calendar.setTime(simpleDate.parse(date)); //要计算你想要的月份，改变这里即可
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getActualMaximum(Calendar.MONTH)+1;
    }

    /**
     * 获取当前年份的所有月份
     * @return
     */
    public static List<String> getYearFullMonth() {
        List<String> monthList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat(DTMode.FORMAT_DATE_YEAR_MONTH_TWO);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.YEAR,cal.get(Calendar.YEAR));
        cal.set(Calendar.MONTH, 0);
        for(int i=0;i<12;i++){
            monthList.add(sdf.format(cal.getTime()));
            cal.add(Calendar.MONTH, 1);
        }
        return monthList;
    }


    /**
     * 处理日期小时变化
     *
     * @param date 日期
     * @param hour 小时数
     * @return
     */
    private static Date handleHour(Date date, int hour) {
        if (null == date) {
            date = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, hour);
        return cal.getTime();
    }

    /**
     * 处理日期天数变化
     *
     * @param date 日期
     * @param day  天数
     * @return
     */
    private static Date handleDay(Date date, int day) {
        if (null == date) {
            date = new Date();
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.DAY_OF_YEAR, day);
        return gc.getTime();
    }

    /**
     * 处理月份变化
     *
     * @param date  日期
     * @param month 月数
     * @return
     */
    private static Date handleMonth(Date date, int month) {
        if (null == date) {
            date = new Date();
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.MONTH, month);
        return gc.getTime();
    }

    /**
     * 处理年份变化
     *
     * @param date 日期
     * @param year 年数
     * @return
     */
    private static Date handleYear(Date date, int year) {
        if (null == date) {
            date = new Date();
        }
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.add(Calendar.YEAR, year);
        return gc.getTime();
    }

    /**
     * 日期补00
     *
     * @param date yyyy-MM-dd HH:mm
     * @return  yyyy-MM-dd HH:mm:ss
     */
    public static String dateComplete(String date) {
        try {
            if (StringUtils.isBlank(date)) {
                return null;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat newFormatter = new SimpleDateFormat(DTMode.DATE_FORMAT);
            Date dateDate = formatter.parse(date);
            date = newFormatter.format(dateDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    /** 日期补全  自定义
     *
     * @param date 目标时间             2023-04-25 14:17
     * @param startFormat 目标时间格式 yyyy-mm-dd HH:mm
     * @param endFormat 补全时间格式 yyyy-mm-dd HH:mm:ss
     * @return 补全后时间            2023-17-25 14:17:00
     */
    public static String dateComplete(String date,String startFormat,String endFormat) {
        try {
            if (StringUtils.isBlank(date)) {
                return null;
            }
            SimpleDateFormat formatter = new SimpleDateFormat(startFormat);
            SimpleDateFormat newFormatter = new SimpleDateFormat(endFormat);
            Date dateDate = formatter.parse(date);
            date = newFormatter.format(dateDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    /**获得字符串日期
     * 日期转化为固定格式的字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String day2String(Date date) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(DTMode.DATE_FORMAT);
        return formatter.format(date);
    }

    /**转字符串DTMode.DTMode.YYYYMMDDHHMMSS
     * 日期转化为固定格式的字符串 DTMode.DTMode.YYYYMMDDHHMMSS
     *
     * @param date
     * @return
     */
    public static String day2String(Date date, String format) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    /**
     * 字符串转换日期
     *
     * @param date
     * @param format
     * @return
     * @throws Exception
     */
    public static Date stringToDate(String date, String format) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        if (date.length() == 10) {
            date += " 00:00:00";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串转换日期
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static Date stringToDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        return stringToDate(date, DTMode.DATE_FORMAT);
    }




    /**比较当前时间
     *
     * @param date
     * @return   比当前日期大为true
     */
    public static boolean compareDate(Date date) {
        if (date == null) {
            return false;
        }
        return date.compareTo(new Date()) > 0;
    }




    /** 比较时间大小
     * 第一个时间参数和第二个参数比较，第一个大于第二个返回true小于返回false
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static Boolean compareDate(Date beginDate, Date endDate) {
        if (beginDate == null) {
            beginDate = new Date();
        }
        if (endDate == null) {
            endDate = new Date();
        }
        return endDate.compareTo(beginDate) > 0;
    }


    /**
     * 日期减法 获得毫秒值日期 （ 注意 减数不能为空为空就报错）
     * /1000/60/60/24之后为日
     * @param minuend 被减数 20230428
     * @param meiosis 减数 20230426
     * @return 172800000
     */
    public static long dateSubtraction(Date minuend, Date meiosis) {
        if (DateUtil.compareDate(minuend)) {
             return minuend.getTime() - meiosis.getTime();
        } else {
            return 0;
        }
    }

    /**
     * 日期减法 获得毫秒值日期
     * /1000/60/60/24之后为日
     * @param minuend 被减数 20230428
     * @param meiosis 减数 20230426
     * @return 172800000
     */
    public static long subtractDate(Date minuend, Date meiosis) {
        if (minuend == null || meiosis == null) {
            return 0;
        } else {
            return minuend.getTime() - meiosis.getTime();
        }
    }

    /**
     * 把毫秒转化成自定义格式日期
     *
     * @param dateFormat  yyyy/MM/dd HH:mm:ss
     * @param millSec(毫秒数)  1682487107000
     * @return  2023/04/26 13:31:47
     */
    public static String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    /**
     * 给定一个日期，返回加减n天后的日期
     * @param basicDate 20230426
     * @param n 2
     * @return Fri Apr 28 00:00:00 CST 2023 = 20230428
     */
    public static Date nDaysAfterOneDate(Date basicDate, int n) {
        if (basicDate == null) return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(basicDate);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }
    // 返回字符串版本
    public static String nDaysAfterOneDate(Date basicDate, int n,String stringDateFormat) {
        if (basicDate == null) return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(basicDate);
        cal.add(Calendar.DATE, n);
        SimpleDateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
        return  dateFormat.format(cal.getTime());
    }

    /**
     * 给定一个日期，返回加减n分钟后的日期
     * @param basicDate 202304261348
     * @param n 2
     * @return 转换后 202304260150 无法区分24小时公司
     */
    public static Date nMinAfterOneDate(Date basicDate, int n) {
        if (basicDate == null) return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(basicDate);
        cal.add(Calendar.MINUTE, n);
        return cal.getTime();
    }


    /**转换Date为年月字符串字符串
     * @param date Wed Apr 26 13:50:00 CST 2023
     * @return  202304
     * @description    转换Date为年月字符串字符串 改变substring来获得更高精度日期字符串
     */
    public static String getYearAndMonthStr(Date date) {
        String nowStr = DateUtil.day2String(date);
        if (StringUtils.isEmpty(nowStr)) {
            return "";
        }
        return nowStr.substring(0, 7).replace("-", "");
    }


    /**月
     * 获取月第一天
     * @param date
     * @return
     */
    public static String getMonthFirstDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD);
        return formatter.format(c.getTime());
    }

    /**
     *  获取上个月的第一天
     * @param date
     * @return
     */
    public static String getLastMonthFirstDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD);
        return   formatter.format(c.getTime());
    }

    /**
     * MM 获取月份最后一天
     * @param date
     * @return
     */
    public static String getMonthLastDay(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD);
        return format.format(c.getTime());
    }

    /**
     * MM 获取上月最后一天
     * @param date
     * @return
     */
    public static String getLastMonthLastDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD);
         return  format.format(c.getTime());
    }

    /**日期时间差
     * 可以区分24小时格式
     * @param beginDate 202304260248， 20230426
     * @param endDate 202304261348， 20230427
     * @return 11小时 ，1天
     */
    public static String DatesBetween(Date beginDate, Date endDate) {
        String dateString = "";
        if (beginDate == null || endDate == null) {
            return dateString;
        }
        long between = (endDate.getTime() - beginDate.getTime()) / 1000;//除以1000是为了转换成秒
        long day = between / (24 * 3600);
        long second = between % (24 * 3600);
        BigDecimal hour = BigDecimal.valueOf(second).divide(BigDecimal.valueOf(3600), 2, BigDecimal.ROUND_HALF_UP);
        if (day != 0) {
            dateString = day + "天";
        }
        if (BigDecimal.ZERO.compareTo(hour) != 0) {
            dateString += (hour + "小时");
        }
        return dateString;
    }


    /**转字符串
     * 日期时间格式化成字符串
     * @param dateTime 1970-1-20 19:21:27
     * @return 1970120192127
     */
    public static String formatStringToString(String dateTime) {
        if (StringUtils.isNotBlank(dateTime)) {
            return dateTime.replace(" ", "").replace(":", "").replace("-", "");
        } else {
            return null;
        }

    }

    /**转字符串 自定义
     * 日期字符串格式化
     *
     * @param dateString     日期字符串 1970-1-20 19:21:27
     * @param originalFormat 日期字符串原来格式 yyyy-MM-dd HH:mm:ss
     * @param newFormat      日期字符串新的格式 DTMode.YYYYMMDD HHmmss
     * @return 格式化后的日期字符串 19700120 192127
     * @throws ParseException
     */
    public static String formatDateString(String dateString, String originalFormat, String newFormat)
            throws ParseException {
        Date sourceDate = new SimpleDateFormat(originalFormat).parse(dateString);
        return new SimpleDateFormat(newFormat).format(sourceDate);
    }

    /**
     * 随机数
     */
    private static final Random random = new Random();
    public static Long randomLong(){
        return random.nextLong();
    }


    /**
     * 取两个日期之间的随机日期
     * 为空返回最新时间
     * @param firstDate
     * @param secondDate
     * @return
     */
    public static Date getDateRandomBetween(Date firstDate, Date secondDate)    {
        if (firstDate == null || secondDate == null) {
            return new Date();
        }
        if (firstDate.getTime() - secondDate.getTime() == 0) {
            return firstDate;
        }
        long randomDate = 0;
        long randomLong = randomLong();  //实际操作时注意随机数方法
        long rand = Math.abs(randomLong % (firstDate.getTime() - secondDate.getTime()));
        if (firstDate.getTime() - secondDate.getTime() <= 0) {
            randomDate = firstDate.getTime() + (rand < 1000 ? 1000 : rand);
        } else {
            randomDate = secondDate.getTime() + (rand < 1000 ? 1000 : rand);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(randomDate);
        return calendar.getTime();
    }

    /**
     * 取某个日期的天数
     *
     * @param date 20230426
     * @return 26
     */
    public static int getDay(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DATE);
    }


    /**
     * 秒 多少秒之前的日期
     *
     * @param date   日期
     * @param second
     * @return
     */
    public static Date beforeSecond(Date date, int second) {
        return handleSecond(date, -second);
    }

    /**
     * 秒 多少秒后的日期
     *
     * @param date
     * @param second
     * @return
     */
    public static Date afterSecond(Date date, int second) {
        return handleSecond(date, Math.abs(second));
    }

    /**
     *
     * @param date
     * @param second
     * @return
     */
    private static Date handleSecond(Date date, int second) {
        if (null == date) {
            date = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, second);
        return cal.getTime();
    }


    /**
     * 计算两个时间之间相差的天数
     *
     * @param minuend 被减数
     * @param meiosis 减数
     * @return
     */
    public static long getDateDifferenceDay(Date minuend, Date meiosis) {
        long difference = DateUtil.subtractDate(minuend, meiosis);
        return difference / (1000 * 3600 * 24);
    }


    public static String getDateRandomBetween(LocalDateTime startTime, LocalDateTime endTime) throws CustomException {
        if (startTime == null || endTime == null) {
            throw new CustomException("-1", "日期不能为空！");
        }
        long sTime = startTime.toEpochSecond(ZoneOffset.UTC);
        long eTime = endTime.toEpochSecond(ZoneOffset.UTC);
        if (sTime == eTime) {
            return startTime.format(DTMode.YYYY_MM_DDHHmmss);
        }
        long rand = RandomUtils.nextLong(sTime, eTime);
        return LocalDateTime.ofEpochSecond(rand, 0, ZoneOffset.UTC).format(DTMode.YYYY_MM_DDHHmmss);
    }

    /**
     * 根据年 月 获取对应的月份 最大天数
     */
    public static int getMaxDayByYearMonth(int year, int month) {

        Calendar a = Calendar.getInstance();

        a.set(Calendar.YEAR, year);

        a.set(Calendar.MONTH, month - 1);

        a.set(Calendar.DATE, 1);

        a.roll(Calendar.DATE, -1);

        return  a.get(Calendar.DATE);

    }
    /**
     * 根据时间获得当月开始时间和结束时间
     * @param dateTime
     * @return
     * @throws ParseException
     */
    public static Map<String,Object> getMonthStartTimeByDate(String dateTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DTMode.YYYYMMDD);
        Date date = simpleDateFormat.parse(dateTime);
        long currentTime = date.getTime();
        String timeZone = "GMT+8:00";
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(currentTime);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long timeInMillis = calendar.getTimeInMillis();
        Date resultStartDate = new Date(timeInMillis);
        String resultStartTime = simpleDateFormat.format(resultStartDate);
        Calendar calendar2 = Calendar.getInstance();// 获取当前日期
        calendar2.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar2.setTimeInMillis(currentTime);
        calendar2.add(Calendar.YEAR, 0);
        calendar2.add(Calendar.MONTH, 0);
        calendar2.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));// 获取当前月最后一天
        calendar2.set(Calendar.HOUR_OF_DAY, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        calendar2.set(Calendar.MILLISECOND, 999);
        long timeInMillis2 = calendar2.getTimeInMillis();
        Date resultEndDate = new Date(timeInMillis2);
        String resultEndTime = simpleDateFormat.format(resultEndDate);
        Map<String,Object> map = new HashMap<>();
        map.put("startDate", resultStartTime);
        map.put("endDate", resultEndTime);
        return map;

    }
    /**根据开始时间和结束时间获得之间的每个月的月初和月末
     * 根据传入的参数，来对日期区间进行拆分，返回拆分后的日期List
     * @param statisticsType 周或 者月
     * @param startDate 开始时间 20230105
     * @param endDate 介绍时间 20230405
     * @return
     * @throws ParseException
     */
    public static List<String> dateSplitting(String statisticsType, String startDate, String endDate) {
        List<String> listWeekOrMonth = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat(DTMode.YYYYMMDD);
         Calendar sCalendar = Calendar.getInstance();
        sCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        Date eDate =null;
        Date sDate =null;
         try {
            eDate = dateFormat.parse(endDate);
            sDate = dateFormat.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sCalendar.setTime(sDate);
        Calendar eCalendar = Calendar.getInstance();
        eCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        eCalendar.setTime(eDate);
        boolean bool =true;
        if(statisticsType.equals("week")){
            while(sCalendar.getTime().getTime()<eCalendar.getTime().getTime()){
                if(bool||sCalendar.get(Calendar.DAY_OF_WEEK)==2||sCalendar.get(Calendar.DAY_OF_WEEK)==1){
                    listWeekOrMonth.add(dateFormat.format(sCalendar.getTime()));
                    bool = false;
                }
                sCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
            if(listWeekOrMonth.size()%2!=0){
                listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
            }
        }else{
            while(sCalendar.getTime().getTime()<eCalendar.getTime().getTime()){
                if(bool||sCalendar.get(Calendar.DAY_OF_MONTH)==1||sCalendar.get(Calendar.DAY_OF_MONTH)==sCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)){
                    listWeekOrMonth.add(dateFormat.format(sCalendar.getTime()));
                    bool = false;
                }
                sCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
            if(listWeekOrMonth.size()%2!=0){
                listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
            }
        }
        return listWeekOrMonth;
    }



    /**
     * 根据传入的参数，来对日期区间进行拆分，返回拆分后的日期List
     * @param statisticsType
     * @param map
     * @return
     * @throws ParseException
     * @author lihq 2019-6-24
     */
    public List<String> doDateByStatisticsType(String statisticsType,Map<String, Object> map) throws ParseException{
        List<String> listWeekOrMonth = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
        String startDate = (String)map.get("startDate");
        String endDate = (String)map.get("endDate");
        Date sDate = dateFormat.parse(startDate);
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        sCalendar.setTime(sDate);
        Date eDate = dateFormat.parse(endDate);
        Calendar eCalendar = Calendar.getInstance();
        eCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        eCalendar.setTime(eDate);
        boolean bool =true;
        if(statisticsType.equals("week")){
            while(sCalendar.getTime().getTime()<eCalendar.getTime().getTime()){
                if(bool||sCalendar.get(Calendar.DAY_OF_WEEK)==2||sCalendar.get(Calendar.DAY_OF_WEEK)==1){
                    listWeekOrMonth.add(dateFormat.format(sCalendar.getTime()));
                    bool = false;
                }
                sCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
            if(listWeekOrMonth.size()%2!=0){
                listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
            }
        }else{
            while(sCalendar.getTime().getTime()<eCalendar.getTime().getTime()){
                if(bool||sCalendar.get(Calendar.DAY_OF_MONTH)==1||sCalendar.get(Calendar.DAY_OF_MONTH)==sCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)){
                    listWeekOrMonth.add(dateFormat.format(sCalendar.getTime()));
                    bool = false;
                }
                sCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
            if(listWeekOrMonth.size()%2!=0){
                listWeekOrMonth.add(dateFormat.format(eCalendar.getTime()));
            }
        }

        return listWeekOrMonth;
    }


    /**
     * 截取 字符串斜杠
     * @param date 2023-04-25
     * @return 20230425
     */
    public static String intercept(String date){
          return date.replaceAll("[[\\s-:punct:]]","");
    }



    /**
     * 时间戳 三分钟循环操作
     */
    @Test
    public void circulateMillisecond(){
        SimpleDateFormat sdf = new SimpleDateFormat(DTMode.YYYYMMDDHHMMSS);
        SimpleDateFormat df = new SimpleDateFormat(DTMode.YYYYMMDD);
        Calendar calendar = Calendar.getInstance();
        String beginDate = "开始时间";
        String endDate = "结束时间";
        try {
            calendar.setTime(df.parse(beginDate));
            while (true) {
                String date = df.format(calendar.getTime());

                ArrayList<Long> list = new ArrayList<>();
                calendar.setTime(sdf.parse(date+"000000"));
                long startTime = calendar.getTimeInMillis();
                list.add(startTime);
                for (int i = 1;i<481;i++){
                    startTime += 180000;
                    list.add(startTime);
                }
                HashMap<String,Object> queryMap = new HashMap<>();
                for (int i = 0; i <list.size()-1 ; i++) {
                    queryMap.put("startTime",list.get(i));
                    queryMap.put("endTime",list.get(i+1));
                }
                calendar.add(Calendar.DATE, 1);
                date = df.format(calendar.getTime());
                if (date.equals(endDate)) break;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
   


    /** 天
     * 描述:  Date+int(天数) = 新的Date。
     *
     * @param inDate
     *            输入原日期
     * @param addInt
     *            输入要加减的天数
     * @return Date :转换之后的Date
     */
    public static Date dateDayAddInt(Date inDate, int addInt) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(inDate);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        cal.set(year, month, day + addInt);
        return cal.getTime();
    }

    /**转字符串
     * 描述: 将日期按指定模式串转换为字符串
     *
     * @param pattern
     *            模式串
     * @param date
     *            日期
     * @return 转换成功返回相应字符串，转换失败或发生异常返回null
     */
    public static String toStringInPattern(String pattern, Date date) {
        try {
            return new SimpleDateFormat(pattern).format(date);
        } catch (Exception ex) {
            return null;
        }
    }

    /**获取一个月中每一天的时间 列表
     *
     * @param yyyyMM  "202304"
     * @return [ 20230401, 20230402, 20230403,..... 20230430]
     */
    public static List<String> getDayListOfMonth(String yyyyMM) {
        if (yyyyMM.length() != 6) {
            return null;
        }
        List<String> list = new ArrayList<String>();
        String ystr = yyyyMM.substring(0, 4);
        String mstr = yyyyMM.substring(4,6);
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, Integer.parseInt(ystr));//年份
        a.set(Calendar.MONTH,Integer.parseInt(mstr) - 1);//月份
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        for (int i = 0; i < maxDate; i++) {
            int d = i+1;
            String dstr = "";
            if (d < 10) {
                dstr = "0"+String.valueOf(d);
            }else {
                dstr = String.valueOf(d);
            }
            String day = ystr + mstr + dstr;
            list.add(day);
        }
        return list;
    }

    public static void main(String[] args) {
        //getLastMonthLastDay
        String lastMonthLastDay = getLastMonthLastDay(dateString2Date("202310",YYYYMMDD));
        System.out.println("lastMonthLastDay = " + lastMonthLastDay);
    }


    /**
     * 字符串转换为日期
     *
     * @param dateStr
     * @return
     */
    public static Date dateString2Date(String dateStr,String format) {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        Date date = null;
        try {
            if (dateStr == null || "".equals(dateStr)) {
                return null;
            }
            date = dateformat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }
    /**
     * 时间相加多少小时。
     *
     * @param day
     * @param x
     * @return
     */
    public static String addDateHour(String day, int x) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_Hour);// 24小时制
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null) {
            return "";
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DECEMBER, x);// 24小时制
        date = cal.getTime();
        cal = null;
        return format.format(date);
    }
    /**
     * 字符串转换为日期
     *
     * @param dateStr
     * @return
     */
    public static Date dateString2Date2(String dateStr,String format) {
        SimpleDateFormat dateformat = new SimpleDateFormat(format);
        Date date = null;
        try {
            if (dateStr == null || "".equals(dateStr)) {
                return null;
            }
            date = dateformat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    //获取间隔天数
    public static int getDaysBetween(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new RuntimeException("日期不能为空");
        }
        LocalDate localDate1 = date2LocalDate(date1);
        LocalDate localDate2 = date2LocalDate(date2);
        return (int) ChronoUnit.DAYS.between(localDate1, localDate2);
    }
    public static LocalDate date2LocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }
    //获取间隔天数保留到小时
    public static  long  getDaysBetween2(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new RuntimeException("日期不能为空");
        }
        LocalDateTime localDate1 = date2LocalDateTime(date1);
        LocalDateTime localDate2 = date2LocalDateTime(date2);
        return    ChronoUnit.HOURS.between(localDate1, localDate2);
    }
    //date2LocalDateTime
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }
    public static Date addDay(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    //测试类
    @Test
    public  void test( ) {
        double daysBetween2 = getDaysBetween2(
                dateString2Date2("2023110100", YYYY_MM_DD_HH),
                dateString2Date2("2023110900", YYYY_MM_DD_HH));
        BigDecimal v = hourToDay(daysBetween2);
        System.out.println(v);
    }
    //小时转天
    public static BigDecimal hourToDay(double hour) {
        return  new BigDecimal( hour / 24).setScale(4, RoundingMode.UP);
    }

    //根据开始时间和结束时间获得周一到周末z每天的z日期
    public static List<String> getWeekDays2(String startDate, String endDate) throws ParseException {
        List<String> listWeekOrMonth = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date sDate = dateFormat.parse(startDate);
        Calendar sCalendar = Calendar.getInstance();
        sCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        sCalendar.setTime(sDate);
        Date eDate = dateFormat.parse(endDate);
        Calendar eCalendar = Calendar.getInstance();
        eCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        eCalendar.setTime(eDate);
        listWeekOrMonth.add(startDate);
        while (eDate.after(sCalendar.getTime())) {
            sCalendar.add(Calendar.DAY_OF_MONTH, 1);
            listWeekOrMonth.add(dateFormat.format(sCalendar.getTime()));
        }

        return listWeekOrMonth;
    }








}