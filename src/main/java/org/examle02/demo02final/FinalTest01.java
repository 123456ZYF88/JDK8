package org.examle02.demo02final;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: 变量赋值
 * @date 2022/4/28 9:24
 */
public class FinalTest01 {
    public static void main(String[] args) {
        final StringBuilder a= new StringBuilder("aaaaaaa");
        //编译报错
      //  a = new StringBuilder("不能改变指向变量");//不能给最终变量'a'赋值

        a.append("添加");// 但可以修改




    }
    //同样在方法的参数中声明final 一样可以对内容进行修改
    public void method(final StringBuilder aaa){
        aaa.append("一样可以修改");
       // aaa = new StringBuilder("不能改变");
    }
}
