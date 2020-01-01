package com.hzy.designpatterns.singleton;

/**
 * 懒汉模式 同步方法  线程安全
 */
public class Singleton04 {

    private Singleton04() {

    }

    private static Singleton04 instance;

    public static synchronized Singleton04 getInstance(){
        if (instance == null) {
            instance = new Singleton04();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton04 sin = Singleton04.getInstance();
        Singleton04 sin2 = Singleton04.getInstance();

        System.out.println(sin == sin2);
    }


}
