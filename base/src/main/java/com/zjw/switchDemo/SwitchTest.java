package com.zjw.switchDemo;

import java.util.Scanner;

/**
 * switch练习
 * 输入一个年份 月份，输出当前月份的天数
 * 2017-12-24
 *
 * @author Junwei Zhu
 */
public class SwitchTest {
    public static void main(String[] args) {
        //switch支整型、字符型、字符串型
        int year;
        int month;
        int day = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("请输入年份：");
        year = input.nextInt();
        System.out.println("请输入月份：");
        month = input.nextInt();

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = 30;
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                    day = 29;
                else
                    day = 28;
                break;
            default:
                break;
        }
        System.out.println(year + "年" + month + "月共" + day + "天。");
    }
}
