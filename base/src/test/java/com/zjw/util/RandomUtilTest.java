package com.zjw.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 朱俊伟
 * @date 2023/07/14 23:36
 */
public class RandomUtilTest {

    /**
     * 有一个数组，随机返回里面的某个值
     */
    @Test
    public void getRandomNumber() {
        int[] options = {3, 9, 5, 0, 6, 2, 4};
        for (int i = 0; i < 10; i++) {
            int result = RandomUtil.getRandomNumber(options);
            System.out.println(result);
        }
    }
}