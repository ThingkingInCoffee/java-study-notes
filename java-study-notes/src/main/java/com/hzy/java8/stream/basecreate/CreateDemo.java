package com.hzy.java8.stream.basecreate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream 的三个操作步骤
 * 1、创建 Stream
 * 2、操作 Stream
 * 3、终止操作
 */
public class CreateDemo {

    //创建 Stream
    @Test
    public void create01(){
        //通过Collection 系列集合提供的 Stream()方法  或  parallelStream() 方法
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();  //方式一

        //通过 Arrays 中的静态方法 stream() 方法获取数组流
        String[] strings = new String[10];
        Stream<String> stream1 = Arrays.stream(strings); //方式二

        //通过 stream 类中的静态方法  of() 方法
        Stream<String> stream2 = Stream.of("qwer","asdf","hdfghdgf"); //方式三

        //创建 无限流
        Stream<Integer> stream3 = Stream.iterate(0,(x) -> x + 2);
        stream3.limit(10).forEach(System.out::println);  //方式四

        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(5).forEach(System.out::println); //方式四

    }


}
