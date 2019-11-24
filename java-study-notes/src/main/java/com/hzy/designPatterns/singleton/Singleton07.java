package com.hzy.designPatterns.singleton;

/**
 * 静态内部类方式   线程安全
 */
public class Singleton07 {
    
    private Singleton07 (){}

    private static class InnerClass {
        private static final Singleton07 INSTANCE = new Singleton07();
    }
    
    public static Singleton07 getInstance() {
        return InnerClass.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton07 sin = Singleton07.getInstance();
        Singleton07 sin2 = Singleton07.getInstance();
        System.out.println(sin == sin2);
    }
    
}
