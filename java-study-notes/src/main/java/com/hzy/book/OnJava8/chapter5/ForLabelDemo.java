package com.hzy.book.OnJava8.chapter5;

public class ForLabelDemo {

    public static void main(String[] args) {
        test001();
        System.out.println("=================================");
        test002();
        System.out.println("=================================");
        test003();
    }

    public static void test001(){
        Label01:
        for (int i = 0; i < 10; i++) {
            System.out.println("x = " + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("y = " + j);
                if (j == 2) {
                    continue;
                }
                if (j == 8) {
                    break;
                }
                System.out.println("y = " + j + "last");
            }
            System.out.println("x = " + i + "last");
        }
        System.out.println("结束==");
    }

    /**
     * 每次内层循环到 2 就跳出整个循环到 label
     * 然后重新开始外循环，外循环 +1 开始
     */
    public static void test002(){
        Label02:
        for (int i = 0; i < 10; i++) {
            System.out.println("x = " + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("y = " + j);
                if (j == 2) {
                    continue Label02;
                }
                System.out.println("y = " + j + "last");
            }
            System.out.println("x = " + i + "last");
        }
        System.out.println("结束==");
    }

    /**
     *  外层第一次循环
     *  内层第一次循环到 2 即 整个结束
     */
    public static void test003(){
        Label03:
        for (int i = 0; i < 10; i++) {
            System.out.println("x = " + i);
            for (int j = 0; j < 10; j++) {
                System.out.println("y = " + j);
                if (j == 2) {
                    break Label03;
                }
                System.out.println("y = " + j + "last");
            }
            System.out.println("x = " + i + "last");
        }
        System.out.println("结束==");
    }

}
