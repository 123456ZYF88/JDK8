package org.exampleUtils01.enumUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 全局管理Enum
 * @author zhangyf
 * @date 2025/1/13 16:48
 */

public class EnumService {
    /**
     * 获取指定枚举类的所有枚举常量及其信息
     *
     * @param enumClassName 枚举类的全限定名
     * @return 包含枚举常量及其信息的列表
     */
    public static List<Map<String, Object>> getEnumConstants(String enumClassName) {
        List<Map<String, Object>> enumConstants = new ArrayList<>();
        try {
            //注：  创建Enum时请规范文件位置
            Class<?> enumClass = Class.forName("com.charmtrvl.flight.seek.common.enums."+enumClassName);
            if (!enumClass.isEnum()) {
                throw new IllegalArgumentException(enumClassName + " is not an enum class");
            }

            Object[] constants = enumClass.getEnumConstants();
            for (Object constant : constants) {
                Map<String, Object> enumInfo = new HashMap<>();
                enumInfo.put("name", ((Enum<?>) constant).name());

                // 获取枚举常量的所有字段
                for (java.lang.reflect.Field field : enumClass.getDeclaredFields()) {
                    if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                        continue;
                    }
                    field.setAccessible(true);
                    enumInfo.put(field.getName(), field.get(constant));
                }

                // 获取枚举常量的所有方法
                for (Method method : enumClass.getDeclaredMethods()) {
                    if (method.getParameterCount() == 0 && method.getReturnType() != void.class) {
                        method.setAccessible(true);
                        enumInfo.put(method.getName(), method.invoke(constant));
                    }
                }

                enumConstants.add(enumInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enumConstants;
    }
}
