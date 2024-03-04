package com.zjw.number;

/**
 * 计算 平方根倒数
 * <p>
 * 方法一：牛顿法
 * <p>
 * 方法二：平方根倒数快速算法
 *
 * @author 朱俊伟
 * @since 2024/03/04 15:17
 */
public class WTFTest {
    public static void main(String[] args) {
        double x = 5.0; // 测试的数值
        int iterations = 1000000; // 迭代次数
        double result = 0.0;

        // 测试平方根倒数快速算法的性能
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            fastInverseSquareRoot(x);
        }
        long endTime = System.currentTimeMillis();
        long fastTime = endTime - startTime;
        // 平方根倒数快速算法耗时: 5 毫秒
        System.out.println("平方根倒数快速算法耗时: " + fastTime + " 毫秒");

        // 测试牛顿法的性能
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            newtonInverseSquareRoot(x);
        }
        endTime = System.currentTimeMillis();
        long newtonTime = endTime - startTime;
        // 牛顿法耗时: 18 毫秒
        System.out.println("牛顿法耗时: " + newtonTime + " 毫秒");
    }

    // 平方根倒数快速算法
    public static double fastInverseSquareRoot(double x) {
        double xHalf = 0.5 * x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i >> 1); // WTF
        double y = Double.longBitsToDouble(i);
        y *= (1.5 - (xHalf * y * y));
        return y;
    }

    // 牛顿法 计算平方根倒数
    public static double newtonInverseSquareRoot(double x) {
        double guess = x / 2.0;
        double error = 1e-15;
        while (Math.abs(guess * guess - x) > error) {
            guess = (guess + x / guess) / 2.0;
        }
        return 1.0 / guess;
    }
}
