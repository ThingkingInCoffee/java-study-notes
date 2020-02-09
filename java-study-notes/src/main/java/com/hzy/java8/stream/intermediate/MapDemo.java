package com.hzy.java8.stream.intermediate;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * map映射  两种操作
 * 1、接受一个 lambda ，将元素转换成其他形式或提取信息，
 * 2、接受一个函数作为参数，该函数会被应用到每一个元素上，并将其映射成一个新的元素
 */
public class MapDemo {

    List<User> users = Arrays.asList(
            new User("张三", 19, 165150.63),
            new User("李四", 29, 265150.63),
            new User("王五", 39, 365150.63),
            new User("马六", 49, 465150.63),
            new User("赵七", 59, 565150.63)
    );

    @Test
    public void testMap() {
        //操作一，通过lambda处理数据
        users.stream().map((x) -> x.getName() + "testMap").forEach(System.out::println);

        //操作二，通过函数处理数据
        users.stream().map(User::getMoney).forEach(System.out::println);
    }


    public static void main(String[] args) {
        //转成大写
        List<String> wordList = Arrays.asList("a", "b", "c");
        List<String> output = wordList.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        output.forEach(System.out::println);

        //平方数
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        squareNums.forEach(System.out::println);
    }


}
