package com.zjw.lambda.funtion;

import java.util.function.Function;

/**
 * Function 函数接口
 * R apply(T t); 接收一个输入参数，输出一个结果
 */
public class FunctionDemo {
    public static void main(String[] args) {
        // 定义一个 Function<String, String> 函数，将字符串转换为大写
        Function<String, String> toUpperCaseFunction = String::toUpperCase;
        // 使用 apply 方法转换为大写
        String upperCaseString = toUpperCaseFunction.apply("hello, world!");
        System.out.println("Uppercase String: " + upperCaseString);

        // 使用闭包
        int number = 10;
        // Lambda 表达式作为闭包
        Function<Integer, Integer> addNumber = (Integer x) -> x + number;
        System.out.println( addNumber.apply(5)); // 输出 15
        System.out.println( addNumber.apply(5));
    }
}