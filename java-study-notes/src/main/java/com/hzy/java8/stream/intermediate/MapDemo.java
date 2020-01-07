package com.hzy.java8.stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {
        //转成大写
        List<String> wordList = Arrays.asList("a","b","c");
        List<String> output = wordList.stream().
                map(String::toUpperCase).
                collect(Collectors.toList());
        output.forEach(System.out::println);

        //平方数
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());
        squareNums.forEach(System.out::println);
    }


}
