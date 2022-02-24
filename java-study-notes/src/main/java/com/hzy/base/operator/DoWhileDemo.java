package com.hzy.base.operator;

/**
 * @author hzy
 * @description: DoWhileDemo.java
 * @date 2021/12/28 11:50
 */
public class DoWhileDemo {

    public static void main(String[] args) {

        double x = 0.0;
        double y = 0.0;

        System.out.println(Math.random());

        System.out.println(Math.sqrt(1));

        int total = 0;
        for (int i = 0; i < 7000000; i++) {
            x = Math.random();
            y = Math.random();
            if (Math.sqrt(x * x + y * y) < 1) {
                total++;
            }
        }
        System.out.println(total);
        System.out.println(total / 7000000.0);

//        int i = 0;
//        do {
//            i++;
//            System.out.println("do " + i);
//            if (i > 10) {
//                System.out.println("return");
//                return;
//            }
//            if (i >= 5) {
//                continue;
//            }
//            System.out.println("test continue");
//
//        } while (i < 100);
    }

}
