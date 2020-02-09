package com.hzy.java8.stream.intermediate;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *  去重操作
 *  注意需要 重写 hashcode 和 equals
 */
public class DistinctDemo {

    List<User> users = Arrays.asList(
            new User("张三", 19, 165150.63),
            new User("李四", 29, 265150.63),
            new User("王五", 39, 365150.63),
            new User("王五", 39, 365150.63),
            new User("王五", 39, 365150.63),
            new User("马六", 49, 465150.63),
            new User("赵七", 59, 565150.63)
    );

    @Test
    public void testDistinct() {
        Stream<User> userStream = users.stream();
        userStream.distinct().forEach(System.out::println); //注意需要 user 重写 hashcode 和 equals
        System.out.println("===========================");
    }

}
