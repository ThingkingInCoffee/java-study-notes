package com.hzy.base.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService threadPool = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(threadPool.submit(() -> {
                Thread.sleep(1000);
                return 1;
            }));
        }
        Integer sum = 0;
        for (Future<Integer> future : futures) {
            final Integer integer = future.get();
            sum = sum + integer;
        }
        System.out.println(sum);
    }


}
