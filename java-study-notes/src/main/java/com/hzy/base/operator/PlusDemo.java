package com.hzy.base.operator;

public class PlusDemo {

    public static void main(String[] args) {
        int i = 0;
        System.out.println(i++);
        int j = 0;
        System.out.println(++j);
        int m = 1;
        System.out.println(m--);
        int n = 1;
        System.out.println(--n);
        int index = 0;
        String s = "testString";
        while (index <= s.length() - 1) {
            String subString = s.substring(index++, index);
            System.out.println(subString);
        }

    }

}
