package com.hzy.base.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 走过的坑，list定义泛型是A类，塞入对象是A的子类，remove时，因为子类的equals没有重写， 仅仅判断了子类的两个字段相等就匹配移除了，
 * 导致出现非预期情况
 *
 * @author hzy
 * @description: ArrayListRemoveDemo.java
 * @date 2022/6/10 19:02
 */
public class ArrayListRemoveDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("A", "B");
        List<User> users = new ArrayList<>();
        User a = new User(1, "A");
        User b = new User(2, "B");
        users.add(a);
        users.add(b);
        for (String name : names) {
            List<User> userFilter = users.stream().filter(u -> name.equals(u.getName())).collect(Collectors.toList());
            if (userFilter == null || userFilter.size() < 1) {
                System.out.println("空的");
                break;
            }
            User c = userFilter.get(0);
            System.out.println("getUser=======" + c);
            users.remove(c);
        }


    }


    static class User {
        Integer id;
        String name;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
