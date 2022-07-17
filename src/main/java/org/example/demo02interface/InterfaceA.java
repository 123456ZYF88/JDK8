package org.example.demo02interface;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2022/2/14 20:52
 */
public class InterfaceA {
}
interface A{
    public abstract void test1();
    // 接口新增抽象方法,所有实现类都需要去重写这个方法,非常不利于接口的扩展
    public abstract void test2();

}

class B implements  A {

    @Override
    public void test1() {

    }
// 接口新增抽象方法,所有实现类都需要去重写这个方法

    @Override
    public void test2() {

    }
}

class c implements A {
    @Override
    public void test1() {

    }
// 接口新增抽象方法,所有实现类都需要去重写这个方法

    @Override
    public void test2() {

    }
}
