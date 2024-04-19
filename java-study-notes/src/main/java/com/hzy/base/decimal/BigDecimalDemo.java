package com.hzy.base.decimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal("0.3666");
        BigDecimal d2 = new BigDecimal("12.89");
        BigDecimal result1 = d1.multiply(d2);
        System.out.println(result1.toString());
        int compare1 = result1.compareTo(new BigDecimal("4.72"));
        System.out.println(compare1); // 4.725474 > 4.72  --> 1
        BigDecimal b12 = new BigDecimal(12);
        BigDecimal b10 = new BigDecimal("10");
        System.out.println(b10.multiply(b12));

        final BigDecimal divide = new BigDecimal("1").add(new BigDecimal("2"))
                .divide(new BigDecimal("2"), 2, BigDecimal.ROUND_UP);
        System.out.println(divide.toString());

        System.out.println("001-002-003-004".substring(8, 11));
        List<Map<String, Object>> historyData = new ArrayList<>();
        final long count = historyData.stream().filter(f -> {
            BigDecimal m03qc = f.get("m_003qc") == null ? new BigDecimal(0) : (BigDecimal) f.get("m_003qc");
            return m03qc.compareTo(BigDecimal.ONE) > 0;
        }).count();
        System.out.println("count:" + count);

        final List<String> strings = Arrays.asList("1", "3", "2");
        final List<String> collect = strings.stream().filter(x -> "5".equals(x)).collect(Collectors.toList());
        final boolean empty = collect.isEmpty();
        System.out.println(empty);


        BigDecimal base = BigDecimal.ZERO;

        BigDecimal copy = base;

        base = new BigDecimal("666");

        System.out.println(copy + "-" + base);

        base = new BigDecimal("888");

        System.out.println(copy + "-" + base);

        base = new BigDecimal("-888");

        System.out.println(copy + "-" + base);

        final List<String> stringList = Arrays.asList("1.123", "3.1230", "2.78945621");
        stringList.stream().map(e->new BigDecimal(e).setScale(4));

    }

}
