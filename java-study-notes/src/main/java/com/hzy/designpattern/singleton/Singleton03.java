package com.hzy.designpattern.singleton;

/**
 * 懒汉模式 01  线程不安全
 */
public class Singleton03 {

    private Singleton03() {
        System.out.println("init");
    }

    private static Singleton03 instance;

    public static Singleton03 getInstance(){
        if (instance == null) {
            System.out.println("new");
            instance = new Singleton03();
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("start");
        Singleton03 sin = Singleton03.getInstance();
        Singleton03 sin2 = Singleton03.getInstance();

        System.out.println(sin == sin2);
    }

}
