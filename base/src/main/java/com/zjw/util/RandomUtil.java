package com.zjw.util;

import java.util.List;
import java.util.Random;

/**
 * @author zjw
 * @since 2023/05/25 9:59
 */
public class RandomUtil {


    private static final Random RANDOM = new Random();
    
    /**
     *  随机返回数组里面的某个值
     * @param options 数组
     * @return 数组中随机的值
     */
    public static int getRandomElement(int[] options) {
        return options[RANDOM.nextInt(options.length)];
    }


    /**
     * 从数组中随机返回一个元素
     */
    public static <T> T getRandomElement(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("数组不能为空");
        }
        return array[RANDOM.nextInt(array.length)];
    }

    /**
     * 从集合中随机返回一个元素
     */
    public static <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("集合不能为空");
        }
        return list.get(RANDOM.nextInt(list.size()));
    }
}
