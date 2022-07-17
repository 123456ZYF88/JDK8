package org.example.demo02interface;

import java.lang.management.MemoryManagerMXBean;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2022/2/14 21:06
 */
public class Demo02defaultFunctio {
    public static void main(String[] args) {
        BB bb = new BB();
        // 方式一：实现类直接调用接口默认方法
        bb.test02();

        CC cc =  new CC();
        //调用实现类重写接口默认方法
        cc.test02();

        Map map=new HashMap();

        //输出
        map.forEach((key,value) -> System.out.println(key+":"+value));
    }
}

interface AA {
    public  abstract void test1();
    public default void test02(){
        System.out.println("AA test02");
    }
}

class BB implements AA {
    @Override
    public void test1() {

    }
}

class CC implements AA {
    @Override
    public void test1() {
        System.out.println("cc test1");
    }

    @Override
    public void test02() {
        System.out.println("cc 实现类重写接口默认方法");
    }
}