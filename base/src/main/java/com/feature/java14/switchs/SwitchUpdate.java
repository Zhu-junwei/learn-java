package com.feature.java14.switchs;

/**
 * switch语句
 * <p>
 * Java 12 (2019): 作为预览功能引入了 switch 表达式，支持：
 * <p>
 *  - 直接从 switch 块中返回值。
 * <p>
 *  - 为单个 case 标签使用多个值。
 * <p>
 * Java 14 (2020): Switch 表达式成为标准语言功能，使用 -> 语法返回值。
 *
 * @author 朱俊伟
 * @since 2024/03/24 15:06
 */
public class SwitchUpdate {
    public static void main(String[] args) {

        int number = 2;
        String day = switch (number) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3, 4, 5 -> "Midweek";
            default -> "Weekend";
        };
        System.out.println(day);
    }
}
