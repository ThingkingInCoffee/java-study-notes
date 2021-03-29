package com.hzy.base.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("20");
        boolean b2 = list.containsAll(list2);
        System.out.println(b2);

        list.remove(0);
        System.out.println(list);
    }

}