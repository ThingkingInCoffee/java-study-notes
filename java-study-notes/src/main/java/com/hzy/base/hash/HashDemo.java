package com.hzy.base.hash;

public class HashDemo {

    public static void main(String[] args) {
        Object key = "123412341231";
        int i = key.hashCode();
        System.out.println(Integer.toBinaryString(i));
        int i1 = i >>> 16;
        System.out.println(Integer.toBinaryString(i1));
        int i2 = (i) ^ (i1);
        System.out.println(Integer.toBinaryString(i2));

//        11100111 00111111 11000101 11000011
//        00000000 00000000 11100111 00111111
//        11100111 00111111 00100010 11111100
    }


}
