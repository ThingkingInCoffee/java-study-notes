package com.hzy.java8.stream.terminal;

import com.sun.org.apache.xpath.internal.operations.And;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 查找
 */
public class FindDemo {

    List<String> strings = Arrays.asList(
            "aaa","ddd","eee","bbb","ccc","fff"
    );

    @Test
    public void test01() {
        Optional<String> first = strings.stream().findFirst();
        System.out.println(first.get());

        Optional<String> any = strings.parallelStream().findAny();
        System.out.println(any.get());
    }

}
