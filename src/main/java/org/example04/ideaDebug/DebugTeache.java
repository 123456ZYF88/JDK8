package org.example04.ideaDebug;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DebugTeache {
    /*
    视频地址
    * https://www.bilibili.com/video/BV1Rm4y1P7j8/?spm_id_from=333.1007.top_right_bar_window_default_collection.content.click&vd_source=2408eb3d0885a5f3fb0c7c2a6a8d03e2
    * */

    private static List<Integer> objects = new ArrayList<>() ;


    /**
     * 断点条件
     */
    @Test
    public void TestDebugCondition(){
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        for(Integer a:objects){
            System.out.println(a);/*a==2*/
        }

    }

    /**
     * 断电回退
     */
    @Test
    public void debugAndDrop(){
            System.out.println("第一次输出");
            System.out.println("第二次输出");
            System.out.println("第三次输出");
    }

    /**
     * 执行表达式  Expression
     */
    @Test
    public void debugWithExpression(){
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);/* [23, 1, 2, 3, 4]*/
        System.out.println(objects);
    }

    /**
     ForceReturn
     */




}
