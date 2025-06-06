package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );



                LocalDateTime dateTime = LocalDateTime.of(2025, 3, 12, 11, 40, 5);

                // 转换为时间戳（毫秒）
                long timestamp = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

                System.out.println("时间戳（毫秒）：" + timestamp); // 输出：1741750805000

    }

    @Test
    public void test(){
        String s = md5Sign("3f81e160ff7c40f5b926a030bc76ead6","1747212062925", "1744943210827");
        System.out.println(s+"-"+System.currentTimeMillis()
        );
    }
    public static String md5Sign(String bussId, String reqId, String... keys) {
        String sign = md5(bussId + "&" + reqId);
        if (keys != null) {
            String keyStr = StringUtils.join(keys, "&");
            sign = md5(keyStr + "&" + sign);
        }
        return sign;
    }
    /**
     * 字符串md5
     *
     * @param text 加密字符串
     * @return md5加密后的字符串
     */
    public static String md5(String text) {
        return md5(text, "utf-8");
    }
    public static String md5(String text, String encoding) {
        MessageDigest msgDigest = null;
        try {
            msgDigest = MessageDigest.getInstance("MD5");
            msgDigest.update(text.getBytes(encoding));
            byte[] bytes = msgDigest.digest();
            return new String(encodeHex(bytes));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String md5Base64(String text) {
        MessageDigest msgDigest = null;
        try {
            msgDigest = MessageDigest.getInstance("MD5");
            msgDigest.update(text.getBytes());
            byte[] bytes = msgDigest.digest();
            // bytes 进行Base64编码

            byte[] bytes2 = Base64.getEncoder().encode(bytes);
            return new String(bytes2);
        } catch (NoSuchAlgorithmException  e) {
            e.printStackTrace();
        }
        return null;
    }

    public static char[] encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS[0x0F & data[i]];
        }
        return out;
    }
    /**
     * Used building output as Hex
     */
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

}
