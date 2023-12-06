package org.example04.dayalways;

import java.util.ArrayList;
import java.util.List;

public class Temperature {

    /* 给定一个整数数组
    temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第i天，
    下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0来代替。*/
    public static void main(String[] args) {
        List<Integer> temperatures =  new ArrayList<>();
        temperatures.add(73);
        temperatures.add(74);
        temperatures.add(75);
        temperatures.add(71);
        temperatures.add(69);
        temperatures.add(72);
        temperatures.add(76);
        temperatures.add(73);
        int[] answer = new int[temperatures.size()];
        for (int i = 0; i < temperatures.size(); i++) {
            int count = 0;
            for (int j = i+1; j < temperatures.size(); j++) {
                if (temperatures.get(i) < temperatures.get(j)){
                    count = j-i;
                    break;
                }
            }
            answer[i] = count;
        }
        for (int j : answer) {
            System.out.print(j);
        }

    }


}
