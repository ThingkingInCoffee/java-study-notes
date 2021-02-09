package com.hzy.encryption.dissymmetric.RsaDemo;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;

public class EnDecrypt {

    private static final String RSA_ALGORITHM = "RSA";
    private static final String UTF8 = "UTF-8";

    public static byte[] encrypt(PublicKey publicKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(message.getBytes(UTF8));
    }


    public static byte[] decrypt(PrivateKey privateKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(encrypted);
    }

}
