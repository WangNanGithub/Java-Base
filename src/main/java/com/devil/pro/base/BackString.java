package com.devil.pro.base;

/**
 * 逆转字符串——输入一个字符串，将其逆转并输出。
 */
public class BackString {
    
    public static void main(String[] args) {
        String str = "987654321";
        char[] cs = str.toCharArray();
        for (int i = cs.length - 1; i > -1; i--) {
            System.out.print(cs[i]);
        }
    }
    
}
