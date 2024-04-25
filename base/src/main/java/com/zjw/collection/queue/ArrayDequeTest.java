package com.zjw.collection.queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ArrayDeque , 可动态扩容的数组实现的队列
 * 队列测试
 * @author 朱俊伟
 * @since 2024/04/18 15:28
 */
public class ArrayDequeTest {

    /**
     * 测试向ArrayDeque中添加元素，
     * 这种其实可以使用List来实现
     */
    @Test
    public void testAddAndRemove() {
        Queue<Integer> queue = new ArrayDeque<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        while (!queue.isEmpty()) {
            //获取元素 , 先进先出
            System.out.println(queue.remove());
        }
    }

}
