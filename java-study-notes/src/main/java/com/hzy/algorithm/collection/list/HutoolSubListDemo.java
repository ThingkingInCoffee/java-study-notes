package com.hzy.algorithm.collection.list;

import java.util.ArrayList;
import java.util.List;

public class HutoolSubListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 97; i++) {
            list.add(i);
        }
        int pageSize = 10;
        System.out.println("size all = " + list.size());
//        int more = list.size() % pageSize > 0 ? 1 : 0;
//        System.out.println("more = " + more);
//        int page = (list.size() / pageSize) + more;
//        System.out.println(page);
//        System.out.println("page is ===== " + page);
    }

}
