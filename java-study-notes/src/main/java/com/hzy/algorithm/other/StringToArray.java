package com.hzy.algorithm.other;

public class StringToArray {

    public static void main(String[] args) {
        String[] splitArray = ",qwer ,qwerq, qwerq re ，qweqeqwr,e r".replace(" ","").split(",|，");
        System.out.println(splitArray.length);
        for (String s : splitArray) {
            System.out.println("====="+s+"=====");
        }

        System.out.println(1<<30);
        System.out.println(1<<4);
    }

}
