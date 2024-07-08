package com.zjw.lambda.funtion;

import java.util.function.ToLongFunction;

/**
 * ToLongFunction测试
 * long applyAsLong(T value); 将一个参数转为long基本类型
 *
 * @author 朱俊伟
 * @since 2024/07/08 11:11
 */
public class ToLongFunctionDemo {
    public static void main(String[] args) {
        // 定义一个 ToLongFunction<String> 函数，将字符串转换为 long
        ToLongFunction<String> stringToLongFunction = Long::parseLong;


        // 测试字符串
        String numericString = "123456789";
        String anotherNumericString = "987654321";

        // 使用 applyAsLong 方法转换字符串为 long
        long result1 = stringToLongFunction.applyAsLong(numericString);
        long result2 = stringToLongFunction.applyAsLong(anotherNumericString);

        // 打印结果
        System.out.println("The long value of numericString is: " + result1);
        System.out.println("The long value of anotherNumericString is: " + result2);

        // 处理无效字符串的示例
        String invalidString = "not a number";
        try {
            long resultInvalid = stringToLongFunction.applyAsLong(invalidString);
            System.out.println("The long value of invalidString is: " + resultInvalid);
        } catch (NumberFormatException e) {
            System.out.println("Error: '" + invalidString + "' is not a valid number.");
        }
    }
}
