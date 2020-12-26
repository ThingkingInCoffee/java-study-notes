package com.hzy.base.exception;

public class Demo {
    public static void main(String[] args) throws Exception {
        try {
            double d = 1/0;
            System.out.println("after ex =============");
        } catch (NullPointerException e){
            System.out.println("catch=============");
            throw new Exception();
        }finally {
            System.out.println("finally=============");
        }
    }
}
