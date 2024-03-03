package com.zjw.regex;

public class StringRegex {
    public static void main(String[] args) {
        //保留所有的小写字母
        String str1 = "asfa6wr4e463r@#4r!";
        String regex1 = "[^a-z]";
        System.out.println(str1.replaceAll(regex1, ""));

        //按照数字拆分字符串
        String regex2 = "\\d+";
        String[] result = str1.split(regex2);
        for (String str : result) {
            System.out.println(str);
        }

        //判断一个数是否是整数或小数，如果是整数变为小数
        String str3 = "10";
        String regex3 = "\\d+(\\.\\d+)?";
        System.out.println(str3.matches(regex3));
        if (str3.matches(regex3)) {
            System.out.println(Double.parseDouble(str3));
        }

        //判断ip
//		String str4 = "192.168.1.1" ;
//		String regex = "";
//		System.out.println();

        //判断邮箱

    }
}
