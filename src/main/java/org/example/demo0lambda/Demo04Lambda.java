package org.example.demo0lambda;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2021/12/28 19:38
 */
public class Demo04Lambda {
    public static void main(String[] args) {
        //匿名内部类 在编译后会形成一个新的类
        goSwimming(new Swimmable() {
            @Override
            public void swimming() {
                System.out.println("匿名内部类");
            }
        });
        //Lambda 表达式会在类中新生成一个私有的方法
    //Lambda在程序运行的时候形成一个类    d
        //Lambda表达式中的代码会放到这个新增的方法中
        //还会形成一个匿名内部类，实现接口 重写抽象方法
        //而接口的重写方法中 去调用了新生成的方法
        goSwimming(() -> {
            System.out.println("Lambda表达式");
        });
    }
    public static void goSwimming(Swimmable swimmable){
        swimmable.swimming();
    }
}
