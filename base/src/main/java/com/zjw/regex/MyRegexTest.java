package com.zjw.regex;

public class MyRegexTest {
    public static void main(String[] args) {
        //字符集（数量1）
        String str1 = "1";
        System.out.println("字符集表达式--------------");
        System.out.println(str1.matches("c"));//匹配字符'c'
        System.out.println(str1.matches("[abc]"));//匹配任意一个
        System.out.println(str1.matches("[^abc]"));//不匹配任意一个
        System.out.println(str1.matches("[a-zA-Z]"));//是否是字母
        System.out.println(str1.matches("[0-9]"));//是否是数字
        System.out.println("简化的字符集表达式--------------");
        //简化的字符集表达式
        System.out.println(str1.matches("."));//匹配任意一位字符
        System.out.println(str1.matches("\\d"));//是否是数字,等价与[0-9]
        System.out.println(str1.matches("\\D"));//是否不是数字,等价与[^0-9]
        System.out.println(str1.matches("\\s"));//任意空白字符，如\n \t
        System.out.println(str1.matches("\\S"));//非空白字符
        System.out.println(str1.matches("\\w"));//等价[a-zA-Z_0-9],由字母数字下滑线组成
        System.out.println(str1.matches("\\W"));//等价[^a-zA-Z_0-9],不是由字母数字下滑线组成
        //边界匹配
        /**
         * 不要在Java中使用，在 JavaScript里使用
         */
        System.out.println("边界匹配------------");
        //数量表达
        /**
         * ?:出现0次或1次
         * +:1次或多次
         * *:0、1、或多次
         * {n}:正好出现n次
         * {n,}:出现n次或n次以上
         * {n,m}:出现n~m次
         *
         *
         */
        /**
         * 逻辑运算
         * 正则1正则2：正则1判断后继续判断正则2
         * 正则1|正则2：有一组满足即可
         * （正则）：将多个正则作为一组，可以为这一组单独设置出现的次数
         */

    }
}
