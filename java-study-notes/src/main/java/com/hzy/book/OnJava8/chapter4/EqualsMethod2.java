package com.hzy.book.OnJava8.chapter4;

/**
 * 结果是 false。原因： equals() 的默认行为是比较对象的引用而非具体内容。
 * 可以重写 Value 中的 equals 方法，比较内容，不比较对象的印用
 */
public class EqualsMethod2 {
    public static void main(String[] args) {
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        System.out.println(v1.equals(v2));
    }

    // 默认的 equals() 方法没有比较内容
    static class Value {
        int i;
    }
}