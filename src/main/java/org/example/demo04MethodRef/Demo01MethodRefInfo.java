package org.example.demo04MethodRef;

import com.google.common.base.Supplier;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 使用Lambda表达式求一个数组的和
 * @author zhangyf
 * @date 2024/4/2 9:36
 */

public class Demo01MethodRefInfo {

    public static void getMax(int[] arr){
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        /*printMax((int[] arr)->{
            getMax(arr);
        });*/
        //如果我们在Lambda中所指定的功能，已经有其他方法存在相同方案，那是否还有必要再写重复逻辑？可以直接“引
        //用”过去就好了：
        printMax(Demo01MethodRefInfo::getMax);
        //请注意其中的双冒号::写法，这被称为“方法引用”，是一种新的语法。
    }
    public static void printMax(Consumer<int[]> consumer){
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        consumer.accept(arr);
    }

    //对象::实例方法
    @Test
    public void test01(){
        Date date = new Date();
        Supplier<Long> supp = date::getTime;
        System.out.println(supp.get());

        //方法引用的注意事项
        //1. 被引用的方法，参数要和接口中抽象方法的参数一样
       // 2. 当接口抽象方法有返回值时，被引用的方法也必须有返回值
        Supplier<Long> getTime = date::getTime;
        System.out.println(getTime.get());
    }

    // 类名::静态方法
    @Test
    public void test02(){
        java.util.function.Supplier<Long> supplier = System::currentTimeMillis;
        System.out.println(supplier.get());

        java.util.function.Supplier<Long> currentTimeMillis = System::currentTimeMillis;
        System.out.println( currentTimeMillis.get());

    }

    @Test
    public void test03(){
        Function<String,Integer> f1 = String::length;
        System.out.println(f1.apply("abc"));

    }


}