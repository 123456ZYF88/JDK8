package org.example.demo03functionalinterface;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: Supplier函数式接口 供应商
 * java.util.function.Supplier<T> 接口，它意味着"供给" , 对应的Lambda表达式需要“对外提供”一个符合泛型类
 * 型的对象数据。
 * 供给型接口，通过Supplier接口中的get方法可以得到一个值，无参有返回的接口。
 * @date 2022/4/1 12:32
 */
public class Demo02Supplier {
    public static void main(String[] args) {
        printMax(()->{
            int [] arr= {12,13,14,15,11};
            //先排序，最后就是最大的
            Arrays.sort(arr);
            return arr[arr.length - 1];// 最后就是最大的
        });
    }

    public static void printMax(Supplier<Integer> supplier){
        int max = supplier.get();
        System.out.println("max="+ max);
    }
}


