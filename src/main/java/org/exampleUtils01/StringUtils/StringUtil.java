package org.exampleUtils01.StringUtils;


import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author ZhangYiFan
 * @Date 2022/9/8 14:15
 * @Version 2.0
 */
public class StringUtil {
    /**
     * 将对象类型转换为字符串.
     *
     * @param obj 任意对象
     * @return String 若传入空对象，则返回空字符串
     */
    public static String getStringValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * 将对象类型转换为字符串并去除前后空白字符.
     *
     * @param obj 任意对象
     * @return String 若传入空对象，则返回空字符串
     */
    public static String getTrimString(Object obj) {
        return getStringValue(obj).trim();
    }

    /**
     * 将对象类型转换为字符串，如果对象为空则设置默认值.
     *
     * @param obj          任意对象
     * @param defaultValue 默认值
     * @return String
     */
    public static String getStringValue(Object obj, String defaultValue) {
        String value = getTrimString(obj);
        return "".equals(value) ? (defaultValue == null ? "" : defaultValue) : value;
    }

    /**
     * 判断字符串是否为空.
     *
     * @param str 字符串
     * @return 字符串为空返回true，否则返回false
     */
    public static boolean isEmptyString(Object str) {
        return "".equals(getTrimString(str));
    }

    /**
     * 判断字符串是否非空.
     *
     * @param str 字符串
     * @return 空对象、只包含不可见字符的字符串和"null/NULL"值返回true，否则返回false
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim()) || "null".equals(str.trim().toLowerCase());
    }

    /**
     * 字符串按字节截取.
     *
     * @param str 原字符串
     * @param len 截取的字节长度
     * @return 截取后的字符串
     */
    public static String subStringByByte(String str, int len) {
        try {
            if (str == null)
                return "";
            int tempSubLength = len;    // 截取字节数
            String subStr = str.substring(0, str.length() < len ? str.length() : len);      // 截取的子串
            int subStrByetsL = subStr.getBytes("GBK").length;       // 截取子串的字节长度
            while (subStrByetsL > tempSubLength) {
                int subSLengthTemp = --len;
                subStr = str.substring(0, subSLengthTemp > str.length() ? str.length() : subSLengthTemp);
                subStrByetsL = subStr.getBytes("GBK").length;
            }
            return subStr;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将Json对象转换成Map.
     *
     * @param jsonObject json对象
     * @return Map对象
     */
    public static Map toMap(JSONObject jsonObject) {
        Map result = new HashMap();
        Iterator iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);
            result.put(key, value);
        }
        return result;
    }

    /**
     * 将字符串数组转换为字符串.
     *
     * @param ss       字符串数组
     * @param isNumber 字符串数组中是否为数字
     * @return String eg. isNumnber=true: "1,2,3" isNumber=false: "'1','2','3'"
     */
    public static String parseMultiSelectString(String[] ss, Boolean isNumber) {
        if (ss.length == 0 || "".equals(ss[0].trim())) {
            return "";
        }
        return isNumber ? StringUtils.join(ss, ",") : "'" + StringUtils.join(ss, "','") + "'";
    }

    /**
     * 判断字符串是否在数组中.
     *
     * @param ss  数组
     * @param str 字符串
     * @return 存在true，不存在false
     */
    public static boolean inArray(String[] ss, String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        for (String s : ss) {
            if (str.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取字符串的字节长度.
     *
     * @param str 字符串
     * @return 字符串的字节长度
     */
    public static int getWordLength(String str) {
        int length = 0;
        int strCount = str.length();
        for (int i = 0; i < strCount; i++) {
            int ascii = Character.codePointAt(str, i);
            if (ascii >= 0 && ascii <= 255) {
                length++;
            } else {
                length += 2;
            }
        }
        return length;
    }

    /**
     * 将数组转换为Map对象.
     * 数组长度必须为偶数
     * Map键值对构成规则：偶数下标为键，奇数下标为值
     *
     * @param objects 参数
     * @return Map对象
     * @throws NumberFormatException 异常
     */
    public static Map string2Map(Object... objects) throws NumberFormatException {
        Map map = new HashMap();
        int count = objects.length;
        if (count == 0) {
            return map;
        }
        if (count % 2 != 0) {
            throw new NumberFormatException(String.format("string2Map方法的参数个数必须为偶数，当前参数个数为：%d！", count));
        }
        for (int i = 0; i < count; i += 2) {
            map.put(objects[i].toString(), getStringValue(objects[i + 1]));
        }
        return map;
    }

    /**
     * 首字母大写.
     *
     * @param str 字符串
     * @return 首字母大写的字符串
     */
    public static String firstToUpper(String str) {
        if (isEmpty(str)) {
            return "";
        }
        return String.valueOf(str.charAt(0)).toUpperCase().concat(str.substring(1));
    }

    /**
     * MyBatis模糊查询安全处理.
     *
     * @param str 字符串 $str$
     * @return 处理后的字符串
     */
    public static String safeSqlLike(String str) {
        return str == null ? "" : str.replace("'", "''").trim();
    }

    /**
     * 获取一个固定长度的整数字符串，不足的位用指定字符填充.
     *
     * @param number   整数（负数将会被转换为整数）
     * @param length   位数
     * @param fillChar 填充字符串
     * @return 固定长度的整数字符串
     */
    public static String getFixLengthInteger(int number, int length, char fillChar) {
        number = number < 0 ? -number : number;
        String numberStr = String.valueOf(number);
        if (numberStr.length() > length) {
            return numberStr.substring(0, length);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - numberStr.length(); i++) {
            sb.append(fillChar);
        }
        return sb.append(numberStr).toString();
    }

    /**
     * 将整数字符串转换为Integer.
     *
     * @param obj 整数字符串
     * @return Integer对象
     * @throws NumberFormatException 异常
     */
    public static Integer getInteger(Object obj) {
        return getInteger( org.exampleUtils01.StringUtils.StringUtil.getTrimString(obj));
    }

    /**
     * 将整数字符串转换为Integer.
     *
     * @param number 整数字符串
     * @return Integer对象
     * @throws NumberFormatException 异常
     */
    public static Integer getInteger(String number) throws NumberFormatException {
        try {
            return new Integer(number);
        } catch (NullPointerException | NumberFormatException ex) {
            throw new NumberFormatException(String.format("%s不是一个有效的整数字符串！", number));
        }
    }

    /**
     * 将整数字符串转换为Integer，转换失败则返回指定值.
     *
     * @param obj          整数字符串
     * @param defaultValue 默认值
     * @return Integer对象
     */
    public static Integer getInteger(Object obj, Integer defaultValue) {
        return getInteger(org.exampleUtils01.StringUtils.StringUtil.getTrimString(obj), defaultValue);
    }

    /**
     * 将整数字符串转换为Integer，转换失败则返回指定值.
     *
     * @param number       整数字符串
     * @param defaultValue 默认值
     * @return Integer对象
     */
    public static Integer getInteger(String number, Integer defaultValue) {
        try {
            return new Integer(number);
        } catch (NullPointerException | NumberFormatException ex) {
            return defaultValue;
        }
    }

    /**
     * 将数字字符串转换为BigDecimal.
     *
     * @param obj 数字字符串
     * @return BigDecimal对象
     * @throws NumberFormatException 异常
     */
    public static BigDecimal getBigDecimal(Object obj) {
        return getBigDecimal( org.exampleUtils01.StringUtils.StringUtil.getTrimString(obj));
    }

    /**
     * 将数字字符串转换为BigDecimal.
     *
     * @param number 数字字符串
     * @return BigDecimal对象
     * @throws NumberFormatException 异常
     */
    public static BigDecimal getBigDecimal(String number) throws NumberFormatException {
        try {
            return new BigDecimal(number);
        } catch (NullPointerException | NumberFormatException ex) {
            throw new NumberFormatException(String.format("%s不是一个有效的数字字符串！", number));
        }
    }

    /**
     * 将数字字符串转换为BigDecimal，转换失败则返回指定值.
     *
     * @param obj          数字字符串
     * @param defaultValue 默认值
     * @return BigDecimal对象
     */
    public static BigDecimal getBigDecimal(Object obj, BigDecimal defaultValue) {
        return getBigDecimal(org.exampleUtils01.StringUtils.StringUtil.getTrimString(obj), defaultValue);
    }

    /**
     * 将数字字符串转换为BigDecimal，转换失败则返回指定值.
     *
     * @param number       数字字符串
     * @param defaultValue 默认值
     * @return BigDecimal对象
     */
    public static BigDecimal getBigDecimal(String number, BigDecimal defaultValue) {
        try {
            return new BigDecimal(number);
        } catch (NullPointerException | NumberFormatException ex) {
            return defaultValue;
        }
    }

    /**
     * 将数字字符串转换为Long.
     *
     * @param obj 整数字符串
     * @return Long对象
     * @throws NumberFormatException 异常
     */
    public static Long getLong(Object obj) {
        return getLong(org.exampleUtils01.StringUtils.StringUtil.getTrimString(obj));
    }

    /**
     * 将数字字符串转换为Long.
     *
     * @param number 整数字符串
     * @return Long对象
     * @throws NumberFormatException 异常
     */
    public static Long getLong(String number) throws NumberFormatException {
        try {
            return new Long(number);
        } catch (NullPointerException | NumberFormatException ex) {
            throw new NumberFormatException(String.format("%s不是一个有效的整数字符串！", number));
        }
    }

    /**
     * 将数字字符串转换为Long.
     *
     * @param obj          整数字符串
     * @param defaultValue 默认值
     * @return Long对象
     */
    public static Long getLong(Object obj, Long defaultValue) {
        return getLong(org.exampleUtils01.StringUtils.StringUtil.getTrimString(obj), defaultValue);
    }

    /**
     * 将数字字符串转换为Long.
     *
     * @param number       整数字符串
     * @param defaultValue 默认值
     * @return Long对象
     */
    public static Long getLong(String number, Long defaultValue) {
        try {
            return new Long(number);
        } catch (NullPointerException | NumberFormatException ex) {
            return defaultValue;
        }
    }

    /**
     * 从配置字符串中获取配置信息.
     *
     * @param str 配置字符串
     * @param key 键
     * @return 值
     */
    public static String getConfig(String str, String key) {
        Pattern pattern = Pattern.compile("(^| )".concat(key).concat("=([^;]*)(;|$)"));
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(2) : "";
    }

    /**
     * 按字节截取字符串.
     *
     * @param str       字符串
     * @param maxLength 最大长度
     * @return 截取后的字符串
     */
    public static String getStringByLength(String str, int maxLength) {
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            length += getWordLength(String.valueOf(c));
            if (length > maxLength) {
                break;
            }
            sb.append(c);
        }
        return sb.toString();
    }

}
