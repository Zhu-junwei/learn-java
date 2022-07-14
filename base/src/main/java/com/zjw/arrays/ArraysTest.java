package com.zjw.arrays;

import java.util.Arrays;

/**
 * @author 朱俊伟
 * @date 2022/07/12
 */
public class ArraysTest {
    public static void main(String[] args) {
        Object[] obj1 = new Object[5];
        obj1[0] = 12;
        obj1[3] = "aaa";
        obj1[4] = "bbb";
        obj1 = Arrays.copyOf(obj1,obj1.length+2);

        System.out.println(Arrays.toString(obj1));
    }

}
