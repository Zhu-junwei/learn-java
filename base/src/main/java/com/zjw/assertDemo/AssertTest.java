package com.zjw.assertDemo;

import org.junit.jupiter.api.Test;

/**
 * 使用断言测试时需要开启断言
 *  开启 -enableassertions 或 -ea
 * @author 朱俊伟
 * @since 2022/04/08 1:03
 */
public class AssertTest {

    /**
     * Java 语言引人了关键字 assert。这个关键字有两种形式：
     *  assert 条件;
     *  和
     *  assert 条件:表达式;
     * 这两种形式都会对条件进行检测， 如果结果为 false, 则抛出一个 AssertionError 异常。
     * 在第二种形式中，表达式将被传人 AssertionError 的构造器， 并转换成一个消息字符串
     */
    @Test
    public void testAssert(){
        int x = -2;
        assert x == 0 : x;
        System.out.println("hello");
    }

    /**
     * assert boolean-expression: information-expression;
     * 如果boolean-expression 为 false，则抛出 AssertionError 异常，
     * 可以在异常栈里生成一个有用的消息。
     */
    @Test
    public void informationExpTest() {
        int x = -2;
        assert x >= 0 : "x is negative, not positive";
    }

    /**
     * dynamic动态断言
     */
    @Test
    public void dynamicTest() {
        int x = -2;
        assert x >= 0 : "x is negative, not positive";
    }

    public static void main(String[] args) {
        int x = -2;
        assert x >= 0 : "x is negative, not positive";
    }
}
