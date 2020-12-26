package com.hzy.java8.stream.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(Integer.toString(i));
        }
        List<String> strings = list.parallelStream().map(s -> {
            System.out.println("线程名称==" + Thread.currentThread().getName());
            return s + "sss";
        }).collect(Collectors.toList());
        System.out.println(strings.size());

//        ForkJoinPool pool = new ForkJoinPool();
//        Future<List<string>> s = pool.submit(() -> {
//            list.parallelStream().map(s -> {
//                System.out.println("线程名称==" + Thread.currentThread().getName());
//                return s + "sss";
//            }).collect(Collectors.toList());
//        });
//        try {
//            List<string> test = s.get();
//            System.out.println(test.size());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        long firstNum = 1;
        long lastNum = 1000000;

        List<Long> aList = LongStream.rangeClosed(firstNum, lastNum).boxed()
                .collect(Collectors.toList());

        Long reduce = aList.parallelStream().reduce(0L, Long::sum);
        System.out.println(reduce);

        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        long actualTotal = customThreadPool.submit(
                () -> aList.parallelStream().reduce(0L, Long::sum)).get();
        System.out.println(actualTotal);

        Stream<Person> longStream = customThreadPool.submit(
                () -> aList.parallelStream().filter(x -> x < 40).map(y->new Person(y.toString(), "name"+y))).get();
        System.out.println(longStream.count());
    }

    static class Person{
        private String age;
        private String name;

        public Person(String age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
