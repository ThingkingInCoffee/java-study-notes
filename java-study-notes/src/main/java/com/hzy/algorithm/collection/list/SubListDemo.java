package com.hzy.algorithm.collection.list;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 97; i++) {
            list.add(i);
        }
        int pageSize = 10;
        System.out.println(list.size());
        int more = list.size() % pageSize > 0 ? 1 : 0;
        System.out.println("more = " + more);
        int page = (list.size() / pageSize) + more;
        System.out.println(page);
        System.out.println("page is ===== " + page);
        for (int i = 0; i < page; i++) {
            int start = pageSize * i;
            int add = more > 0 && i == page - 1 ? list.size() % pageSize : pageSize;
            List<Integer> subList = list.subList(start, start + add);
            for (Integer integer : subList) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
}
