package com.hzy.base.juc;

public class ReentrantLockDemo {

    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(()->{
            demo.test1();
        }, "thread0001").start();

        new Thread(()->{
            demo.test2();
        }, "thread0002").start();

    }


}

class Demo {
    public synchronized void test1() {
        try {
            System.out.println(Thread.currentThread().getName() + "-test1 开始sleep 1s");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "-test1 结束sleep 1s");
            test2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void test2() {
        try {
            System.out.println(Thread.currentThread().getName() + "-test2 开始sleep 10s");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + "-test2 结束sleep 10s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}