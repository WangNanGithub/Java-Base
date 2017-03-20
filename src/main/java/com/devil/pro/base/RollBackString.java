package com.devil.pro.base;

/**
 * 判断是否为回文——判断用户输入的字符串是否为回文。回文是指正反拼写形式都是一样的词，譬如“racecar”。
 */
public class RollBackString {
    
    public static void main(String[] args) {
        String str = "racecar";
        char[] chs = str.toCharArray();
        StringBuffer roll = new StringBuffer();
        for (int i = chs.length - 1; i > -1; i--) {
            roll.append(chs[i]);
        }
        System.out.println(roll.toString().equals(str));
    }
}
