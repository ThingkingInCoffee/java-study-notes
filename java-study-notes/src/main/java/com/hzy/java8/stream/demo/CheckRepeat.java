package com.hzy.java8.stream.demo;

import com.hzy.java8.functionalinterface.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckRepeat {

    List<User> users = Arrays.asList(
            new User("张三", 19, 165150.63),
            new User("李四", 19, 265150.63),
            new User("王五", 39, 365150.63),
            new User("马六", 39, 465150.63),
            new User("赵七", 59, 565150.63)
    );

    @Test
    public void test() {
        List<Integer> collect = users.stream() //
                .map(e -> { // 获取deptCode或deptAlias的Stream
                    return e.getAge();
                }).collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream() // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() == 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());// 转化为 List
        for (Integer integer : collect) {
            System.out.println(integer);
        }
    }

    @Test
    public void test01(){
        users.stream().forEach(x-> {
            if (x.getAge() == 39) {
                return;
            }
        });
    }


}
