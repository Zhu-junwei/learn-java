package com.zjw;

import java.util.Arrays;
import java.util.Random;

/**
 * 双色球小游戏
 */
public class DoubleColorBall {

    public static void main(String[] args) {
        generateBalls(10);
    }

    /**
     * 生成多个双色球
     * @param num 生成球的数量
     */
    public static void generateBalls(int num) {
        for (int i = 0; i < num; i++) {
            int[] redBalls = generateRedBalls();
            int blueBall = generateBlueBall();
            printBallNumbers(redBalls, blueBall);
        }
    }

    /**
     * 生成红球
     */
    private static int[] generateRedBalls() {
        int[] balls = new int[6];
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int num;
            do {
                num = random.nextInt(33) + 1;
            } while (contains(balls, num)); // 红球不能重复
            balls[i] = num;
        }
        Arrays.sort(balls); // 红球按从小到大排序
        return balls;
    }

    /**
     * 生成蓝球
     */
    private static int generateBlueBall() {
        Random random = new Random();
        return random.nextInt(16) + 1;
    }

    /**
     * 判断数组中是否包含指定元素
     */
    private static boolean contains(int[] arr, int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    /**
     * 打印双色球号码
     */
    private static void printBallNumbers(int[] redBalls, int blueBall) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(String.format("%02d", redBalls[i])).append(" ");
        }
        sb.append("- ").append(String.format("%02d", blueBall));
        System.out.println(sb.toString());
    }

    /**
     * 计算中奖等级
     *
     * @param buyRedBalls   买入的红球
     * @param buyBlueBall   买入的蓝球
     * @param prizeRedBalls 中奖的红球
     * @param prizeBlueBall 中奖的蓝球
     * @return 中奖等级，-1表示未中奖
     */
    public static int calculatePrize(int[] buyRedBalls, int buyBlueBall, int[] prizeRedBalls, int prizeBlueBall) {
        int redCount = 0;
        for (int i = 0; i < buyRedBalls.length; i++) {
            for (int j = 0; j < prizeRedBalls.length; j++) {
                if (buyRedBalls[i] == prizeRedBalls[j]) {
                    redCount++;
                }
            }
        }
        boolean blueMatch = (buyBlueBall == prizeBlueBall);
        if (redCount == 6 && blueMatch) {
            return 1;
        } else if (redCount == 6 && !blueMatch) {
            return 2;
        } else if (redCount == 5 && blueMatch) {
            return 3;
        } else if (redCount == 5 || (redCount == 4 && blueMatch)) {
            return 4;
        } else if (redCount == 4 || (redCount == 3 && blueMatch)) {
            return 5;
        } else if (blueMatch) {
            return 6;
        } else {
            return -1;
        }
    }

    /**
     * 根据中奖等级返回中奖金额
     * @param prizeLevel 中奖等级
     * @return 中奖金额
     */
    public static int getPrizeMoney(int prizeLevel) {
        int prizeMoney = 0;
        switch (prizeLevel) {
            case 1:
                prizeMoney = 5000000;
                break;
            case 2:
                prizeMoney = 100000;
                break;
            case 3:
                prizeMoney = 3000;
                break;
            case 4:
                prizeMoney = 200;
                break;
            case 5:
                prizeMoney = 10;
                break;
            case 6:
                prizeMoney = 5;
                break;
            default:
                break;
        }
        return prizeMoney;
    }
}