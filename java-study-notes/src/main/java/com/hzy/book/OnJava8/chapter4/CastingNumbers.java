package com.hzy.book.OnJava8.chapter4;

/**
 * 尝试转换 float 和 double 型数据为整型数据
 * 从 float 和 double 转换为整数值时，小数位将被截断
 * 若你想对结果进行四舍五入，可以使用 java.lang.Math 的 round() 方法
 */
public class CastingNumbers {
    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;
        System.out.println("(int)above: " + (int) above);
        System.out.println("(int)below: " + (int) below);
        System.out.println("(int)fabove: " + (int) fabove);
        System.out.println("(int)fbelow: " + (int) fbelow);
//        结果
//        (int)above: 0
//        (int)below: 0
//        (int)fabove: 0
//        (int)fbelow: 0
    }
}