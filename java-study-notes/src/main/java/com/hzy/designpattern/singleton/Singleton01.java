package com.hzy.designpattern.singleton;

/**
 * 饿汉模式 01
 */
public class Singleton01 {

    private Singleton01(){
        System.out.println("Singleton01");
    }
    private static Singleton01 instance = new Singleton01();

    public static Singleton01 getInstance() {
        System.out.println("getInstance");
        return instance;
    }

    public static void main(String[] args) {
//        Singleton01 sss;
        System.out.println("---");
        Singleton01 sin = Singleton01.getInstance();
        Singleton01 sin2 = Singleton01.getInstance();

        System.out.println(sin == sin2);
    }
}
