//package com.hzy.encryption.dissymmetric.RsaDemo;
//
//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import java.security.*;
//
//public class RsaDemo {
//
//    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, Base64DecodingException {
//        // 原文
//        String sourceString = "加密前的文字123abc";
//        // 使用的算法
//        String algorithm = "RSA";
//        // 密钥对生成器
//        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm); // 异常抛出
//        // 生成密钥对
//        KeyPair keyPair = generator.generateKeyPair();
//        // 私钥
//        PrivateKey privateKey = keyPair.getPrivate();
//        // 公钥
//        PublicKey publicKey = keyPair.getPublic();
//        // 私钥字节数组
//        byte[] privateKeyEncoded = privateKey.getEncoded();
//        // 公钥字节数组
//        byte[] publicKeyEncoded = publicKey.getEncoded();
//        // base64 转码 防止乱码
//        String privateKeyEncodedString = Base64.encode(privateKeyEncoded);
//        String publicKeyEncodedString = Base64.encode(publicKeyEncoded);
//        // 打印公钥私钥
//        System.out.println("privateKeyEncodedString = "+privateKeyEncodedString);
//        System.out.println("publicKeyEncodedString = "+publicKeyEncodedString);
//
//        // 创建加密对象
//        Cipher cipher = Cipher.getInstance(algorithm); // 异常抛出
//        // 加密初始化
//        // 参数一 处理模式 加密或解密
//        // 参数二 处理使用的密钥，公钥或私钥
//        cipher.init(Cipher.ENCRYPT_MODE, privateKey); //异常抛出
//        // 加密处理
//        byte[] bytes = cipher.doFinal(sourceString.getBytes());//异常抛出
//        // base64 转码
//        String encode = Base64.encode(bytes);
//        System.out.println("encode result = "+encode);
//
//        // 解密
//        cipher.init(Cipher.DECRYPT_MODE, publicKey);
//        byte[] decode = Base64.decode(encode); //异常抛出
//        byte[] sourceBytes = cipher.doFinal(decode);
//        System.out.println("sourceString = "+new String(sourceBytes));
//    }
//}
