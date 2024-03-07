package com.zjw.number;

import org.junit.jupiter.api.Test;

/**
 * Math测试
 * @author zjw
 * @since 2023/05/05 15:45
 */
public class MathTest {

    /**
     * 测试最大值
     */
    @Test
    public void testMathMax(){
        System.out.println(Math.max(1, 2));//2
    }

    /**
     * 测试最小值
     */
    @Test
    public void testMathMin(){
        System.out.println(Math.min(1, 2));//1
    }

    /**
     * 测试随机生成一个随机数[0,1)
     */
    @Test
    public void testMathRandom(){
        double random = Math.random();
        System.out.println(random);
    }

    /**
     * 测试四舍五入
     */
    @Test
    public void testMathRound(){
        System.out.println(Math.round(1.4));//1
        System.out.println(Math.round(1.5));//2
    }

    /**
     * 取绝对值
     */
    @Test
    public void testMathAbs(){
        System.out.println(Math.abs(2));//2
        System.out.println(Math.abs(-2));//2
    }

    /**
     * 向下取整
     */
    @Test
    public void testMathFloor(){
        System.out.println(Math.floor(1.4));//1.0
        System.out.println(Math.floor(1.5));//1.0
    }

    /**
     * 向上取整
     */
    @Test
    public void testMathCeil(){
        System.out.println(Math.ceil(1.4));//2.0
        System.out.println(Math.ceil(1.5));//2.0
    }

    /**
     * 算数平方根
     */
    @Test
    public void testMathSqrt(){
        System.out.println(Math.sqrt(4));//2.0
    }

    /**
     * 三次方
     */
    @Test
    public void testMathPow(){
        System.out.println(Math.pow(2, 3));//8.0
    }

    /**
     * 常量
     */
    @Test
    public void testMathConstant(){
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.E = " + Math.E);
    }
}
