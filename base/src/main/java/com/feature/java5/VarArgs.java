package com.feature.java5;

/**
 * 可变参数：它允许你传递零个或多个参数给一个方法
 */
public class VarArgs {
    public static void main(String[] args) {
        ppp("hello", "java");
        ppp("nihao");
        ppp("1", "2", "3");
    }

    public static void ppp(String... str) {
        for (String st : str) {
            System.out.println(st);
        }
    }
}
