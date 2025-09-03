package org.exampleUtils01.threadUtil;

import com.google.common.util.concurrent.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 * @author zhangyf
 * @date 2025/6/16 17:19
 */

public class CompletableFutureTEST     {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        ListeningExecutorService guavaExecutor = MoreExecutors.listeningDecorator(executor);
        ListenableFuture<String> future1 = guavaExecutor.submit(() -> {
            //step 1
            System.out.println("执行step 1");
            return "step1 result";
        });
        ListenableFuture<String> future2 = guavaExecutor.submit(() -> {
            //step 2
            System.out.println("执行step 2");
            return "step2 result";
        });


        ListenableFuture<List<String>> future1And2 = Futures.allAsList(future1, future2);
        Futures.addCallback(future1And2,new FutureCallback<List<String>>()

        {
            @Override
            public void onSuccess (List <String> result) {
                System.out.println(result);
                ListenableFuture<String> future3 = guavaExecutor.submit(() -> {
                    System.out.println("执行step 3");
                    return "step3 result";
                });
                Futures.addCallback(future3, new FutureCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        System.out.println(result);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                    }
                }, guavaExecutor);
            }

            @Override
            public void onFailure (Throwable t){
            }
        },guavaExecutor);
    }

    @Test
    public void test2() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 1");
            return "step1 result";
        }, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("执行step 2");
            return "step2 result";
        });
        cf1.thenCombine(cf2, (result1, result2) -> {
            System.out.println(result1 + " , " + result2);
            System.out.println("执行step 3");
            return "step3 result";
        }).thenAccept(System.out::println);
    }

    @Test
    public void test3() {
        System.out.println( flightNoEquals("CZ34", "CZ0030"));
    }
    public static boolean flightNoEquals(String flightNo1, String flightNo2) {
        // 使用正则表达式分割成字母部分和数字部分
        String[] parts1 = flightNo1.split("(?<=\\D)(?=\\d)");
        String[] parts2 = flightNo2.split("(?<=\\D)(?=\\d)");

        // 分别比较字母部分和数字部分
        if (!parts1[0].equals(parts2[0])) {
            return false; // 字母部分不相等
        }

        // 数字部分比较，忽略前导零
        int number1 = Integer.parseInt(parts1[1]);
        int number2 = Integer.parseInt(parts2[1]);

        return number1 == number2;
    }
}
