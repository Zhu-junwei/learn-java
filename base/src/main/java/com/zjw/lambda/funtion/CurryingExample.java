package com.zjw.lambda.funtion;

import java.util.function.Function;

/**
 * 柯里化: 将一个接受多个参数的函数转换为接受一个参数的函数
 */
public class CurryingExample {
    public static void main(String[] args) {
        // 定义一个接受三个参数的函数
        Function<Integer, Function<Integer, Function<Integer, Integer>>> add = a -> b -> c -> a + b + c;

        // 使用柯里化的函数
        Function<Integer, Function<Integer, Integer>> add5 = add.apply(5);
        Function<Integer, Integer> add5And3 = add5.apply(3);
        int result = add5And3.apply(2); // 相当于 5 + 3 + 2

        System.out.println(result); // 输出 10

        // 或者更简洁地调用柯里化的函数
        int result2 = add.apply(5).apply(3).apply(2);
        System.out.println(result2); // 输出 10
    }
}