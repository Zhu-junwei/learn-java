package com.zjw.string;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

/**
 * StringJoiner测试类， jdk 1.8提供的处理字符串拼接的类
 *
 * @author 朱俊伟
 * @since 2024/04/30 21:43
 */
public class StringJoinerTest {

    /**
     * delimiter， 分隔符
     */
    @Test
    public void delimiterTest() {
        StringJoiner sj = new StringJoiner(",");
        sj.add("a").add("b").add("c");
        System.out.println(sj); // a,b,c
    }

    /**
     * 开始结束标记
     */
    @Test
    public void prefixSuffixTest() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        sj.add("a").add("b").add("c");
        System.out.println(sj); // [a,b,c]
    }
}
