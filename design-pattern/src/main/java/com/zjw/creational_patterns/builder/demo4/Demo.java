package com.zjw.creational_patterns.builder.demo4;

/**
 * Java标准库中Builder模式的实现
 * @author jw
 * @since 2025/04/28 02:29
 */
public class Demo {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String str = builder.append("Hello")
                .append(" ")
                .append("World")
                .toString();
        System.out.println(str);
    }
}
