package org.exampleUtils01.dateUtils;

import java.time.format.DateTimeFormatter;

/**
 * @Author ZhangYiFan
 * @Date 2023/5/19 14:04
 * @description:
 * @Version 1.0
 */
public class DTMode {
    public static final String FORMAT_DATE_YEAR_MONTH_TWO = "yyyyMM";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH = "yyyyMMddHH";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_Hour = "yyyyMMddHH";
    public static final String DATE_SIGN = "yyyyMMddHHmmssSSS";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final DateTimeFormatter YYYY_MM_DDHHmmss = DateTimeFormatter.ofPattern(DTMode.DATE_FORMAT);
}
