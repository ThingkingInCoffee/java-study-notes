package com.hzy.base.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        String lock = "lock";
        AtomicInteger ai = new AtomicInteger(0);
        final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
        final ThreadPoolExecutor.CallerRunsPolicy refuse = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 300, TimeUnit.SECONDS, queue, refuse);
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                try {
                    synchronized (lock) {
                        System.out.println("thread-" + Thread.currentThread() + "当前数据" + ai.incrementAndGet());
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

}
