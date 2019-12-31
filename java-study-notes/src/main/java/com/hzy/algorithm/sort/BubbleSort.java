package com.hzy.algorithm.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,5,1,4,67,8,2,234,56};
        int[] arr2 = {1,5,1,4,67,8,2,234,56};
        sortDemo(arr);
        System.out.println();
        sortDemo2(arr2);
    }

    public static void sortDemo (int[] arr) {
        int temp;
        int size = arr.length;
        // 外层记录排序的次数，跟排序数值无关，n 位数需要排 n-1 次，因为剩下一个数就不用排了
        for (int i = 1; i <= size; i++) {    //此处 等号有无均可
            for(int j = 1; j <= size - i; j++) {        // j 是下标  第一次要 从最开始两位 两两比较到 size-1 即最后一位；第二次到 size-2
                if (arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int a : arr){
            System.out.print(a + ",");
        }
    }

    public static void sortDemo2(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int a : arr){
            System.out.print(a + ",");
        }
    }


}
