package com.feature.java7;

import org.junit.jupiter.api.Test;

/**
 * Java7开始可以使用二进制表示数字，可以使用下划线来分隔数字，提高可读性
 *
 * @author 朱俊伟
 * @since 2024/07/02 19:52
 */
public class UnderlineTest {

    /**
     * 下划线表示形式
     */
    @Test
    public void underlineTest() {
        int i1 = 100;
        int i2 = 1_0000_9999;

        System.out.println(i1);
        System.out.println(i2);
    }

    /**
     * 二进制表示形式
     */
    @Test
    public void binaryTest() {
        int i1 = 0b1010;//二进制
        int i2 = 0b1010_1010;

        System.out.println(i1);
        System.out.println(i2);
    }
}
