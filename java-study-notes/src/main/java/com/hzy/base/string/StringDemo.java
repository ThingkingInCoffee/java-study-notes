package com.hzy.base.string;

import org.junit.Test;

import java.math.BigDecimal;

public class StringDemo {

    @Test
    public void test01(){
        System.out.println("2".equals(Integer.toString(2)));
        System.out.println(new Integer(2).equals("2"));
        String countString = "1.979";
        int count = new BigDecimal(countString).intValue();
        System.out.println(count);
    }


}