package com.hzy.base.thread;

import java.util.Optional;

/**
 * @author hzy
 * @description: LocalUtil.java
 * @date 2021/12/14 21:18
 */
public class LocalUtil {

    private static ThreadLocal<Integer> userInfoThreadLocal = new ThreadLocal<>();

//    private static ThreadLocal<Integer> userInfoThreadLocal;

    /**
     * 设置全局用户信息
     *
     * @param integer
     */
    public static void set(Integer integer) {
        String name = Thread.currentThread().getName();
        System.out.println(name + "  set == " + integer.intValue());
        userInfoThreadLocal = ThreadLocal.withInitial(() -> integer);  // initial是改变ThreadLocal的默认初始值，是所有线程都会使用的
//        userInfoThreadLocal.set(integer);  // set是设置当前线程threadLocal对应的值
        System.out.println(name + "  set  当前local" + userInfoThreadLocal);
        try {
            Thread.sleep(1000);
            System.out.println("sleep 1000==" + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取全局用户信息
     *
     * @return
     */
    public static Integer get() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "  get  当前local" + userInfoThreadLocal);
        if (userInfoThreadLocal == null) {
            userInfoThreadLocal = ThreadLocal.withInitial(() -> new Integer(999));
        }
        return Optional.ofNullable(userInfoThreadLocal.get()).orElseGet(() -> new Integer(999));
    }

}
