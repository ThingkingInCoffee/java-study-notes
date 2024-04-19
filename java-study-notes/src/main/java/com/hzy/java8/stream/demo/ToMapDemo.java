package com.hzy.java8.stream.demo;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMapDemo {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Map<Integer, Integer> collect = integers.stream().filter(x -> x > 10).collect(Collectors.toMap(x -> x, x -> x));
        System.out.println(collect.get(1));

        long dayNumAll = DateUtil.between(DateUtil.parseDateTime("2023-11-04 00:00:00"), DateUtil.parseDateTime("2024-03-15 23:59:59"), DateUnit.DAY) + 1;
        System.out.println(dayNumAll);
        long dayNum = DateUtil.between(DateUtil.parseDateTime("2023-11-04 00:00:00"), DateUtil.parseDateTime("2023-11-15 23:59:59"), DateUnit.DAY) + 1;
        System.out.println(dayNum);

        System.out.println("001-007-005-007-205-0002".substring(12, 15));

    }


}
