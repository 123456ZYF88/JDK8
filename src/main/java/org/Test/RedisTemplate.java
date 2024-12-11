package org.Test;

/**
 *
 *
 * @author zhangyf
 * @date 2024/11/11 16:20
 */

public class RedisTemplate {
    public static void main(String[] args) {

    }
    public static String get(String key){
        System.out.println("如果key存在，不允许操作");
        return "ok";
    }
    public static String set(String key){

        System.out.println("如果key不存在，允许操作并存放key");

        System.out.println("如果key存在，不允许操作");
        if (true){
            return "ok";
        }{
            return "no";
        }


    }
    //delete
    public static void delete(String key){
        System.out.println("删除key");
    }
}
