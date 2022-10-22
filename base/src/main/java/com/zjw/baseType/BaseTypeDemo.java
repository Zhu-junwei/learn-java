package com.zjw.baseType;

import org.junit.Test;

/**
 * 字符的使用
 * @author 朱俊伟
 * @date 2022/02/07 20:58
 */
public class BaseTypeDemo {

    /**
     * UniCode编码表 https://blog.csdn.net/tgvincent/article/details/93884725
     */
    @Test
    public void testChar(){
        char c1 = 'A';
        System.out.println(c1);
        //۞ 使用UniCode编码表示字符
        char c2 = '\u06de';
        System.out.println(c2);
    }
}
