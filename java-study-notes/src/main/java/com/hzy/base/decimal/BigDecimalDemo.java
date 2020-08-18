package com.hzy.base.decimal;

import java.math.BigDecimal;

public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal("0.3666");
        BigDecimal d2 = new BigDecimal("12.89");
        BigDecimal result1 = d1.multiply(d2);
        System.out.println(result1.toString());
        int compare1 = result1.compareTo(new BigDecimal("4.72"));
        System.out.println(compare1); // 4.725474 > 4.72  --> 1
    }

}
