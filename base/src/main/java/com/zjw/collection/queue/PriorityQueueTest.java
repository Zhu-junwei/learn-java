package com.zjw.collection.queue;

import java.util.*;

/**
 * PriorityQueueTest 类用于演示和测试 Java 中 PriorityQueue 的各种用法。
 * 默认的排序方法使用的是对象在队列中的自然顺序。
 * <p>
 * 主要功能包括：
 * 1. 使用随机数填充优先队列并打印队列内容。
 * 2. 使用预定义列表填充优先队列并打印队列内容。
 * 3. 创建和使用反序排列的优先队列。
 * 4. 使用字符串和字符填充优先队列并打印队列内容。
 *
 * @author 朱俊伟
 * @since 2024/07/07 01:50
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        // 创建一个默认的PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(50);
        for (int i = 0; i < 10; i++)
            priorityQueue.offer(rand.nextInt(i + 10));
        printQ(priorityQueue);

        // 创建一个包含指定元素的PriorityQueue
        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        printQ(priorityQueue);

        // 创建一个以反序排列元素的PriorityQueue
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        printQ(priorityQueue);

        // 字符串优先队列测试
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(" "));
        PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
        printQ(stringPQ);

        // 创建一个以反序排列字符串的PriorityQueue
        stringPQ = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        printQ(stringPQ);

        // 字符优先队列测试
        Set<Character> charSet = new HashSet<>();
        for (char c : fact.replaceAll(" ", "").toCharArray())
            charSet.add(c); // 自动装箱
        PriorityQueue<Character> characterPQ = new PriorityQueue<>(charSet);
        printQ(characterPQ);
    }

    // 打印并移除队列中的所有元素
    public static <T> void printQ(Queue<T> queue) {
        while (queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
    }
}
