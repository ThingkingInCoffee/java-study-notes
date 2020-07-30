package com.hzy.book.OnJava8.chapter4;

// 逻辑运算符的短路行为
public class ShortCircuit {

    static boolean test1(int val) {
        System.out.println("test1(" + val + ")");
        System.out.println("result: " + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        System.out.println("test2(" + val + ")");
        System.out.println("result: " + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        System.out.println("test3(" + val + ")");
        System.out.println("result: " + (val < 3));
        return val < 3;
    }

    public static void main(String[] args) {
        boolean b = test1(0) && test2(2) && test3(2);
        System.out.println("expression is " + b);
//        结果
//        test1(0)
//        result: true
//        test2(2)
//        result: false
//        expression is false
//        方法三不执行，因为短路处理
    }
}