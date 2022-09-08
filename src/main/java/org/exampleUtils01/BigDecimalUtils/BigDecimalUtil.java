package org.exampleUtils01.BigDecimalUtils;

import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * @Author ZhangYiFan
 * @Date 2022/9/8 14:13
 * @Version 2.0
 */
public class BigDecimalUtil {
    /**
     * 常用的常量—1000
     */
    public final static BigDecimal DECIMAL_1000 = new BigDecimal("1000");
    /**
     * 常用的常量—100
     */
    public final static BigDecimal DECIMAL_100 = new BigDecimal("100");
    /**
     * 常用的常量0
     */
    public final static BigDecimal DECIMAL_0 = new BigDecimal("0");
    /**
     * 如果==null or 0返回true
     * @param v
     * @return
     */
    public static Boolean isNullOrZero(BigDecimal v){
        return v == null || v.compareTo(BigDecimal.ZERO) == 0;
    }
    /**
     * 如果==null返回0
     * @param v
     * @return
     */
    public static BigDecimal isNullReturnZero(BigDecimal v){
        return v == null ? BigDecimal.ZERO : v;
    }
    /**
     * 如果==null返回0
     * @param v 请确定是个数字
     * @return
     */
    public static BigDecimal isNullReturnZero(Object v){
        return v == null ? BigDecimal.ZERO : toBigDecimal(v);
    }
    /**
     * 如果==null返回""
     * @param v
     * @return
     */
    public static String isNullReturnBlank(BigDecimal v){
        return v == null ? "" : v.toString();
    }
    /**
     * BigDecimal保留小数
     * 默认进一法
     * @param val 值
     * @return
     */
    public static BigDecimal setScaleUp(BigDecimal val){
        return isNullOrZero(val) ? BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_UP) :
                val.setScale(2, BigDecimal.ROUND_UP);
    }
    /**
     * BigDecimal保留小数
     * @param val 值
     * @param newScale 保留几位小数
     * @return
     */
    public static BigDecimal setScale(BigDecimal val, int newScale){
        return isNullOrZero(val) ? BigDecimal.ZERO.setScale(newScale, BigDecimal.ROUND_HALF_UP) :
                val.setScale(newScale, BigDecimal.ROUND_HALF_UP);
    }
    /**
     * BigDecimal保留小数
     * @param val 值
     * @param newScale 保留几位小数
     * @return
     */
    public static BigDecimal setScale(Object val, int newScale){
        BigDecimal decimal = toBigDecimal(val);
        return isNullOrZero(decimal) ? BigDecimal.ZERO.setScale(newScale, BigDecimal.ROUND_HALF_UP) :
                decimal.setScale(newScale, BigDecimal.ROUND_HALF_UP);
    }
    /**
     * BigDecimal保留小数
     * @param val 值
     * @param newScale 保留几位小数
     * @param roundingMode 保留小数方法
     * @return
     */
    public static BigDecimal setScale(BigDecimal val, int newScale, int roundingMode){
        return isNullOrZero(val) ? BigDecimal.ZERO.setScale(newScale, roundingMode) :
                val.setScale(newScale, roundingMode);
    }
    /**
     * BigDecimal保留小数
     * @param val 值
     * @param newScale 保留几位小数
     * @param roundingMode 保留小数方法
     * @return
     */
    public static BigDecimal setScale(String val, int newScale, int roundingMode){
        BigDecimal bigDecimal = toBigDecimal(val);
        return isNullOrZero(bigDecimal) ? BigDecimal.ZERO.setScale(newScale, roundingMode) :
                bigDecimal.setScale(newScale, roundingMode);
    }
    /**
     * BigDecimal保留小数
     * @param val 值
     * @param newScale 保留几位小数
     * @param roundingMode 保留小数方法
     * @return
     */
    public static BigDecimal setScale(Object val, int newScale, int roundingMode){
        BigDecimal bigDecimal = toBigDecimal(val);
        return isNullOrZero(bigDecimal) ? BigDecimal.ZERO.setScale(newScale, roundingMode) :
                bigDecimal.setScale(newScale, roundingMode);
    }
    /**
     * BigDecimal除法
     * 保留四位小数
     * @param v1 除数
     * @param v2 被除数
     * @return
     */
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2){
        if (v1 == null || v1.compareTo(BigDecimal.ZERO) ==0 || v2 == null || v2.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO;
        }
        return v1.divide(v2, 4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     *
     * BigDecimal除法
     * 指定保留scale位小数
     * @param v1 除数
     * @param v2 被除数
     * @param scale
     * @return
     */
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2, @NotNull Integer scale){
        if (v1 == null || v1.compareTo(BigDecimal.ZERO) ==0 || v2 == null || v2.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO;
        }
        return v1.divide(v2, scale, RoundingMode.HALF_UP);
    }
    /**
     * BigDecimal乘法
     * 保留四位小数 默认四舍五入
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal multiply(BigDecimal v1, BigDecimal v2){
        v1 = isNullReturnZero(v1);
        v2 = isNullReturnZero(v2);
        return v1.multiply(v2).setScale(4, BigDecimal.ROUND_HALF_UP);
    }
    /**
     * BigDecimal乘法
     * 保留四位小数 默认四舍五入
     * @param v1 除数
     * @param v2 被除数
     * @return
     */
    public static BigDecimal multiply(BigDecimal v1, BigDecimal v2, int newScale){
        v1 = isNullReturnZero(v1);
        v2 = isNullReturnZero(v2);
        return v1.multiply(v2).setScale(newScale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     *
     * BigDecimal乘法
     * @param v1
     * @param v2
     * @param newScale 保留几位小数
     * @param roundingMode 保留小数的方法
     * @return
     */
    public static BigDecimal multiply(BigDecimal v1, BigDecimal v2, int newScale, int roundingMode){
        if (v2.compareTo(BigDecimal.ZERO) == 0 || v1.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.ZERO.setScale(newScale);
        }
        return v1.multiply(v2).setScale(newScale, roundingMode);
    }
    /**
     * BigDecimal加法
     * 保留四位小数 默认四舍五入
     * @param v1 除数
     * @param v2 被除数
     * @return
     */
    public static BigDecimal add(BigDecimal v1, BigDecimal v2){
        v1 = isNullReturnZero(v1);
        v2 = isNullReturnZero(v2);
        return v1.add(v2).setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    /**
     *
     * BigDecimal加法
     * @param v1
     * @param v2
     * @param newScale 保留几位小数
     * @param roundingMode 保留小数的方法
     * @return
     */
    public static BigDecimal add(BigDecimal v1, BigDecimal v2, int newScale, int roundingMode){
        v1 = isNullReturnZero(v1);
        v2 = isNullReturnZero(v2);
        return v1.add(v2).setScale(newScale, roundingMode);
    }
    /**
     * BigDecimal减法
     * 保留四位小数 默认四舍五入
     * @param v1 除数
     * @param v2 被除数
     * @return
     */
    public static BigDecimal subtract(BigDecimal v1, BigDecimal v2){
        v1 = isNullReturnZero(v1);
        v2 = isNullReturnZero(v2);
        return v1.subtract(v2).setScale(4, BigDecimal.ROUND_HALF_UP);
    }
    /**
     * BigDecimal减法
     * 保留四位小数 默认四舍五入
     * @param v1 减数
     * @param v2 被减数
     * @return
     */
    public static BigDecimal subtract(BigDecimal v1, BigDecimal... v2){
        v1 = isNullReturnZero(v1);
        for (BigDecimal decimal : v2) {
            v1 = subtract(v1, isNullReturnZero(decimal), 4, BigDecimal.ROUND_HALF_UP);
        }
        return v1;
    }

    /**
     *
     * BigDecimal减法
     * @param v1
     * @param v2
     * @param newScale 保留几位小数
     * @param roundingMode 保留小数的方法
     * @return
     */
    public static BigDecimal subtract(BigDecimal v1, BigDecimal v2, int newScale, int roundingMode){
        v1 = isNullReturnZero(v1);
        v2 = isNullReturnZero(v2);
        return v1.subtract(v2).setScale(newScale, roundingMode);
    }
    /**
     * Object转BigDecimal类型
     *
     * @param value 传入Object值
     * @return 转成的BigDecimal类型数据
     */
    public static BigDecimal toBigDecimal(Object value) {
        if (value == null || "".equals(value)){
            return null;
        }
        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        } else if (value instanceof String) {
            return new BigDecimal(String.valueOf(value));
        } else if (value instanceof BigInteger) {
            return new BigDecimal(String.valueOf(value));
        } else if (value instanceof Number) {
            return new BigDecimal(String.valueOf(value));
        } else {
            throw new ClassCastException("Can Not make [" + value + "] into a BigDecimal.");
        }
    }

    public static void main(String[] args) {
        BigDecimal bigDecimalOne = new BigDecimal(10.0);
        BigDecimal bigDecimalTwo = new BigDecimal(5.0);
        System.out.println(bigDecimalOne.divide(bigDecimalTwo,4, RoundingMode.HALF_UP));
    }
}
