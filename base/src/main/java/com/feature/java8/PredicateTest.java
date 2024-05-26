package com.feature.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate断言 是一个函数式接口，用于表示一个接受一个参数并返回 boolean 值的断言（判断条件）。
 * @author 朱俊伟
 * @since 2024/05/26 22:59
 */
public class PredicateTest {

    /**
     * 测试Predicate 判断是否为偶数
     */
    @Test
    public void predicateTest() {
        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println(isEven.test(4)); // 输出 true
        System.out.println(isEven.test(5)); // 输出 false
    }

    /**
     * Predicate 过滤集合
     */
    @Test
    public void predicateFilterTest() {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        Predicate<String> startsWithA = name -> name.startsWith("A");

        List<String> namesStartingWithA = names.stream()
                .filter(startsWithA) // 传入Predicate 对象
                .collect(Collectors.toList());

        System.out.println(namesStartingWithA); // 输出 [Alice]
    }

    /**
     * Predicate and，判断是否为正整数
     */
    @Test
    public void predicateAndTest() {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        Predicate<Integer> isPositiveEven = isEven.and(isPositive);

        System.out.println(isPositiveEven.test(4));  // 输出 true
        System.out.println(isPositiveEven.test(-4)); // 输出 false
        System.out.println(isPositiveEven.test(3));  // 输出 false
    }

    /**
     * Predicate or，判断是否为偶数或者大于10
     */
    @Test
    public void predicateOrTest() {
        // 判断是否为偶数的 Predicate
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // 判断是否大于 10 的 Predicate
        Predicate<Integer> isGreaterThanTen = n -> n > 10;

        // 组合两个 Predicate，判断是否为偶数或者大于 10
        Predicate<Integer> isEvenOrGreaterThanTen = isEven.or(isGreaterThanTen);

        // 测试
        System.out.println(isEvenOrGreaterThanTen.test(4));   // 输出 true，因为 4 是偶数
        System.out.println(isEvenOrGreaterThanTen.test(11));  // 输出 true，因为 11 大于 10
        System.out.println(isEvenOrGreaterThanTen.test(9));   // 输出 false，因为 9 既不是偶数也不大于 10
    }

    /**
     * Predicate negate，取反，判断是否为奇数
     */
    @Test
    public void predicateNegateTest() {
        // 判断是否为偶数的 Predicate
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // 取反，判断是否为奇数的 Predicate
        Predicate<Integer> isOdd = isEven.negate();

        // 测试
        System.out.println(isOdd.test(4));  // 输出 false，因为 4 是偶数
        System.out.println(isOdd.test(5));  // 输出 true，因为 5 是奇数
    }


}