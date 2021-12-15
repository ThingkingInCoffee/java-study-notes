package com.hzy.base.thread;

/**
 * @author hzy
 * @description: ThreadLocalDemo.java
 * @date 2021/12/14 14:12
 */
public class ThreadLocalDemo {

    private static ThreadLocal<Integer> tInt = new ThreadLocal<>();

    public static void main(String[] args) {
//        tInt.set(123);
//        Integer integer = tInt.get();
//        System.out.println(integer);

        new Thread(() -> {
            try {
                Thread.sleep(1000); // 可以调整时间更换两个线程赋值顺序
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LocalUtil.set(1);
            System.out.println("T1  res ===" + LocalUtil.get());
        }, "T1").start();
        new Thread(() -> {
            try {
                Thread.sleep(2000); // 可以调整时间更换两个线程赋值顺序
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LocalUtil.set(2);
            System.out.println("T2  res ===" + LocalUtil.get());
        }, "T2").start();

    }

}
