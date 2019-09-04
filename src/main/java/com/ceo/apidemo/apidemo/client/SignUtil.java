package com.ceo.apidemo.apidemo.client;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class SignUtil {

    public static String sign(Map<String, String> paramMap, String secret) throws Exception {
        StringBuilder sb = new StringBuilder();
        TreeMap<String, String> params = new TreeMap<>();
        params.putAll(paramMap);
        params.entrySet()
                .forEach(entry -> {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(entry.getKey()).append("=");
                    sb.append(entry.getValue());
                });
        return sign(sb.toString(), secret);
    }

    public static String convertStr(Map<String, String> paramMap){
        StringBuilder sb = new StringBuilder();
        TreeMap<String, String> params = new TreeMap<>();
        params.putAll(paramMap);
        params.entrySet()
                .forEach(entry -> {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(entry.getKey()).append("=");
                    sb.append(entry.getValue());
                });
        return sb.toString();
    }

    public static String sign(String paramString, String secretKey) throws Exception {
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacMD5");
        String actualSignature = "";
        try {
            actualSignature = Hex.encodeHexString(encodeHmacMD5(paramString.getBytes("UTF-8"), secret_key));
        } catch (UnsupportedEncodingException e) {
            throw new Exception("验签加密失败!");
        }
        return actualSignature;
    }


    /**
     * 根据给定密钥生成算法创建密钥
     *
     * @param algorithm 密钥算法
     * @return 密钥
     * @throws RuntimeException 当 {@link NoSuchAlgorithmException} 发生时
     */
    private static byte[] getHmacKey(String algorithm) {
        //初始化KeyGenerator
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
        //产生密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //获得密钥
        return secretKey.getEncoded();
    }

    /**
     * 使用HmacMD5消息摘要算法计算消息摘要
     *
     * @param data 做消息摘要的数据
     * @param key  密钥
     * @return 消息摘要（长度为16的字节数组）
     */
    private static byte[] encodeHmacMD5(byte[] data, Key key) {
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacMD5");
            mac.init(key);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            return new byte[0];
        }
        return mac.doFinal(data);
    }


    private String sign2(String target) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        md.update(target.getBytes());
        byte dg[] = md.digest();
        StringBuilder output = new StringBuilder(dg.length * 2);
        for (byte dgByte : dg) {
            int current = dgByte & 0xff;
            if (current < 16)
                output.append("0");
            output.append(Integer.toString(current, 16));
        }
        return output.toString();
    }
}
