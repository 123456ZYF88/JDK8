package org.exampleUtils01.dateUtils;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.exampleUtils01.exception.XiaoNiuException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 工具类 - 日期工具类
 *
 * @author wumenghua
 * @version V1.0
 */
public class DateUtil {
    private static SimpleDateFormat monthDateFormat = new SimpleDateFormat("MM");
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SIGN = "yyyyMMddHHmmssSSS";
    public static final DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /*获取时间yyyMMddHHmmssSSS*/
    public static String getIFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_SIGN);
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

    /**
     * date 多少分钟之前的日期
     *
     * @param date   日期
     * @param minute
     * @return
     */
    public static Date beforMinute(Date date, int minute) {
        return handleMinute(date, -minute);
    }

    /**
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

    /**
     * date 多少天之前的日期
     *
     * @param date 日期
     * @param day
     * @return
     */
    public static Date beforDay(Date date, int day) {
        Date nowDate = handleDay(date, -day);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
        }
        return nowDate;
    }

    /**
     * date 多少天之前的日期
     *
     * @param date 日期
     * @param day
     * @return
     */
    public static Date afterDay(Date date, int day) {
        Date nowDate = handleDay(date, day);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
        }
        return nowDate;
    }

    /**
     * date 多少天之前的日期
     *
     * @param date 日期
     * @param day
     * @return
     */
    public static Date beforDayYYYYMMDDhhmmss(Date date, int day) {
        Date nowDate = handleDay(date, -day);
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
        }
        return nowDate;
    }

    /**
     * date 多少天之后的日期
     *
     * @param date 日期
     * @param day
     * @return
     */
    public static Date afterDayYYYYMMDDhhmmss(Date date, int day) {
        Date nowDate = handleDay(date, day);
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
        }
        return nowDate;
    }

    /**
     * date 多少月之前的日期
     *
     * @param date  日期
     * @param month
     * @return
     */
    public static Date beforMonth(Date date, int month) {
        Date nowDate = handleMonth(date, -month);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
        }
        return nowDate;
    }

    /**
     * date 多少年之前的日期
     *
     * @param date 日期
     * @param year
     * @return
     */
    public static Date beforYear(Date date, int year) {
        Date nowDate = handleYear(date, -year);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
        }
        return nowDate;
    }

    /**
     * date 多少年之后的日期
     *
     * @param date 日期
     * @param year
     * @return
     */
    public static Date afterYear(Date date, int year) {
        Date nowDate = handleYear(date, year);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(nowDate);
        try {
            nowDate = formatter.parse(dateString);
        } catch (ParseException e) {
        }
        return nowDate;
    }

    /**
     * date 多少小时之前的日期
     *
     * @param date   日期
     * @param minute
     * @return
     */
    public static Date beforHour(Date date, int minute) {
        return handleHour(date, -minute);
    }

    /**
     * date 多少小时后的日期
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date afterHour(Date date, int minute) {
        return handleHour(date, Math.abs(minute));
    }

    /**
     * dd 该月有多少天
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    /**
     * dd 该月有多少天
     * @param date
     * @return
     */
    public static int getDaysOfMonth(String date) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMM");
        try {
            calendar.setTime(simpleDate.parse(date)); //要计算你想要的月份，改变这里即可
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    /**
     * dd 该月有多少天
     * @param date
     * @return
     */
    public static int getDaysOfMonth2(String date) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyyMM");
        try {
            calendar.setTime(simpleDate.parse(date)); //要计算你想要的月份，改变这里即可
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getActualMaximum(Calendar.MONTH);
    }

    @Test
    public void test11(){
        int daysOfMonth2 = getDaysOfMonth2("202301");
        System.out.println(daysOfMonth2);
    }





    /**
     * 处理日期
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
     * 处理日期
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
     * 处理月份
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
     * 处理年份
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
     * 日期补全
     *
     * @param date
     * @return
     */
    public static String dateComplete(String date) {
        try {
            if (StringUtils.isBlank(date)) {
                return null;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat newFormatter = new SimpleDateFormat(DATE_FORMAT);
            Date date_date = formatter.parse(date);
            date = newFormatter.format(date_date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    /**
     * 日期转化为固定格式的字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String day2String(Date date) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
    }

    /**
     * 日期转化为固定格式的字符串 yyyyMMddHHmmss
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
        return stringToDate(date, DATE_FORMAT);
    }

    // 比当前日期大为true
    public static boolean compareDate(Date date) {
        if (date == null) {
            return false;
        }
        return date.compareTo(new Date()) > 0;
    }

    public static Boolean compareDate(Date beginDate, Date endDate) {
        if (beginDate == null) {
            return null;
        }
        if (endDate == null) {
            endDate = new Date();
        }
        return endDate.compareTo(beginDate) > 0;
    }

    /**
     * 日期减法
     *
     * @param minuend 被减数
     * @param meiosis 减数
     * @return
     */
    public static long dateSubtraction(Date minuend, Date meiosis) {
        if (DateUtil.compareDate(minuend)) {
            long surplusTime = minuend.getTime() - meiosis.getTime();
            return surplusTime;
        } else {
            return 0;
        }
    }

    /**
     * 日期减法
     *
     * @param minuend 被减数
     * @param meiosis 减数
     * @return
     */
    public static long subtractDate(Date minuend, Date meiosis) {
        if (minuend == null || meiosis == null) {
            return 0;
        } else {
            long surplusTime = minuend.getTime() - meiosis.getTime();
            return surplusTime;
        }
    }

    /**
     * 把毫秒转化成日期
     *
     * @param dateFormat(日期格式，例如：MM/ dd/yyyy HH:mm:ss)
     * @param millSec(毫秒数)
     * @return
     */
    public static String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    /**
     * 给定一个日期，返回加减n天后的日期
     */

    public static Date nDaysAfterOneDate(Date basicDate, int n) {
        if (basicDate == null) return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(basicDate);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    public static Date nMinAfterOneDate(Date basicDate, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(basicDate);
        cal.add(Calendar.MINUTE, n);
        return cal.getTime();
    }

    /**
     * @param date
     * @return
     * @description 通过指定日期得到年月字符串
     * @author gc
     * @date 2019/9/4
     */
    public static String getYearAndMonthStr(Date date) {
        String nowStr = DateUtil.day2String(date);
        if (StringUtils.isEmpty(nowStr)) {
            return "";
        }
        return nowStr.substring(0, 7).replaceAll("-", "");
    }

    /**
     * 获取月第一天
     * @param date
     * @return
     */
    public static String getMonthFirstDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(c.getTime());
    }

    //获取上个月的第一天
    public static String getLastMonthFirstDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(c.getTime());
        return dateString;
    }

    //MM 获取月份最后一天
    public static String getMonthLastDay(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(c.getTime());
    }
    //MM 获取上个月最后一天
    public static String getLastMonthLastDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(c.getTime());
        return dateString;
    }

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

    /**
     * 日期时间格式化成字符串
     *
     * @return
     */
    public static String formatStirngToString(String dateTime) {
        if (StringUtils.isNotBlank(dateTime)) {
            return dateTime.replaceAll(" ", "").replaceAll(":", "").replaceAll("-", "");
        } else {
            return null;
        }

    }

    /**
     * 日期字符串格式化
     *
     * @param dateString     日期字符串
     * @param originalFormat 日期字符串原来格式
     * @param newFormat      日期字符串新的格式
     * @return 格式化后的日期字符串
     * @throws ParseException
     */
    public static String formatDateString(String dateString, String originalFormat, String newFormat)
            throws ParseException {
        Date sourceDate = new SimpleDateFormat(originalFormat).parse(dateString);
        return new SimpleDateFormat(newFormat).format(sourceDate);
    }

    private static final Random random = new Random();
    public static Long randomLong(){
        return random.nextLong();
    }
    /**
     * 取两个日期之间的随机日期
     *
     * @param firstDate
     * @param secondDate
     * @return
     */
    public static Date getDateRandomBetween(Date firstDate, Date secondDate) throws XiaoNiuException {
        if (firstDate == null || secondDate == null) {
            throw new XiaoNiuException("-1", "日期不能为空！");
        }

        if (firstDate.getTime() - secondDate.getTime() == 0) {
            return firstDate;
        }

        long randomDate = 0;
        long randomLong = randomLong();//实际操作时应该把方法放到公共包里面 CommonUtil.randomLong();
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
     * @param date
     * @return
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
     * date 多少秒之前的日期
     *
     * @param date   日期
     * @param second
     * @return
     */
    public static Date beforSecond(Date date, int second) {
        return handleSecond(date, -second);
    }

    /**
     * date 多少秒后的日期
     *
     * @param date
     * @param second
     * @return
     */
    public static Date afterSecond(Date date, int second) {
        return handleSecond(date, Math.abs(second));
    }

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
        long l = difference / (1000 * 3600 * 24);
        return l;
    }

    public static String getDateRandomBetween(LocalDateTime startTime, LocalDateTime endTime) throws XiaoNiuException {
        if (startTime == null || endTime == null) {
            throw new XiaoNiuException("-1", "日期不能为空！");
        }
        long sTime = startTime.toEpochSecond(ZoneOffset.UTC);
        long eTime = endTime.toEpochSecond(ZoneOffset.UTC);
        if (sTime == eTime) {
            return startTime.format(yyyyMMddHHmmss);
        }
        long rand = RandomUtils.nextLong(sTime, eTime);
        return LocalDateTime.ofEpochSecond(rand, 0, ZoneOffset.UTC).format(yyyyMMddHHmmss);
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

        int maxDate = a.get(Calendar.DATE);

        return maxDate;

    }
    /**
     * 获得开始时间和结束时间
     * @param dateTime
     * @return
     * @throws ParseException
     */
    public static Map getMonthStartTimeByDate(String dateTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
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
        Map map = new HashMap();
        map.put("startDate", resultStartTime);
        map.put("endDate", resultEndTime);
        return map;

    }
    /**
     * 根据传入的参数，来对日期区间进行拆分，返回拆分后的日期List
     * @param statisticsType
     * @param
     * @return
     * @throws ParseException
     * @author lihq 2019-6-24
     * @editor
     * @editcont
     */
    public static List<String> doDateByStatisticsType(String statisticsType, String startDate, String endDate) throws ParseException{
        List<String> listWeekOrMonth = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
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

    public static void main(String[] args) throws ParseException, XiaoNiuException {

    }



    /**
     * 根据传入的参数，来对日期区间进行拆分，返回拆分后的日期List
     * @param statisticsType
     * @param map
     * @return
     * @throws ParseException
     * @author lihq 2019-6-24
     * @editor
     * @editcont
     */
    public List<String> doDateByStatisticsType(String statisticsType,Map<String, Object> map) throws ParseException{
        List<String> listWeekOrMonth = new ArrayList<String>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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


}