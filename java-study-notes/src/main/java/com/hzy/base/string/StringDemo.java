package com.hzy.base.string;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StringDemo {

    @Test
    public void test01() {
        System.out.println(new Integer(1024) == 1024);
        System.out.println("2".equals(Integer.toString(2)));
        System.out.println(new Integer(2).equals("2"));
        String countString = "1.979";
        int count = new BigDecimal(countString).intValue();
        System.out.println(count);
        Integer n = new Integer(133);
        System.out.println("133".equals(n));
        System.out.println(n.equals(133));
        System.out.println(n == 133);
        Integer m = new Integer(133);
        System.out.println(m.equals(n));
        String numString = "1";
        System.out.println(numString.equals(1));

        // Integer nullInteger = null;
        // System.out.println(99 != nullInteger);  // 空指针异常
    }

    @Test
    public void test02() {
        List<Integer> list = new ArrayList<Integer>();
        Integer a = null;
        list.add(a);
        System.out.println(list.size());
        for (Integer integerNum : list) {
            System.out.println("142341234:" + integerNum + ":test");
        }
    }


}
