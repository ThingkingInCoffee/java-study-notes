package com.hzy.java8.stream.terminal;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 归约
 * 将流中的元素依次反复的处理后，得到一个结果
 */
public class ReduceDemo {
    List<Integer> list =
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    public void test01(){
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
    }

}
