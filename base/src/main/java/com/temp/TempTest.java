package com.temp;

/**
 * @author 朱俊伟
 * @since 2024/03/20 22:11
 */
public class TempTest {

    // 根据金额范围获取费率
    public static double getFeeRate(double amount) {
        if (amount <= 5000000) {
            return 0.00008;
        } else if (amount <= 25000000) {
            return 0.00007;
        } else if (amount <= 50000000) {
            return 0.00006;
        } else {
            return 0.00005;
        }
    }

    // 计算费用并进行四舍五入
    public static double calculateFee(double amount) {
        double feeRate = getFeeRate(amount);
        double fee = amount * feeRate;
        return Math.round(fee);
    }

    // 根据规定收取费用
    public static double collectFee(double fee) {
        if (fee < 100) {
            return 100;
        } else if (fee > 10000) {
            return 10000;
        } else {
            return fee;
        }
    }

    public static void main(String[] args) {
        double amount = 60000000; // 金额
        double fee = calculateFee(amount); // 计算费用
        double collectedFee = collectFee(fee); // 根据规定收取费用
        System.out.println("收取费用: " + collectedFee);
    }

}
