package com.feature.java17;

import java.util.random.RandomGenerator;

/**
 * 随机数生成器
 * <p>
 * Enhanced Pseudo-Random Number Generators <a href="https://openjdk.org/jeps/356">EJP356</a>
 *
 * @author 朱俊伟
 * @since 2024/03/24 15:58
 */
public class RandomGeneratorTest {
    public static void main(String[] args) {
        RandomGenerator generator = RandomGenerator.getDefault();
        int nextInt = generator.nextInt(0, 100);
        System.out.println("nextInt = " + nextInt);

    }
}
