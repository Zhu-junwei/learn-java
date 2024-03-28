package com.zjw.number;

import org.junit.jupiter.api.Test;

/**
 * @author 朱俊伟
 * @since 2024/03/27 14:27
 */
public class IntegerTest {

    /**
     * 测试Integer中的缓存
     * <p>
     *     缓存范围：-128~127
     */
    @Test
    public void IntegerCacheTest() {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b); // true

        // 推荐使用 equals 方法进行判断
        Integer a1 = 128;
        Integer b1 = 128;
        System.out.println(a1 == b1); // false
        System.out.println(a1.equals(b1)); // true
    }
}
