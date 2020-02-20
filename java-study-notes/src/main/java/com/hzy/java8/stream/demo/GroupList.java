package com.hzy.java8.stream.demo;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupList {

    List<User> users = Arrays.asList(
            new User("张三", 19, 165150.63),
            new User("李四", 19, 265150.63),
            new User("王五", 39, 365150.63),
            new User("马六", 39, 465150.63),
            new User("赵七", 59, 565150.63)
    );

    @Test
    public void test(){
        Map<Integer, List<User>> userList = this.users.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println(userList);
    }



}
