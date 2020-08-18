package com.hzy.encryption.dissymmetric.RsaDemo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

public class Demo {

    public static void main(String[] args) {
        String privateKeyString = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJfbjctBDVrrQq/4nATPrQ7LsF+k\n" +
                "05b0dpejiml+It2JU7LkRqOWVbiqDlIC6esP3UqPQPylff1fseOfvn2e2uwca/WjRgRoQDAmlJZH\n" +
                "ldEw+rtckcXYkpA4P0ZNiX8VX+oEyOvlNxGYWIvu3gIK7BIMLXb99mbxR2suAcCud7TBAgMBAAEC\n" +
                "gYAU6hYTQjhWp0Qd/D1wpDGPchoucgL6LV0P8WQkt0yR+lHet3XLHe9caX9jaCdTSnINzMEEir5Z\n" +
                "YQ6c7OlNX82Cs/tNoyfHl9mY3gxuaLIifSo12XdRJDEg3ReuzO3drWBKM2eOw6lyRWpFuovEUADe\n" +
                "Oy3QDPBwjBMZbZGEtFFFYQJBAO3IuoHPshgVCEp6A44Db+WQzlNmqZEoBGDua8iBu+TTxe8xzO5q\n" +
                "MBraSR4tiuF2nRymqt6qShWcUj7N6joOq7UCQQCjfbCYX9ZSoXa3tMulFCIfbpr2waQ0vvrYfdbt\n" +
                "uc4aMt4mq+ClOUjDFFKsy/PoIoSlq1mhPYyI+SpF9wVQcoRdAkA2pglnSCqwKjVLmJs0ikmvQwaI\n" +
                "WHHkMIRBGsqevGJIhvtYq+Njb/g6U6y2SNVAWBhnu05N+mkoalLkqEKKsVB5AkEAgIQkFpN3iXrt\n" +
                "NJmFX53E+Qpb/E7ZwrDBxP6evj7J2eRUpveDXr36CYdnOfgVIkxIE2bvzQTx/RZIebklT0jF7QJA\n" +
                "TQ0o28ixVFs3QtqpWhtP6b0D6RJG8MLjFaogV25/i20UUDTc0ZguvFtEiz/KcQUhO6RZDO7Q7s+T\n" +
                "fG1/2JVV0Q==";

        String publicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCX243LQQ1a60Kv+JwEz60Oy7BfpNOW9HaXo4pp\n" +
                "fiLdiVOy5EajllW4qg5SAunrD91Kj0D8pX39X7Hjn759ntrsHGv1o0YEaEAwJpSWR5XRMPq7XJHF\n" +
                "2JKQOD9GTYl/FV/qBMjr5TcRmFiL7t4CCuwSDC12/fZm8UdrLgHArne0wQIDAQAB";

        RSA rsa = new RSA(privateKeyString, publicKeyString);

        String a = "R6cXSIVanZf/yBvSmLwNr/LmWB1Aou5QaxwGtWMJWpTlsehPPfhRIlh+P3Ba/INlAaLy1S/xvgs3\n" +
                "tdhtJCeXdArnBlamPNfqC2VPx6t+3crzSwptRuS7OCggi7lZ+fiuVSotQ3gsNNIaQ5/URoNaAQhy\n" +
                "9D4gWLS1bQYpAUsU4vU=";

//        byte[] aByte = HexUtil.decodeHex(a);
        byte[] aByte = Base64.decode(a);
        byte[] decrypt = rsa.decrypt(aByte, KeyType.PublicKey);
        System.out.println(new String(decrypt));
    }

}
