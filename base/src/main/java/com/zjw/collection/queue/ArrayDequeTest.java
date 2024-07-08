package com.zjw.collection.queue;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ArrayDeque , 队列和栈的使用
 * @author 朱俊伟
 * @since 2024/04/18 15:28
 */
public class ArrayDequeTest {

    /**
     * 队列测试（先进先出 FIFO）
     * <p>
     * <ul>
     * <li>添加元素到尾部：offer(e) 或 add(e)</li>
     * <li>移除头部的元素：poll() 或 remove()</li>
     * <li>查看头部的元素：peek() 或 element()</li>
     * </ul>
     *
     */
    @Test
    public void queueTest() {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        // 队列大小
        System.out.println(queue.size()); // 3
        System.out.println(queue.poll()); // 输出 1
        System.out.println(queue.poll()); // 输出 2
        System.out.println(queue.peek()); // 输出 3
        System.out.println(queue.poll()); // 输出 3
        System.out.println(queue.poll()); // null
        // 队列大小
        System.out.println(queue.size()); // 0
    }

    /**
     * 栈测试（后进先出 LIFO）
     * <p>
     * <ul>
     * <li>压栈：push(e)</li>
     * <li>弹栈：pop()</li>
     * <li>查看栈顶元素：peek()</li>
     * </ul>
     */
    @Test
    public void stackTest() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 栈大小
        System.out.println(stack.size()); // 3
        System.out.println(stack.pop()); // 输出 3
        System.out.println(stack.pop()); // 输出 2
        System.out.println(stack.peek()); // 输出 1
        // 栈大小
        System.out.println(stack.size()); // 1
    }

}
