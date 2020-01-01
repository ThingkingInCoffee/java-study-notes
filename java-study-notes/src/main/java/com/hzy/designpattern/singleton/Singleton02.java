package com.hzy.designpattern.singleton;

/**
 * 饿汉模式02  静态代码块
 */
public class Singleton02 {

    private Singleton02 () {
        System.out.println("init");
    }

    private static Singleton02 instance;
    static {
        System.out.println("static");
        instance = new Singleton02();
    }
    public static Singleton02 getInstance() {
        System.out.println("get");
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("start");
        Singleton02 sin = Singleton02.getInstance();
        Singleton02 sin2 = Singleton02.getInstance();

        System.out.println(sin == sin2);
    }

}
