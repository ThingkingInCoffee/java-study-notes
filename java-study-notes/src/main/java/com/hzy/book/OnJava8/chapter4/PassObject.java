package com.hzy.book.OnJava8.chapter4;

public class PassObject {
    static void f(Letter y) {
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        f(x);
        System.out.println("2: x.c: " + x.c);
    }

    // 正在传递的对象可能不是你之前使用的
    static class Letter {
        char c;
    }
}