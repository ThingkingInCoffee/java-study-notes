package com.hzy.algorithm.sort;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {1,5,1,4,67,8,2,234,56};
        sortDemo(arr);
    }

    public static void sortDemo (int[] arr) {
        //选择排序：选择数组中最小的数将该数移动到数组最前面，将其他元素往后移动，重复N次操作（时间复杂的（O（N2）））
        //从第一位开始对比，直到最后一位
        for (int i = 0; i < arr.length; i++) {
            int minTemp = arr[i];  //选择当前一轮作为基础比较数值
            int temp;
            for (int j = i + 1; j < arr.length; j++) {  //从基础比较数值下一位开始比较选出最小的放到基础比较位
                if (arr[j] < minTemp) {
                    temp = minTemp;
                    minTemp = arr[j];
                    arr[j] = temp;
                }
            }
            arr[i] = minTemp;
        }
        for (int a : arr){
            System.out.print(a + ",");
        }

    }

}
