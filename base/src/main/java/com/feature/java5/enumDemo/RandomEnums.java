package com.feature.java5.enumDemo;

import lombok.Getter;

import java.util.Random;

/**
 * 随机获取枚举类型
 *
 * @author 朱俊伟
 * @since 2024/10/15 21:01
 */
public class RandomEnums {
    private static final Random rand = new Random();

    // 该方法用于从指定的枚举类中随机选择一个枚举常量
    public static <T extends Enum<T>> T random(Class<T> ec) {
        // 获取所有枚举类型的常量
        T[] enumConstants = ec.getEnumConstants();
        return random(enumConstants);
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ColorE randomColor = RandomEnums.random(ColorE.values());
            System.out.println(randomColor);
        }
    }
}

@Getter
enum ColorE {
    GREEN,
    RED,
    BLACK
}
