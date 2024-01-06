package com.zjw;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序
 * @author 朱俊伟
 * @since 2023/09/23 16:03
 */
public class BubbleSort {
    public static void main(String[] args) {
        // 准备一个数据并初始化数据
        int[] nums = new int[30];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt(100);
        }
        //调用排序算法
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] nums) {
        // 外循环: 为排序区间为[0, i]
        for (int i = nums.length -1; i > 0; i--) {
            // 内循环: 将未排序区间[0, i]中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }
}
