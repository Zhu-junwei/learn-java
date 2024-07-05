package com.zjw.number;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 随机数
 *
 * @author 朱俊伟
 * @since 2024/03/19 18:17
 */
public class RandomTest {

    /**
     * 获取随机数
     */
    @Test
    public void testRandom() {
        int size = 10;
        int[] iArr = new int[size];

        Random random = new Random();
        for(int i = 0; i < size; i++)
            // 随机生成的整数 Integer.MIN_VALUE ~ Integer.MAX_VALUE
            iArr[i] = random.nextInt();
        for(int x : iArr)
            System.out.println(x);

        // seed是一个随机数种子，相同的种子值会产生相同的随机数序列
        Random rand = new Random(47L);
        float[] f = new float[size];
        for(int i = 0; i < size; i++)
            // 返回此随机数生成器序列之间[0.0,1.0)
            f[i] = rand.nextFloat();
        for(float x : f)
            System.out.println(x);
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
        int size = 10;
        int[] iArr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            iArr[i] = random.nextInt(0, 10);
        }
        for (int x : iArr) {
            System.out.println(x);
        }
    }

}
