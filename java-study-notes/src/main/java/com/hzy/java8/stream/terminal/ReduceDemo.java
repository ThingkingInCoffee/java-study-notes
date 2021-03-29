package com.hzy.java8.stream.terminal;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 归约
 * 将流中的元素依次反复的处理后，得到一个结果
 */
public class ReduceDemo {
    List<Integer> list =
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<BigDecimal> list2 =
            Arrays.asList(new BigDecimal("0"), new BigDecimal("1")
                    , new BigDecimal("2"), new BigDecimal("3")
                    , new BigDecimal("4"), new BigDecimal("5"), null);

    @Test
    public void test01() {
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
//        BigDecimal reduce2 = list2.stream().reduce(new BigDecimal("0"), BigDecimal::add);
//        System.out.println(reduce2);
        BigDecimal orderAmountSum = list2.stream().reduce(new BigDecimal("0"), (x, y) -> y == null ? x : x.add(y));
        System.out.println(orderAmountSum);
    }

}
