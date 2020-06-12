package com.hzy.encryption.symmetric.DesDemo;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DesDemo {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String source = "测试des123456";
        // key
        String key = "12345678";
        // 算法
        String algorithm = "DES";
        // 模式
        String transformation = "DES";

        Cipher cipher = Cipher.getInstance(algorithm); //异常抛出
        // 加密规则
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 加密初始化
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        // 加密
        byte[] doFinalBytes = cipher.doFinal(source.getBytes());//异常抛出
        // 可读性处理
        byte[] encode = Base64.getEncoder().encode(doFinalBytes);
        String encodeString = new String(encode);
        System.out.println(encodeString);

        String decryptDes = getDecryptDes(encodeString, key, transformation, algorithm);
        System.out.println(decryptDes);
    }

    public static String getDecryptDes(String encodeString, String key, String transformation, String algorithm) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(algorithm); //异常抛出
        // 解密规则
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 解密初始化
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decode = Base64.getDecoder().decode(encodeString);
        byte[] bytes = cipher.doFinal(decode);
        return new String(bytes);
    }

}
