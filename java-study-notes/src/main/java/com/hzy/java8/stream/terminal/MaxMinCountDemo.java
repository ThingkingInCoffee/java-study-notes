package com.hzy.java8.stream.terminal;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxMinCountDemo {

    List<Integer> integers = Arrays.asList(
            111, 222, 333, 444, 555, 666
    );

    @Test
    public void test01() {
        Optional<Integer> max = integers.stream().max((x, y) -> x.compareTo(y));
        System.out.println(max.get());

        long count = integers.stream().count();
        System.out.println(count);
    }

}
