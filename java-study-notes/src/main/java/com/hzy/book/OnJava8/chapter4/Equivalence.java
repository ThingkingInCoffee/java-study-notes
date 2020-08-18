package com.hzy.book.OnJava8.chapter4;

/**
 * 因为 Integer 内部维护着一个 IntegerCache 的缓存，默认缓存范围是 [-128, 127]，
 * 所以 [-128, 127] 之间的值用 == 和 != 比较也能能到正确的结果，
 * 但是不推荐用关系运算符比较，具体见 JDK 中的 Integer 类源码
 */
public class Equivalence {
    public static void main(String[] args) {
        Integer n1 = 47;
        Integer n2 = 47;
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);

        Integer n3 = 147;
        Integer n4 = 147;
        System.out.println(n3 == n4);
        System.out.println(n3.equals(n4));
    }
}