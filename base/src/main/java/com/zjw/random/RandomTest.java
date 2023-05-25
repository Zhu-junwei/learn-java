package com.zjw.random;

import com.zjw.util.RandomUtil;
import org.junit.Test;

import java.util.Random;

/**
 * @author zjw
 * @date 2023/05/25 9:51
 */
public class RandomTest {


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
