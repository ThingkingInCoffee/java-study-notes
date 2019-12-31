package com.hzy.algorithm.sort;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {1,5,1,4,67,8,2,234,56};
        sortDemo(arr, 0, arr.length - 1);
        for (int a : arr){
            System.out.print(a + ",");
        }
    }

    public static void sortDemo (int[] arr, int l, int r) {
        //递归调用 左右相等时退出
        if (l < r) {
            int i = l, j = r, x = arr[i]; //设置初始基准数 x
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] <= x) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = x;
            sortDemo(arr, l, i-1);
            sortDemo(arr, i+1, r);
        }
    }

}
