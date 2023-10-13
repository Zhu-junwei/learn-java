package com.zjw;

/**
 * 斐波那契数列
 *
 * @author 朱俊伟
 * @date 2023/09/23 15:27
 */
public class FibonacciSequence {

    public static void main(String[] args) {
        int n = 5;
        int res;
        res = fib(n);
        System.out.println(res);
    }

    /**
     * 给定一个斐波那契数列 0, 1, 1, 2, 3, 5, 8,13, … ，求该数列的第 𝑛 个数字。
     * 设斐波那契数列的第 𝑛 个数字为 𝑓(𝑛) ，易得两个结论。
     * 数列的前两个数字为 𝑓(1) = 0 和 𝑓(2) = 1 。
     * 数列中的每个数字是前两个数字的和，即 𝑓(𝑛) = 𝑓(𝑛 − 1) + 𝑓(𝑛 − 2) 。
     * 按照递推关系进行递归调用，将前两个数字作为终止条件，便可写出递归代码。调用 fib(n) 即可得到斐波那
     * 契数列的第 𝑛 个数字。
     */
    public static int fib(int n) {
        // 终止条件 f(1) = 0, f(2) = 1
        if (n == 1 || n == 2)
            return n - 1;
        // 递归调用 f(n) = f(n-1) + f(n-2)
        return fib(n-1) + fib(n-2);
    }
}
