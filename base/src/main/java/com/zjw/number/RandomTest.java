package com.zjw.number;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author 朱俊伟
 * @since 2024/03/19 18:17
 */
public class RandomTest {

    /**
     * 随机获取整数
     */
    @Test
    public void testRandom() {
        Random random = new Random();
        while (true) {
            // 随机生成的整数 Integer.MIN_VALUE ~ Integer.MAX_VALUE
            int randomInt = random.nextInt();
            if (randomInt < 0) {
                System.out.println(randomInt);
                break;
            }
        }
    }

    /**
     * 随机获取指定范围内的整数 [0,100)
     */
    @Test
    public void testRandomInt() {
        Random random = new Random();
        int randomInt = random.nextInt(100);
        System.out.println("randomInt = " + randomInt);
    }

    /**
     * 随机获取指定范围内的整数 [0,10)
     */
    @Test
    public void testRandomInt2() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int randomInt = random.nextInt(0, 10);
            if (randomInt == 10|| randomInt == 0){
                System.out.println("randomInt = " + randomInt);
            }
        }
    }
}
