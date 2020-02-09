package com.hzy.java8.stream.intermediate;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 跳过元素，扔掉前 n 个数据的流，若总个数小于 n 则返回一个空的流，
 * 与 limit() 是互补的
 */
public class SkipDemo {

    List<User> users = Arrays.asList(
            new User("张三", 19, 165150.63),
            new User("李四", 29, 265150.63),
            new User("王五", 39, 365150.63),
            new User("马六", 49, 465150.63),
            new User("赵七", 59, 565150.63)
    );

    @Test
    public void testSkip() {
        Stream<User> userStream = users.stream().filter((x) -> {
            System.out.println("skip 过滤");
            return x.getMoney() > 200000.0;
        });
        userStream.skip(2).forEach(System.out::println);
        System.out.println("===========================");
    }

}
