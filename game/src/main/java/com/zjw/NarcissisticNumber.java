package com.zjw;

import java.util.ArrayList;
import java.util.List;

/**
 * 水仙花数
 * <p>
 *      水仙花数是指一个 n 位数(n≥3),它的每个位上的数字的 n 次幂之和等于它本身。
 *          例如:153 就是一个水仙花数,因为 153=1^3 + 5^3 + 3^3
 * 水仙花数的一般定义是:
 *       对于一个 n 位数,每个位上的数字分别是 a_n, a_n-1, ..., a_1。
 *       如果这个数满足:
 *       a_n^n + a_n-1^n + ... + a_1^n = 原数
 *       则这个数就是一个 n 位的水仙花数。
 * @author 朱俊伟
 * @since 2023/10/06 8:56
 */
public class NarcissisticNumber {

    public static void main(String[] args) {
        List<Integer> numbers = getNarcissisticNumbersInRange(100, 1000);
        System.out.println(numbers);
    }

    // 找到一个范围内的所有水仙花数
    public static List<Integer> getNarcissisticNumbersInRange(int min, int max) {
        // 存放水仙花数的集合
        List<Integer> narcissisticNumberList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (isNarcissisticNumber(i)) {
                narcissisticNumberList.add(i);
            }
        }
        return narcissisticNumberList;
    }

    /**
     * 判断一个数是否为水仙花数
     * @param num 需要判断的数
     * @return 是返回true，否则返回false
     */
    public static boolean isNarcissisticNumber(int num) {
        //判断一个数的位数
        int digits = String.valueOf(num).length();
        //求和的结果
        int sum = 0;
        int n = num;
        while (n > 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, digits);
            n /= 10;
        }
        return num == sum;
    }
}
