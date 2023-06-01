package org.example02.dem04Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @ClassName Test4
 * @Description 并行和串行的Stream流
 * @Author  ZHANG YI FAN
 * @Date 2023/6/1 9:26
 * @Version 1.0
 **/
public class Test4 {
    /*
    * 直接获取并行流: parallelStream()
      将串行流转成并行流: parallel()
    *
    * */

    @Test
    /**
     * 串行
     *
     */
    public void test0Serial(){
        long count = Stream.of(4, 5, 3, 9, 1, 2, 6)
                .filter(s -> {
                    System.out.println(Thread.currentThread() + "::" + s);
                    return s > 3;
                }).count();
        System.out.println("count = " + count);
    }

    /**
     * 并行的流
     * parallelStream其实就是一个并行执行的流。它通过默认的ForkJoinPool，可能提高多线程任务的速度。
      */
    @Test
    public void testgetParallelStream(){
        /*
        * 1. 直接获取并行的流
          2. 将串行流转成并行流
        * */
        //1
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.parallelStream();

    }

    /**
     * 将串行流转成并行流
     */
    @Test
    public void testParallel(){
        long count = Stream.of(4, 5, 3, 9, 1, 2, 6).parallel()
                .filter(s -> {
                    System.out.println(Thread.currentThread() + "::"+s);
                    return s > 3;
                }).count();
        System.out.println(count);
    }

    private  static long times=50000000000L;
    private long start;

    /**
     * 开始方法计数
     */
    @BeforeEach
    public  void init(){
        start = System.currentTimeMillis();
    }

    /**
     * 结束方法
     */
    @AfterEach
    public  void destory(){
        long l = System.currentTimeMillis();
        System.out.println("消耗"+(l-start));
    }

    //并行 消耗5481
    @Test
    public void parallelStream(){
        System.out.println("para");
        LongStream.rangeClosed(0,times).parallel().reduce(0,Long::sum);

    }
    //串行 消耗21881
    @Test
    public void  serialStream(){
        System.out.println("serialStream = " );
        LongStream.rangeClosed(0,times).reduce(0,Long::sum);
    }
    //for 消耗13144 公司电脑真垃圾
    @Test
    public void   forAdd(){
        System.out.println("forAdd");
        long rs=0L;
        for (long a=1L;a<times;a++){
            rs+=a;
         }
    }


}
