package com.hzy.base.integer;

public class IntegerDemo {

    public static void main(String[] args) {
        Integer a = 1000;
        Integer b = 1;
        Integer aa = new Integer(1000);
        Integer bb = new Integer(1);
        System.out.println(a == aa);
        System.out.println(b == bb);
        Integer bb2 = new Integer(1);
        System.out.println(bb == bb2);
        Integer bb3 = 1;
        System.out.println(b == bb3);
        Integer aa2 = 1000;
        System.out.println(a == aa2);
    }


}
