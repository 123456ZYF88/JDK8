package org.example04;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * @author zhangyifan
 * @version 8.0
 * @description: \u000d编译
 * @date 2022/9/12 22:15
 */
public class UnicodeTest {
/*    public static void main(String[] args) {
        String name ="张三";
        // \u000d name ="李四";
        System.out.println(name);
    }*/

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        System.out.println("明年的所有月份：");
        for (int i = 1; i <= 12; i++) {
            System.out.println(year + "" + (month < 10 ? "0" + month : month));
            month++;
            if (month > 12) {
                month = 1;
            }
        }
    }
    @Test
    public void filet(){
        try {
            java.io.FileWriter f =new //\u000djava.\u000dio.\u000dFileWriter\u000d("t.txt");
                    f.//\u000dwrite//\u000d("abcd");
                  f.//\u000dclose//\u000d();
          System.out.println("文件创建成功");
            f.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
