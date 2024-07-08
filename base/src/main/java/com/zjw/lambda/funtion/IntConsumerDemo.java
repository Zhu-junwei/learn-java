package com.zjw.lambda.funtion;

import java.util.function.BiConsumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/**
 * IntConsumer 给定一个int值，然后执行一个操作，无返回值。
 * 相似的还有：{@link LongConsumer} {@link DoubleConsumer} {@link BiConsumer}
 *
 *
 * @author 朱俊伟
 * @since 2022/03/31 23:36
 */
public class IntConsumerDemo {

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

