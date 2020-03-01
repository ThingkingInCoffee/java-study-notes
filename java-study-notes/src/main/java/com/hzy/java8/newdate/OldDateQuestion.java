package com.hzy.java8.newdate;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 *  Date 类在多线程情况下会出现问题
 */
public class OldDateQuestion {

    /**
     *  多线程下  date  的并发问题
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test() throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return simpleDateFormat.parse("20161212");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(100);

        List<Future<Date>> result = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            result.add(pool.submit(callable));
        }

        for (Future<Date> dateFuture : result) {
            System.out.println(dateFuture.get());
        }


    }


    /**
     *  问题解决方式
     */
    @Test
    public void resolve() throws ExecutionException, InterruptedException {
        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatThreadLocal.convert("20161212");
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(100);

        List<Future<Date>> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result.add(pool.submit(callable));
        }

        for (Future<Date> dateFuture : result) {
            System.out.println(dateFuture.get());
        }
    }




}
