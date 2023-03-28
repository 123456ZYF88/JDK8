package org.exampleUtils01.BigDecimalUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @Author ZhangYiFan
 * @Date 2023/3/28 14:24
 * @description:
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(new BigDecimal("123.4", new MathContext(4,
                RoundingMode.HALF_UP)));
        System.out.println(new BigDecimal("123.4", new MathContext(2,
                RoundingMode.HALF_UP)));
        System.out.println(new BigDecimal("123.4", new MathContext(2,
                RoundingMode.CEILING)));
        System.out.println(new BigDecimal("123.4", new MathContext(1,
                RoundingMode.CEILING)));
    }
}
