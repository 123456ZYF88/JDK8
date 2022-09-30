package org.exampleUtils01.memcachedUtils;

import java.util.Date;

/**
 * @Author ZhangYiFan
 * @Date 2022/9/30 10:40
 * @description:
 * @Version 1.0
 */
public class MemCached01Test {
    public static void main(String[] args) {
        MemCached01 cache = MemCached01.getInstance();
        boolean result1 = cache.add("hello", 1234, new Date(1000 * 2));// 设置2秒后过期
        System.out.println("第一次add : " + result1);
        System.out.println("Value : " + cache.get("hello"));

        boolean result2 =cache.add("hello", 12345, new Date(1000 * 2));// add fail
        System.out.println("第二次add : " + result2);

        boolean result3 =cache.set("hello", 12345, new Date(1000 * 2));// set successes
        System.out.println("调用set : " + result3);

        System.out.println("Value : " + cache.get("hello"));

        try {
            Thread.sleep(1000 * 2);
            System.out.println("已经sleep2秒了....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Value : " + cache.get("hello"));
    }
}
