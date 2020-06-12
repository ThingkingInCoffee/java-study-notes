package com.hzy.encryption.Md5Demo;

import java.security.MessageDigest;

public class MD5Demo {

    public static void main(String[] args) {
        String str = "ALIWAP|2015100908096|http://pre.shangpin.com/mshangpin/pay/callback/ALIWAP|订单号:2015100908096|243.0020d25a781966242057ed941c39e43713";
        String encryptStr = MD5(str);
        System.out.println("加密前：" + str);
        System.out.println("加密后：" + encryptStr);
    }

    public static String MD5(String sourceStr) {
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(sourceStr.getBytes());
            byte[] md = mdInst.digest();
            StringBuffer buf = new StringBuffer();

            for(int i = 0; i < md.length; ++i) {
                int tmp = md[i];
                if (tmp < 0) {
                    tmp += 256;
                }

                if (tmp < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(tmp));
            }

            return buf.toString().toUpperCase();
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

}
