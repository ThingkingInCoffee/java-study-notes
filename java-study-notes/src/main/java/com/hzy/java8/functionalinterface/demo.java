package com.hzy.java8.functionalinterface;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * java8 提供了 4大核心函数是接口
 *
 * Consumer<T>  消费型接口
 * void accept(T t);
 *
 * Supplier<T>  供给型接口
 * T get();
 *
 * Function<T, R>  函数型接口
 * R apply(T t);
 *
 * Predicate<T>  断言型接口
 * boolean test(T t);
 */
public class demo {

    //消费型接口
    @Test
    public void test01() {
        method1(1000, (m) -> System.out.println(m));
    }

    public void method1(Integer arg, Consumer<Integer> consumer) {
        consumer.accept(arg);
    }


    //供给型接口

}
