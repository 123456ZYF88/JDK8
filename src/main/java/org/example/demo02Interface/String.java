package org.example.demo02Interface;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyifan
 * @version 8.0
 * @description:
 * @date 2022/3/27 14:38
 */
public class String {
    public static void main(java.lang.String[] args) {
        java.lang.String a = "123455";
        StringBuilder stringBuilder=new StringBuilder().append(a);
        StringBuilder reverse = stringBuilder.reverse();
        System.out.println(stringBuilder.equals(reverse.toString()));
    }
    @Test
    public void stringg(){
        java.lang.String a = "123521";

        System.out.println(a.indexOf(1));
        Map map=new HashMap();
        List list=new ArrayList();
         System.out.println(a.charAt(1));
        int length = a.length();
        int j=length-1;
        for(int i=0;i<length;i++){
             char c = a.charAt(i);
             char b= a.charAt(j);
             --j;
             if (c!=b){
                 System.out.println("c");
                 return ;
             }else {
                 System.out.println("是回文数");
            }
         }
    }
    @Test
    public void hws(){
        int a=123321;
        int d=a;
        int s= 0;
        while (a!=0){
            int c = a%10;
            s =s*10+c;
            a=a/10;

        }

        if (s==d){
            System.out.println("t");
        }else {
            System.out.println("f");
        }

    }
}
