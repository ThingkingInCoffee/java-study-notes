package com.hzy.jvm.jmap;

import java.util.ArrayList;

/**
 * test
 * -Xmx60m -Xms60m -XX:SurvivorRatio=8
 */
public class GCTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            byte[] arr = new byte[1024 * 100];
            list.add(arr);
            Thread.sleep(200);
            System.out.println("第" + i + "轮");
        }
    }

}
