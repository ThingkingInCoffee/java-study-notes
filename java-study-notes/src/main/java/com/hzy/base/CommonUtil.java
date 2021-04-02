package com.hzy.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonUtil {

    public static String[] stringArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static void main(String[] args) {
        System.out.println((char) (new Random().nextInt(56) + 65));
    }

    public static List<String> getStringRandomDemoList(){
        return getStringRandomDemoList(10);
    }

    public static List<String> getStringRandomDemoList(int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(stringArray[i % 26]);
        }
        return list;
    }

}
