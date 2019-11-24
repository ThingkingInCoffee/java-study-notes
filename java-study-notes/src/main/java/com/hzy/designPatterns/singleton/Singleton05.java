package com.hzy.designPatterns.singleton;

/**
 * 懒汉模式  同步代码块   线程不安全！！！！
 */
public class Singleton05 {
    
    private Singleton05(){}
    private static Singleton05 instance;
    
    public static Singleton05 getInstance(){
        synchronized (Singleton05.class){
            if (instance == null) {
                instance = new Singleton05();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton05 sin = Singleton05.getInstance();
        Singleton05 sin2 = Singleton05.getInstance();

        System.out.println(sin == sin2);
    }
    
}
