package com.hzy.java8.functionalinterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 提供了 4大核心函数是接口
 * <p>
 * Consumer<T>  消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T>  供给型接口
 * T get();
 * <p>
 * Function<T, R>  函数型接口
 * R apply(T t);
 * <p>
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
    @Test
    public void test02() {
        List<Integer> integers = method2(6, () -> (int) (Math.random() * 100));
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public List<Integer> method2(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    //函数型接口
    @Test
    public void test03(){
        String result = method3("    test string \t\t\t", (s -> s.trim()));
        System.out.println(result);
    }

    public String method3(String source, Function<String, String> function){
        return function.apply(source);
    }

    //断言型接口
    @Test
    public void test04(){
        List<String> list = Arrays.asList("qwerqwerqewr","qwerqfewfq","qwe","qwerqwrqw");
        List<String> result = method4(list, (args) -> args.length() < 5);
        System.out.println(result.toString());
    }

    public List<String> method4(List<String> sourceList, Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for (String s : sourceList) {
            if (predicate.test(s)) {
                result.add(s);
            }
        }
        return result;
    }
}
