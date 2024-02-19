package org.example.demo0Lambda;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2021/12/21 17:27
 */
/*
Lambda表达式是一个 匿名函数  而函数就相当于java中的方法
* （参数列表）-> {
*
* }
*   (参数列表)：参数列表
*   {}： 方法体
*   -> : 没有实际含义，起到连接作用
*
* */
public class Demo02Lambda {
    public static void main(String[] args) {
        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("我是匿名内部类的游泳");
            }

        });
        System.out.println("=============================================分隔符");
        //方法的参数是接口就可以考虑使用lambda表达式
        //Lambda表达式就是对接口中的抽象方法的重写
        goSwimming(() -> System.out.println("我是 lambda函数  "));

        goSmoking(new Smokeable (){
            @Override
            public int smoking(String name) {
                System.out.println("插了"+name);
                return 0;
            }
        });
        //匿名有参Lambda表达式
     goSmoking((String name) -> {
         System.out.println("Lambda"+name+"的");
         return 1;
     } );

    }
    //练习有返回值的方法
    public static void goSmoking(Smokeable a){
        a.smoking("郑州");
    }
    //练习无返回值的方法
    public static void goSwimming(Swimmable e){
        e.swimming();
    }
}
