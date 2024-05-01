package com.zjw.string;

import org.junit.jupiter.api.Test;

/**
 * StringBuilder 非线程安全
 * 在频繁改变字符串时比较方便，减少系统开销
 */
public class StringBuilderTest {

    /**
     * append 追加
     */
    @Test
    public void appendTest() {
        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb.append(" world"));
    }

    /**
     * reverse 翻转，会改变原StringBuilder
     */
    @Test
    public void reverseTest() {
        StringBuilder sb = new StringBuilder("hello");
        sb.reverse();
        System.out.println(sb); // olleh
    }

    /**
     * insert 插入，会改变原StringBuilder
     * <p>
     * delete 删除，会改变原StringBuilder
     */
    @Test
    public void testInsertDelete() {
        StringBuilder sb = new StringBuilder("hello");
        //插入数据
        System.out.println(sb.insert(1, "**")); // h**ello
        //删除数据
        System.out.println(sb.delete(1, 3)); // hello
    }

}
