package com.zjw.loop;

import java.util.Arrays;

/**
 * 一维数组：求最大值、最小值、冒泡排序
 * 2017-12-24
 *
 * @author Junwei Zhu
 */
public class ForLoop {
    public static void main(String[] args) {
        int[] scores = {12, 65, 98, 45, 26};
        System.out.println(Arrays.toString(scores));
        int max = scores[0];
        int min = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max)
                max = scores[i];
        }
        for (int i : scores) {
            max = i > max ? i : max;
            min = i < min ? i : min;
        }

        System.out.println("最大成绩为：" + max);
        System.out.println("最小成绩为：" + min);
        //冒泡排序
        for (int i = 0; i < scores.length - 1; i++) {//比较的轮数
            for (int j = 0; j < scores.length - i - 1; j++) {//每轮比较的次数，每次把最小的那个放到最后
                if (scores[j] < scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(scores));
    }
}
