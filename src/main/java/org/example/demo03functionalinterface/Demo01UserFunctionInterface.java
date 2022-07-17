package org.example.demo03functionalinterface;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 函数式接口
 * @date 2022/3/31 22:45
 */
public class Demo01UserFunctionInterface {
    public static void main(String[] args) {
        //调用函数式接口中的方法
        method(arr -> {
            int sum = 0;
            for (int n : arr){
                sum +=n;
            }
            return sum;
        });
        methodArrayList((ArrayList<Integer> arrayList ) -> {
           //吧集合转数组
           Object[] objects1 =  arrayList.toArray();
           Integer[] objects= Arrays.copyOfRange(objects1,0,objects1.length,Integer[].class);
            /*
             //排序1
             for (int i=0;i< objects.length;i++){
                for (int j=0;j< objects.length;j++){
                    if ( objects[i] > objects[j] ) {
                       // 赋值
                        Integer interger=objects[i];
                       objects[i]=objects[j];
                       objects[j]=interger;
                    }
                }
            }*/
            //排序2
            Arrays.sort(objects);
             ArrayList<Integer> list=new ArrayList<>(Arrays.asList(objects));
            return list ;

        });
    }

    //使用自定义的函数式接口作为方法参数
    public static void method(Operator operator){
        int[] arr = {1,2,3,4};
        int sum = operator.getSum(arr);
        System.out.println("sum="+sum);
    }
    //特别垃圾的排序
    public static void methodArrayList( Operation operation){
        ArrayList arrayList = new ArrayList<Integer>();
        arrayList.add(4);arrayList.add(5);arrayList.add(6);arrayList.add(1);arrayList.add(10);
        ArrayList<Integer> sort = operation.getSort(arrayList);
         sort.forEach(System.out::println);
    }
}

@FunctionalInterface
interface Operator{
    public abstract int getSum(int[] arr);
}

interface Operation{
    public abstract ArrayList<Integer> getSort(ArrayList<Integer> arrayList);
}