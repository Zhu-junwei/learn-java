package com.zjw.enumDemo;

/**
 * @author 朱俊伟
 * @date 2022/01/06
 */
public class EnumDemo {
    public static void main(String[] args) {
        ColorEnum red = ColorEnum.RED;
        System.out.println(red.name());
        System.out.println(red.toString());
//        System.out.println(red.name());
    }
}
