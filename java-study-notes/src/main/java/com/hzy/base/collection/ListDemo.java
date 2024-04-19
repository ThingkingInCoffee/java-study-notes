package com.hzy.base.collection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ListDemo {

    @Test
    public void test001() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        boolean b = list.containsAll(list1);
        System.out.println(b);
        System.out.println("++++++++++++++++++++++++++++++");
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("20");
        boolean b2 = list.containsAll(list2);
        System.out.println(b2);

        list.remove(0);
        System.out.println(list);
        System.out.println("++++++++++++++++++++++++++++++");
        List<String> listCopy = list;
        listCopy.add("66666666");
        System.out.println(list);

        final String[] strings = {"1111", "22222", "33333333"};
        List<Integer> collect = Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());
        final List<String> collect1 = Arrays.stream(strings).filter(x -> collect.contains(Integer.parseInt(x))).collect(Collectors.toList());
        System.out.println(collect1);

        final String substring = "001-000-005-007-207-0001".substring(8, 11);
        System.out.println(substring);


        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

        set1.removeAll(set2);

        System.out.println(set1); // 输出：[1, 2]
    }

}