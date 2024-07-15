package org.exampleUtils01.datavalidator;



import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.util.Objects;

public class AssembleParameter {


    private AssembleParameter(){}

    /**
     * value转为对应class返回
     * 后面如果有没有的校验, 可加入
     *
     * @param clazz .
     * @param value .
     * @return {java.lang.Object}
     * @author jinshengming
     * @date 2021/8/6 17:22
     */
    public static Object cast(Class<?> clazz, Object value) {
        Object result = null;
        switch (clazz.getName()) {
            case "java.math.BigDecimal":
                result = new BigDecimal(Objects.toString(value));
                break;
            case "java.lang.String":
                result = Objects.toString(value);
                break;
            case "java.util.Date":
                result = DateUtil.parseDate(Objects.toString(value));
                break;
            case "java.lang.Long":
                result = Long.parseLong(Objects.toString(value));
                break;
            default:
                break;
        }
        return result;
    }
}
