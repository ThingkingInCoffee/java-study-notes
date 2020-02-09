package com.hzy.java8.stream.terminal;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 *  校验全匹配
 *  校验任意匹配
 *  校验无匹配
 */
public class MatchDemo {

    List<String> strings = Arrays.asList(
            "aaa", "ddd", "eee", "bbb", "ccc", "fff"
    );

    @Test
    public void test01() {
        boolean allMatch01 = strings.stream().allMatch((x) -> x.equals("aaa"));
        System.out.println(allMatch01);
        boolean allMatch02 = strings.stream().allMatch((x) -> x.length() == 3);
        System.out.println(allMatch02);

        boolean anyMatch01 = strings.stream().anyMatch((x) -> x.equals("aaa"));
        System.out.println(anyMatch01);
        boolean anyMatch02 = strings.stream().anyMatch((x) -> x.equals("ggg"));
        System.out.println(anyMatch02);

        boolean noneMatch01 = strings.stream().noneMatch((x) -> x.equals("aaa"));
        System.out.println(noneMatch01);
        boolean noneMatch02 = strings.stream().noneMatch((x) -> x.equals("ggg"));
        System.out.println(noneMatch02);
    }

}
