package com.zjw.lambda;

import java.util.function.IntConsumer;

/**
 * @author 朱俊伟
 * @since 2022/03/31 23:36
 */
public class IntConsumerTest {

    public static void main(String[] args) {
        repeat(10, () -> System.out.println("Hello World!"));
        repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
    }

    public static void repeat(int n, Runnable action){
        for (int i = 0; i < n; i++)
            //调用run方法会执行表达式主体
            action.run();
    }

    public static void repeat(int n, IntConsumer action){
        for (int i = 0; i < n; i++)
            //调用run方法会执行表达式主体
            action.accept(i);
    }

}

