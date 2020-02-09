package com.hzy.java8.stream.intermediate;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 接受一个函数作为参数，将流中的每个值都转换为另一个流，然后把每一个流连接在一起产生新的流
 */
public class FlatMapDemo {

    List<User> users = Arrays.asList(
            new User("张三", 19, 165150.63),
            new User("李四", 29, 265150.63),
            new User("王五", 39, 365150.63),
            new User("马六", 49, 465150.63),
            new User("赵七", 59, 565150.63)
    );

    @Test
    public void testFlatMap() {
        Stream<Character> rStream = users.stream().flatMap(user -> {
            return FlatMapDemo.getStringCharacter(user.getName());
        });
        rStream.forEach(System.out::println);
        System.out.println("======================");
        Stream<Character> rStreams = users.stream().flatMap(
                FlatMapDemo::getStringCharacter
        );
        rStreams.forEach(System.out::println);
    }

    /** 二者区别类似于 list 中 add 和 addAll 的区别
     *  list1.add(list2)  会出现list1中套list2
     *  list1.addAll(list2)  则是list2中元素依次插入list1
     */
    @Test
    public void testFlatMapDiffMap() {
        Stream<Stream<Character>> rStream = users.stream().map(FlatMapDemo::getStringCharacter
        );
        rStream.forEach((sm) -> sm.forEach(System.out::println));
        System.out.println("======================");
        Stream<Character> rStreams = users.stream().flatMap(
                FlatMapDemo::getStringCharacter
        );
        rStreams.forEach(System.out::println);
    }


    public static Stream<Character> getStringCharacter(String s) {
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    public static Stream<Character> getStringCharacter(User user) {
        List<Character> list = new ArrayList<>();
        for (char c : user.getName().toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

}
