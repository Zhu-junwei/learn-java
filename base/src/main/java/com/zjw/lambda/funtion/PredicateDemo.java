package com.zjw.lambda.funtion;

import java.util.function.Predicate;

/**
 * Predicate测试
 * boolean test(T t); 根据给定的参数计算此谓词
 *
 * @author 朱俊伟
 * @since 2024/07/08 10:50
 */
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = String::isEmpty;
        System.out.println(predicate.test("")); // true
        System.out.println(predicate.test("hello")); // false
    }
}
