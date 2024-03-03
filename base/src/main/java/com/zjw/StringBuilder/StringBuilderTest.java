package com.zjw.StringBuilder;

import org.junit.jupiter.api.Test;

/**
 * 2018-01-12
 *
 * @author Junwei Zhu
 * 正则表达式
 * 字符串生成器StringBuilder.
 * 在频繁改变字符串时比较方便，减少系统开销
 */
public class StringBuilderTest {

    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder("hello");
        //插入数据
        System.out.println(sb.insert(1, "**"));
        //删除数据
        System.out.println(sb.delete(1, 3));
        String regex = "\\d{11}";
        String str = "15638610589";
        if (str.matches(regex)) {
            System.out.println("这是一个手机号");
        } else {
            System.out.println("这不是一个手机号");
        }
    }
}
