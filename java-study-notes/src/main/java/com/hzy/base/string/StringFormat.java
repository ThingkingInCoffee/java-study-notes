package com.hzy.base.string;

/**
 * @author hzy
 * <p>
 * https://blog.csdn.net/anita9999/article/details/82346552/
 * @description: StringFormat.java
 * @date 2021/12/23 14:31
 */
public class StringFormat {

    public static void main(String[] args) {
        String sss = "test %s version %f .apk";
        String format = String.format(sss, "2.4.release", 2.4);
        System.out.println(format);
    }

}
