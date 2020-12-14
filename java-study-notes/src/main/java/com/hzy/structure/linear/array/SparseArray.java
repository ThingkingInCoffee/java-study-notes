package com.hzy.structure.linear.array;

import java.io.*;

/**
 * 稀疏数组
 * 稀疏数组把原数组中具有的不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
 * 稀疏数组也是二维数组，行数由原数组的数据决定，列数一般为 3 列
 * 稀疏数组的第一行记录原数组一共有几行几列，有多少个不为零的值
 * 第一列：原数组的行数
 * 第二列：原数组的列数
 * 第三列：原数组有多少个不为零的值
 * 之后的行记录原数组中不为 0 (或其他默认值)的值(x)所在的行数、列数以及 x 的值
 * 第一列：x 在原数组中的行数
 * 第二列：x 在原数组中的列数
 * 第三列：x 的值
 */
public class SparseArray {

    public static int[][] getArray() {
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        return chessArray;
    }

    public static void main(String[] args) {
        int[][] array = getArray();
        createFile(array);
        System.out.println("获取的原始数组为");
        printArray(array);
        // 生成稀疏数组
        int[][] sparseArray = createSparseArray(array);
        System.out.println("获取的稀疏数组为");
        printArray(sparseArray);
        // 解析稀疏数组
        int[][] originArray = parseSparseArray(sparseArray);
        System.out.println("获取的原始数组为");
        printArray(originArray);
        // 解析文件
        parseFile();

    }

    /**
     * 生成稀疏数组
     *
     * @param sourceArray
     * @return
     */
    public static int[][] createSparseArray(int[][] sourceArray) {
        // 获取原二维数组中非零值得个数
        int sum = 0;
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray[i].length; j++) {
                if (sourceArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 创建稀疏数组 行数+1 首行存汇总
        int[][] sparseArrays = new int[sum + 1][3];
        // 给稀疏数组赋值首行汇总值
        sparseArrays[0][0] = sourceArray.length;
        sparseArrays[0][1] = sourceArray[0].length;
        sparseArrays[0][2] = sum;

        // 填充剩余数据行 从 第二行开始 行标 1
        int count = 1;
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray[i].length; j++) {
                if (sourceArray[i][j] != 0) {
                    sparseArrays[count][0] = i;
                    sparseArrays[count][1] = j;
                    sparseArrays[count][2] = sourceArray[i][j];
                    count++;
                }
            }
        }
        return sparseArrays;
    }


    /**
     * 解析稀疏数组
     *
     * @param sparseArray
     * @return
     */
    public static int[][] parseSparseArray(int[][] sparseArray) {
        int[][] originArray = null;
        for (int i = 0; i < sparseArray.length; i++) {
            int row = sparseArray[i][0];
            int col = sparseArray[i][1];
            int value = sparseArray[i][2];
            // 首行用于创建
            if (originArray == null) {
                originArray = new int[row][col];
            } else {
                // 次行开始赋值
                originArray[row][col] = value;
            }
        }
        return originArray;
    }


    /**
     * 打印数组
     *
     * @param chessArray
     */
    public static void printArray(int[][] chessArray) {
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    public static void createFile(int[][] arrayData) {
        File file = new File("F:\\map.data");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            for (int[] row : arrayData) {
                for (int data : row) {
                    outputStream.write(Integer.toString(data).getBytes());
                }
                outputStream.write("\r\n".getBytes());
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseFile() {
        File file = new File("F:\\map.data");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                System.out.println(s);
                stringBuilder.append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
