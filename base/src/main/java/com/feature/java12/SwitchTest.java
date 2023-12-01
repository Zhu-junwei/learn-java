package com.feature.java12;

/**
 * switch语句
 * @author 朱俊伟
 * @since 2023/12/01 16:40
 */
public class SwitchTest {
    public static void main(String[] args) {

        // java12中引入了这种语法
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
