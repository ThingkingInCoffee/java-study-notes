package com.hzy.encryption;

public class TuoMinDemo {

    public static void main(String[] args) {
        String email = "zhasdfada@163.com";
        System.out.println("原邮箱： " + email);
        String emailString = email.replaceAll("(^\\w)[^@]*(@.*$)", "$1****$2");
        System.out.println("脱敏后： " + emailString);

        System.out.println("---------------------------");

        String phone = "18988889999";
        System.out.println("原电话： " + phone);
        phone = phone.replaceAll("(^\\d{3})\\d.*(\\d{4})", "$1****$2");
        System.out.println("脱敏后： " + phone);


        String address = "啊实打实打算v阿飞隔热如果人噶热".replaceAll("(^\\S)[\\S]*$", "$1******");
        System.out.println(address);
    }

}
