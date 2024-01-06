package com.zjw.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zjw
 * @since 2023/07/26 13:38
 */
public class StringArrayTest {

    /**
     * 根据条件初始化数组
     */
    @Test
    public void testStringArray(){
        String[] strings = null;
        if (2<1){
            strings = new String[]{"1", "2"};
        } else {
            strings = new String[]{"1", "2", "3"};
        }
        System.out.println(Arrays.toString(strings));
    }
}
