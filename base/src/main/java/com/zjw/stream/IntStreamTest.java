package com.zjw.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * 测试IntStream整形流
 *
 * @author 朱俊伟
 * @since 2024/07/09 02:16
 */
public class IntStreamTest {

    /**
     * range 生成知道范围内的数组
     */
    @Test
    public void rangeTest() {
        // [1,10) 不包括结尾
        int[] array = IntStream.range(1, 10).toArray();
        for (int i : array) {
            System.out.println(i);
        }
        // [1,10]
        IntStream.rangeClosed(1, 10).forEach(System.out::println);

        // 从1到10的和
        System.out.println(IntStream.rangeClosed(1, 10).sum());
    }

    /**
     * iterate 一个无限的顺序
     */
    @Test
    public void iterateTest() {
        // 从1开始的10个奇数
        IntStream.iterate(1, i -> i + 2)
                .limit(10)
                .forEach(System.out::println);

        // 小于20的奇数
        IntStream.iterate(1, i -> i < 20, i -> i + 2)
                .forEach(System.out::println);

    }

    /**
     * mapMulti 映射多个值
     * <p>
     * since 16
     */
    @Test
    public void mapMultiTest() {
        IntStream.range(1, 5)
                .mapMulti((value, ic) -> {
                    ic.accept(value);       // 接受当前值
                    ic.accept(value * value); // 接受当前值的平方
                })
                // 输出: [1, 1, 2, 4, 3, 9, 4, 16]
                .forEach(System.out::println);
    }
}
