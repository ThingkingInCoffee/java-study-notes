package com.hzy.algorithm.recursion;

/**
 * 八皇后问题
 */
public class Queue8 {

    private static final int[] arr = new int[8];

    public static void main(String[] args) {
        addQueue(0);
    }

    /**
     * 遍历指定行的每一列尝试放置皇后位置
     * 递归到最后一行之后会回溯到次底行遍历，直到回溯完到第一行
     * 再从第一行下一列开始递归，然后回溯，知道第一行最后一列递归完
     * @param nRowQueue 开始放入的行号
     */
    public static void addQueue(int nRowQueue) {
        // 判断最后一行
        if (nRowQueue >= 8) {
            System.out.println("已经是最后一个");
            printQueue(arr);
            return;
        }
        // 小于最后一列，遍历
        for (int colNo = 0; colNo < 8; colNo++) {
            // 将第 n 个皇后放入对应行的第 col 个位置
            arr[nRowQueue] = colNo;
            // 放入后，检查冲突
            if (!checkConflict(nRowQueue)) {
                // 不冲突则继续下一行的处理
                addQueue(nRowQueue + 1);
            }
        }
    }


    /**
     * 检测当前行放入的列位置是否出现冲突
     *
     * @param currentRowNum 传入当前行行号
     * @return true 冲突 false 不冲突
     */
    public static boolean checkConflict(int currentRowNum) {
        // i 代表前面的行号
        for (int i = 0; i < currentRowNum; i++) {
            // 如果 当前行的列 与 之前的任意行的 列数相同则为冲突
            // 或者 行数差 等于 列数差，则为对角线冲突
            if (arr[currentRowNum] == arr[i]
                    || Math.abs(currentRowNum - i) == Math.abs(arr[currentRowNum] - arr[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 打印·
     *
     * @param map 打印的数组
     */
    public static void printQueue(int[] map) {
        for (int anInt : map) {
            System.out.print(anInt + "  ");
        }
        System.out.println();

    }
}
