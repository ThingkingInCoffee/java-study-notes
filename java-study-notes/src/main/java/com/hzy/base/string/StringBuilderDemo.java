package com.hzy.base.string;

public class StringBuilderDemo {

    public static void main(String[] args) {
        //Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: -1
        StringBuffer sb = new StringBuffer();
        sb.deleteCharAt(sb.lastIndexOf(":"));
    }
}
