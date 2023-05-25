package com.zjw.util;

import java.util.Random;

/**
 * @author zjw
 * @date 2023/05/25 9:59
 */
public class RandomUtil {

    /**
     *  随机返回数组里面的某个值
     * @param options 数组
     * @return 数组中随机的值
     */
    public static int getRandomNumber(int[] options) {
        Random random = new Random();
        return options[random.nextInt(options.length)];
    }
}
