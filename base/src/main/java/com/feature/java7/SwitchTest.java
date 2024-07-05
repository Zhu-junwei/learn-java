package com.feature.java7;

/**
 * switch语句, java7新增字符串匹配
 *
 * @author 朱俊伟
 * @date 2024/07/03
 */
@SuppressWarnings("all")
public class SwitchTest {
    public static void main(String[] args) {
        String color = "red";
        // 新方式：在 switch 中使用字符串
        switch(color) {
            case "red":
                System.out.println("RED");
                break;
            case "green":
                System.out.println("GREEN");
                break;
            case "blue":
                System.out.println("BLUE");
                break;
            case "yellow":
                System.out.println("YELLOW");
                break;
            default:
                System.out.println("Unknown");
                break;
        }
    }
}
