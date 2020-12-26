package com.hzy.book.OnJava8.chapter6;

/**
 *  构造方法中，只能调用其他构造方法一次
 *  非构造方法中，不能通过 this 调用构造方法
 *  static 方法中不会存在 this
 */
public class FlowerConstructor {
    int petalCount = 0;
    String s = "initial value";

    FlowerConstructor(int petals) {
        petalCount = petals;
        System.out.println("Constructor w/ int arg only, petalCount = " + petalCount);
    }

    FlowerConstructor(String ss) {
        System.out.println("Constructor w/ string arg only, s = " + ss);
        s = ss;
    }

    FlowerConstructor(String s, int petals) {
        // 构造方法中，只能调用其他构造方法一次
        this(petals);
        //- this(s); // Can't call two!
        this.s = s; // Another use of "this"
        System.out.println("string & int args");
    }

    FlowerConstructor() {
        this("hi", 47);
        System.out.println("no-arg constructor");
    }

    void printPetalCount() {
        // 非构造方法中，不能通过 this 调用构造方法
        //- this(11); // Not inside constructor!
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        FlowerConstructor x = new FlowerConstructor();
        x.printPetalCount();
    }
}