package org.example.math01BingDecimal;

import org.junit.jupiter.api.Test;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 练习
 * @date 2022/4/15 15:45
 */
public class BigIntegerTest {
    /**
     * int和long的取值范围
     */
    @Test
    public void testIntLoginLimit(){
        int intMaxValue =Integer.MAX_VALUE;
        System.out.println("int的最大值+:"+intMaxValue);

        long longMaxValue = Long.MAX_VALUE;
        System.out.println("long最大值+:"+longMaxValue);
        //当long类型不够时使用BigInteger
    }

}
