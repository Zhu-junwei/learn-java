package com.zjw.baseType;

import org.junit.Test;

/**
 * @author 朱俊伟
 * @date 2022/02/07 20:58
 */
public class BaseTypeDemo {
    public static void main(String[] args) {

    }

    /**
     * UniCode编码表 https://blog.csdn.net/tgvincent/article/details/93884725
     */
    @Test
    public void testChar(){
        char c1 = 'A';
        System.out.println(c1);
        char c2 = '\u034f';
        System.out.println(c2);
    }
}
