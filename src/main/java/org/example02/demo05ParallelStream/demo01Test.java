package org.example02.demo05ParallelStream;

import java.util.ArrayList;

public class demo01Test {
    //parallelStream线程安全问题
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
    }


}
