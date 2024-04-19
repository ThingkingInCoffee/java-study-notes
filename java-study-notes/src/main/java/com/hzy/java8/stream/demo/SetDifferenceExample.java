package com.hzy.java8.stream.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SetDifferenceExample {
    public static void main(String[] args) {
        // 创建Set A并添加元素
        Set<Integer> setA = new HashSet<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);

        // 创建Set B并添加元素
        Set<Integer> setB = new HashSet<>();
        setB.add(2);
        setB.add(3);
        setB.add(4);

        // 计算差集
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);

        // 输出差集
        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        System.out.println("Difference (Set A - Set B): " + difference);
        Set<Integer> collect = difference.stream().filter(e -> e == 9).collect(Collectors.toSet());
        System.out.println(collect.toArray(new Integer[0]).length);;
    }
}