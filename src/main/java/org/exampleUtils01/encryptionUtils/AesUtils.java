package org.exampleUtils01.encryptionUtils;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



/**
 *
 *
 * @author zhangyf
 * @date 2024/12/4 16:26
 */

public class AesUtils {


    private static final byte[] iv = new byte[]{0x0, 0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8, 0x9, 0xA, 0xB, 0xC, 0xD, 0xE, 0xF};


    public static void main(String[] args) {
        String randomString = getRandomString();
        String encrypt = encrypt(randomString,
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4KZEu30Fh7R2LEiqn8WBRP1+6teZDdrhyVimhBEDIDglAmP1Sc+sWhy" +
                        "jwcuEeDNuQyct3LpO/+fRlEnbBL585qTAigagUAFBgpBKy7qOivMpLkY5bPcQhL0/w/7w4mVWW6WP9Tjy8AhfOM9KbjT234FEx" +
                        "inRH3ck2uhUD6QkHe7YJD3w4KVL5WRjv9+u+bqaF3vzPyHFQNhSTbHLsYu21YIKAegMYlvGuLZLIPG81JXukYvH9G3gY7tzK" +
                        "nQGi/xJJJvSe4Kl/xx/1CDX4QoilPRlfc26hMbm+cvY2UKhdSIEYBCdkAMJBSmLKaFjrq+JEPn3Csi47GCfL6ZWkoigUQIDAQAB");
        System.out.println(encrypt);

    }


    /**
     * AES加密参数
     * @param data 加密数据
     * @param key AES
     * @return
     */
    public static String encrypt(String data, String key) {
        byte[] iv = new byte[]{0x0, 0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8, 0x9,
                0xA, 0xB, 0xC, 0xD, 0xE, 0xF};
        byte[] bytes = null;
        try {
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Key aKey = new SecretKeySpec(key.getBytes(Charset.forName("UTF-8")),
                    "AES");
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(1, aKey, ivSpec);
            bytes = cipher.doFinal(data.getBytes(Charset.forName("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeBase64URLSafeString(bytes);
    }

    /**
     * AES256加密
     * @param content
     * @param bytePassword
     * @return
     */
    public static  byte[] encryptAES256(String content, byte[] bytePassword) {
        try {
            Cipher cipherInstance = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            SecretKeySpec key = new SecretKeySpec(bytePassword, "AES");
            cipherInstance.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes();
            byte[] cryptograph = cipherInstance.doFinal(byteContent);
            return cryptograph;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytePassword;
    }



    /**
     * 解密 base64
     */
    public static String decryptBase64(String data, String key) {

        byte[] bytes = null;
        try {
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Key aKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8),
                    "AES");
            Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
            cipher.init(2, aKey, ivSpec);
            bytes = cipher.doFinal(Base64.decodeBase64(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert bytes != null;
        return new String(bytes);

    }
    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key)  {
        return Base64.decodeBase64(key);
    }

    /**
     * 生成16位随机数
     */
    public static String getRandomString() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            char ch = str.charAt((int) (str.length() * Math.random()));
            sb.append(ch);
        }
        String string = sb.toString();
        try {
             System.out.println(string);
            return string;
        } catch (Exception e) {
            throw new RuntimeException("生成AES16位失败");
        }

    }




    /**
     * 对公共报文头进行加签处理，先将报文所有非空参数除去 sign 字段后按字母按升序排序, 并按 key=value&key=value 的形式生成待加密串, 用商户自己的 RSA 私钥进行加签(签名算
     * 法:SHA256WithRSA), base64 后将值放入 sign 字段，
     * @param object 加签数据
     * @param key 私钥
     * @return 签名
     */
    public static String sign(   Object object , String key) throws Exception {
        StringBuilder sb = new StringBuilder();
        //按字母按升序排序
        String[] keys = new String[]{"channelId", "acctId", "appId", "msgId", "bizId", "ip", "version", "callbackUrl", "timestamp", "requestBody", "key"};
        Arrays.sort(keys);
        Map<String, Object> map = objectToMap(object); //传入对象时可以进行转换
        for (String k : keys) {
            Object value = map.get(k);
            if (value != null && !"".equals(value)) {
                sb.append(k).append("=").append(value).append("&");
            }
        }
       // return signData(sb.toString(), key);
        return "test";
    }



    /**
     * 将对象转换成map
     * @param object
     * @return
     */
    public static Map<String, Object> objectToMap(Object object) {
        Map<String, Object> dataMap = new HashMap<>();
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                dataMap.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return dataMap;
    }





}
