package org.example04.springTest;

/**
 * 循环依赖
 *
 * @author zhangyf
 * @date 2024/10/23 12:10
 */

public class CircularDependencyTest {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();

        a.setB(b);
        b.setA(a);

        a.test1();
        b.test2();

        System.out.println("循环依赖测试完成");
    }
    static class A{
        private B b;
        public void setB(B b) {
            this.b = b;
        }
        public void test1(){
            System.out.println("A.test1()");
        }
    }
    static class B{
        private A a;
        public void setA(A a) {
            this.a = a;
        }
        public void test2(){
            System.out.println("B.test2()");
        }
    }
}
