package com.hzy.designpattern.singleton;

/**
 * 枚举类方法
 */
public class Singleton08 {

    public static void main(String[] args) {
        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;
        System.out.println(s1==s2);
    }

}

enum Singleton{
    INSTANCE;
}
