package org.exampleUtils01.StringUtils;

import org.junit.jupiter.api.Test;

/**
 * @Author ZhangYiFan
 * @Date 2022/9/13 10:52
 * @description:
 * @Version 1.0
 */
public class StringUtilTest {


    /**
     *
     */
    @Test
    public void getStringValueTest (){
        String  a= new String();
        String stringValue = StringUtil.getStringValue(a);
        System.out.println(stringValue);

    }
}
