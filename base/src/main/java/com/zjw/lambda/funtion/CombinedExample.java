package com.zjw.lambda.funtion;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 组合函数和谓词
 *
 * @author 朱俊伟
 * @date 2024/07/08
 */
public class CombinedExample {
    public static void main(String[] args) {
        // 定义函数
        Function<String, Integer> parseInt = Integer::parseInt;
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add3 = x -> x + 3;

        // 组合函数：先解析字符串，再乘以2，然后加3
        Function<String, Integer> combinedFunction = parseInt.andThen(multiplyBy2).andThen(add3);
        int result = combinedFunction.apply("5"); // (Integer.parseInt("5") * 2) + 3 = 13
        System.out.println("Result of combinedFunction: " + result);

        // 定义谓词
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isGreaterThan5 = x -> x > 5;

        // 组合谓词：既是偶数又大于5
        Predicate<Integer> combinedPredicate = isEven.and(isGreaterThan5);
        System.out.println("Is 8 even and greater than 5? " + combinedPredicate.test(8)); // true
        System.out.println("Is 4 even and greater than 5? " + combinedPredicate.test(4)); // false
    }
}
