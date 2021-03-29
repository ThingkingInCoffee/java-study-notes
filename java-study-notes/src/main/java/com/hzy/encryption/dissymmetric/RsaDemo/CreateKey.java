package com.hzy.encryption.dissymmetric.RsaDemo;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class CreateKey {


    private static final String RSA_ALGORITHM = "RSA";

    public static void main(String[] args) {

    }


    /**
     * 方法一 Java代码生成
     * 可以指定生成密钥的长度，最低是 512。
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGenerator.initialize(keySize);
        return keyPairGenerator.genKeyPair();
    }

    /**
     * 方法二 命令行
     */
    public void fun02(){

        // 生成公钥和私钥
//        openssl genrsa -out key.pem 1024
//                -out 指定生成文件，此文件包含公钥和私钥两部分，所以即可以加密，也可以解密 1024 生成密钥的长度
    }

    /**
     * 方法三 密钥网站 http://web.chacuo.net/netrsakeypair
     */
    public void fun03(){

    }

}
