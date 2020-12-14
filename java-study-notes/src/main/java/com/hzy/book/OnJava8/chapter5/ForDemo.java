package com.hzy.book.OnJava8.chapter5;

public class ForDemo {

    public static void main(String[] args) {

        flag:
        for (int i = 0; i < 4; i++) {
            System.out.println("i = "+ i);
            for (int j = 0; j < 3; j++) {
                System.out.println("j = "+ j);
                if (j == 1) {
                    continue flag;
                }
                System.out.println("第 "+j+" 次循环结束");
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("第 "+i+" 次外循环开始");
            for (int j = 0; j < 3; j++) {
                System.out.println("第 "+j+" 次内循环开始");
                if (j == 1) {
                    System.out.println("break 跳出内循环");
                    break;
                }
                System.out.println("第 "+j+" 次内循环结束");
            }
            System.out.println("第 "+i+" 次外循环结束");
        }

        System.out.println("+++++++++++++++++++++++++++++");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    return;
                }
                System.out.println("第 "+j+" 次内循环结束");
            }
            System.out.println("第 "+i+" 次外循环结束");
        }

    }


}
