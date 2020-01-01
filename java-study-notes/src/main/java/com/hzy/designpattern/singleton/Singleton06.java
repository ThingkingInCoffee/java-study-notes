package com.hzy.designpatterns.singleton;

/**
 * 双重检查模式  锁代码块    线程安全   推荐
 */
public class Singleton06 {
    
    private Singleton06(){}
    
    private static volatile Singleton06 instance;
    
    public static Singleton06 getInstance(){
        if (instance == null) {
            synchronized (Singleton06.class){
                if (instance == null) {
                    instance = new Singleton06();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton06 sin = Singleton06.getInstance();
        Singleton06 sin2 = Singleton06.getInstance();

        System.out.println(sin == sin2);
    }
    
}
