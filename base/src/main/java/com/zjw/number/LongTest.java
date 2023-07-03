package com.zjw.number;


import org.junit.Test;

/**
 * @author zjw
 * @date 2023/07/03 10:54
 */
public class LongTest {

    /**
     * 测试Long相等
     */
    @Test
    public void testEquals() {
        Long a = 1000L;
        Long b = 1000L;
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true
    }
}
