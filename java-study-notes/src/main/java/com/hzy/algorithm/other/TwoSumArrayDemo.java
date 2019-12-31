package com.hzy.algorithm.other;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数，返回两个数组的索引，这两个索引指向的数字的加和等于指
    定的整数。需要最优的算法，分析算法的空间和时间复杂度
 */
public class TwoSumArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,23,6,7,2,73,8,9,0};
        int t = 25;
        int[] end = twoSum(arr, t);
        System.out.println(Arrays.toString(end));
    }

    public static int[] twoSum(int[] numArray, int target){
        if (numArray == null || numArray.length < 2) {
            return new int[]{0,0};
        }
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numArray.length; i++) {
            if (map.containsKey(numArray[i])) {
                return new int[]{map.get(numArray[i]),i};
            } else {
                map.put(target - numArray[i], i);
            }
        }
        return new int[]{0,0};
    }

}
