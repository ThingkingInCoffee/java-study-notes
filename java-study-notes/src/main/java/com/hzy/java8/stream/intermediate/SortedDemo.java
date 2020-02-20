package com.hzy.java8.stream.intermediate;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;
import sun.text.normalizer.UTF16;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *  排序
 *  sorted()  --  自然排序（comparable）
 *  sorted(Comparator)  --  定制排序
 */
public class SortedDemo {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    List<User> users = Arrays.asList(
            new User("张三", 19, 165150.63),
            new User("李四", 29, 265150.63),
            new User("王五", 39, 365150.63),
            new User("马六", 49, 465150.63),
            new User("赵七", 59, 565150.63)
    );

    List<String> strings = Arrays.asList(
            "aaa","ddd","eee","bbb","ccc","fff"
    );

    List<String> dates = Arrays.asList(

            "2020-01-01", "2020-02-01", "2020-03-01", "2020-04-01", "2020-05-01", "2020-05-01"
    );

    @Test
    public void testSorted () {

        //自然排序
        strings.stream().sorted().forEach(System.out::println);
        System.out.println("=========================");
        //定制排序
        users.stream().sorted((user1,user2)->{
            if (user1.getAge().equals(user2.getAge())) {
                return user1.getName().compareTo(user2.getName());
            } else {
                return -user1.getAge().compareTo(user2.getAge());
            }
        }).forEach(System.out::println);
    }

    @Test
    public void testDate() throws InterruptedException {
        Date date01 = new Date();
        Thread.sleep(2000);
        Date date02 = new Date();
        List<Date> list = new ArrayList<>();
        list.add(date01);
        list.add(date02);
        list.stream().sorted().forEach(x -> {
            String s = sdf.format(x);
            System.out.println(s);
        });

    }

}
