package com.hzy.algorithm.leetcode;

/**
 * https://leetcode-cn.com/interview/1/
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 */
public class IsLongPressedName {

    public static void main(String[] args) {
        isLongPressedName("leelee","lleeelee");
    }
    public static boolean isLongPressedName(String name, String typed) {
        String first = name.charAt(0)+"";
        if (name.length() < 1 || typed.length() < 1 || !first.equals( typed.charAt(0)+"" ) ) {
            System.out.println("first false");
            return false;
        }
        String left = "";
        String right = "";
        for (int i = 0; i < name.length() - 1; i++) {
            int n = 1;
            left = name.charAt(i)+"";
            right = name.charAt(i+n)+"";
            while (left.equals(right) && i+n < name.length() - 1) {
                left = left + right;
                n++;
                right = name.charAt(i+n)+"";
            }
            if (!typed.startsWith(left)) {
                System.out.println("second false");
                return false;
            } else {
                while (typed.startsWith(left.charAt(0)+"") && typed.length() > 1) {
                    typed = typed.substring(1,typed.length());
                }
                i = i+n-1;
            }
        }
        System.out.println("true1");
        if ( !typed.startsWith(right) ) {
            System.out.println("third false");
            return false;
        }
        System.out.println("true2");
        return true;
    }

}
