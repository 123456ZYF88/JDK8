package org.Test;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 百度订阅mq信息方法
 *
 * @author zhangyf
 * @date 2024/11/11 16:07
 */

public class BDTestMQ {


    private static RedisTemplate redisTemplate;
    public static void subMqMessage(MqMsgReq msgReq) {
        // 1、在多个服务器运行 ，保证订阅信息的一致,需要做幂等性处理，比如在redis中做标记，如果已经订阅过，就不订阅了。

        //设置消费信息，将每条消息的消息id都放到redis中，防止重复消费，
        // 将工单id放到redis中，防止重复工单操作，工单id的数据值设置为布尔类型或者其他类型满足第四个业务，保证
        redisTemplate.get("mq_xx" + msgReq.getMsgId()+ LocalDateTime.now());
        redisTemplate.set("mq_xx" + msgReq.getMsgId()+ LocalDateTime.now());
        String set = redisTemplate.set("mq_gd" + msgReq.getCaseId()+ LocalDateTime.now());

        if (set == null) {
            return;
        }

        //2 、构建线程池进行消费（注意线程池大小处理线程池已满的情况）， 不能丢弃信息
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new ThreadPoolExecutor.CallerRunsPolicy());
        executor.execute(() -> {
            System.out.println("开始消费信息");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        // 3、 保证不同opType的对应的data结构不一样，注意扩展性
        /* 根据OpTyoe不同去匹配不同的数据结构来解析不同平台的数据格式，使用策略模式去处理*/
        switch (msgReq.getOpType()) {
            case "create":
              msgReq.getData();
                // 创建工单，处理数据
                break;
            case "update":
                msgReq.getData();
                // 更新工单，处理数据
                break;
            case "delete":
                msgReq.getData();
                // 删除工单，处理数据
                break;
            default:
                // 默认处理格式
                break;
        }
        //4、 caseId相同的消息，是对同一个工单的操作，不能并发消费caseId，只有一条信息在被消费
        // 如果 有一个服务器开始处理一个工单的信息，那么同一个工单的其他信息都需要等待处理完成，才继续处理
        String caseId = msgReq.getCaseId();

        String lock = redisTemplate.get("mq_"+caseId);
        //判断redis中的工单值是否可以进行信息消费

        //消费完成时，删除key
        redisTemplate.delete("mq_"+caseId);




    }

}

