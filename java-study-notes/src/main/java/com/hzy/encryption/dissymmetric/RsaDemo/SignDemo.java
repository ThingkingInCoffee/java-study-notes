package com.hzy.encryption.dissymmetric.RsaDemo;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class SignDemo {


    /**
     * 使用RSA签名
     * 在加签验签的时候需要传入一个数字签名标准，我们这里填的是 SHA1WithRSA，它的意思是用 SHA 算法进行签名，用 RSA 算法进行加密。
     */
    private static String signWithRSA(String content, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initSign(privateKey);
        signature.update(content.getBytes("utf-8"));
        byte[] signed = signature.sign();
        return base64Encode(signed);
    }

    private static String base64Encode(byte[] signed) {
        return null;
    }


    /**
     * 使用RSA验签
     */
    private static boolean checkSignWithRSA(String content, PublicKey publicKey, String sign) throws Exception {
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initVerify(publicKey);
        signature.update(content.getBytes("utf-8"));
        return signature.verify(base64Decode(sign));
    }

    private static byte[] base64Decode(String sign) {
        return null;
    }


}
