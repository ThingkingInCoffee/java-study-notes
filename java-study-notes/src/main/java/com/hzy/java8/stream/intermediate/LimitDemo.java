package com.hzy.java8.stream.intermediate;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LimitDemo {

    List<User> users = Arrays.asList(
            new User("张三", 19, 165150.63),
            new User("李四", 29, 265150.63),
            new User("王五", 39, 365150.63),
            new User("马六", 49, 465150.63),
            new User("赵七", 59, 565150.63)
    );

    @Test
    public void testLimit() {
        Stream<User> userStream = users.stream().filter((x) -> x.getMoney() > 200000.0);
        userStream.limit(2).forEach(System.out::println);
        System.out.println("===========================");
        //userStream.limit(2).forEach(System.out::println);
        //此处若再次对流进行操作，会抛出异常java.lang.IllegalStateException: stream has already been operated upon or closed 流关闭之后无法再次操作

        Stream<User> userStreams = users.stream().filter((x) -> {
            //通过打印次数可以判断出，过滤时，达到过滤个数之后则停止，不会继续，一定程度上节约了开销
            System.out.println("进行过滤");
            return x.getMoney() > 200000.0;
        });
        userStreams.limit(2).forEach(System.out::println);
    }


}
