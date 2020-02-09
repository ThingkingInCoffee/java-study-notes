package com.hzy.java8.stream.intermediate;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *  filter(Predicate) ：将表达式结果为false的元素过滤掉
 */
public class FilterDemo {

    List<User> users = Arrays.asList(
            new User("张三",19,165150.63),
            new User("李四",29,265150.63),
            new User("王五",39,365150.63),
            new User("马六",49,465150.63),
            new User("赵七",59,565150.63)
    );

    //Stream<T> filter(Predicate<? super T> predicate);
    @Test
    public void test(){
        Stream<User> userStream = users.stream();
        userStream.filter((x) -> x.getAge() > 30).forEach(System.out::println);
    }


}
