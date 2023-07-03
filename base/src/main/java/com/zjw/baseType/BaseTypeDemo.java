package com.zjw.baseType;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 基本数据类型
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

    /**
     * 测试BigDecimal转double
     */
    @Test
    public void testdouble(){
        double d1 = 1.23;
        System.out.println(d1);
        System.out.println(1.23 + 1.45);
        BigDecimal  bigDecimal = new BigDecimal(1.23);
        BigDecimal bigDecimal1 = new BigDecimal(1.45);
        System.out.println(bigDecimal.add(bigDecimal1).setScale(2, RoundingMode.HALF_UP).doubleValue());
        System.out.println(2.68);
    }
}
