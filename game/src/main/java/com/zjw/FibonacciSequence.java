package com.zjw;

/**
 * 斐波那契数列
 *
 * @author 朱俊伟
 * @since 2023/09/23 15:27
 */
public class FibonacciSequence {

    public static void main(String[] args) {
        int n = 45;
        long time1 = System.currentTimeMillis();
        System.out.println(fib(n));
        long time2 = System.currentTimeMillis();
        System.out.println("耗时" + (time2 - time1) / 1000 + "s");

        System.out.println(fibMatrix(n));
        long time3 = System.currentTimeMillis();
        System.out.println("耗时" + (time3 - time2) / 1000 + "s");
    }

    /**
     * 给定一个斐波那契数列 1, 1, 2, 3, 5, 8, 13, … ，求该数列的第 𝑛 个数字。
     * 设斐波那契数列的第 𝑛 个数字为 𝑓(𝑛) ，易得两个结论。
     * 数列的前两个数字为 𝑓(1) = 1 和 𝑓(2) = 1 。
     * 数列中的每个数字是前两个数字的和，即 𝑓(𝑛) = 𝑓(𝑛 − 1) + 𝑓(𝑛 − 2) 。
     * 按照递推关系进行递归调用，将前两个数字作为终止条件，便可写出递归代码。调用 fib(n) 即可得到斐波那
     * 契数列的第 𝑛 个数字。
     */
    public static long fib(int n) {
        // 终止条件 f(1) = 0, f(2) = 1
        if (n == 1 || n == 2)
            return 1;
        // 递归调用 f(n) = f(n-1) + f(n-2)
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 使用矩阵快速幂计算斐波那契数列的第 n 个数字。
     *
     * @param n 序数
     * @return 斐波那契数列的第 n 个数字
     */
    public static long fibMatrix(int n) {
        long[][] F = {{1, 1}, {1, 0}};
        if (n == 0)
            return 0;
        power(F, n - 1);

        return F[0][0];
    }

    /**
     * 计算矩阵的 n 次幂（快速幂方法）。
     *
     * @param F 矩阵
     * @param n 幂
     */
    public static void power(long[][] F, int n) {
        if (n == 0 || n == 1)
            return;
        long[][] M = {{1, 1}, {1, 0}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }

    /**
     * 矩阵乘法。
     *
     * @param F 第一个矩阵
     * @param M 第二个矩阵
     */
    public static void multiply(long[][] F, long[][] M) {
        long x = F[0][0] * M[0][0] + F[0][1] * M[1][0];
        long y = F[0][0] * M[0][1] + F[0][1] * M[1][1];
        long z = F[1][0] * M[0][0] + F[1][1] * M[1][0];
        long w = F[1][0] * M[0][1] + F[1][1] * M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }
}
