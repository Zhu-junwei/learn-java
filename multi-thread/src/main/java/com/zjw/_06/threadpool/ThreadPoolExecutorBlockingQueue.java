package com.zjw._06.threadpool;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.*;

/**
 * 1.2 线程池中常见的阻塞队列
 * <p>
 * ArrayBlockingQueue   基于数组结构的有界队列，FIFO
 * <p>
 * LinkedBlockingQueue  基于链表的有界队列，FIFO
 * <p>
 * DelayedWorkQueue     是一个优先级队列，它可以保证每次出队的任务都是当前队列中优先级最高的任务
 * <p>
 * SynchronousQueue     不存储元素的阻塞队列，每个插入操作都必须等待一个移除操作
 *
 */
public class ThreadPoolExecutorBlockingQueue {
    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                100,
                TimeUnit.MILLISECONDS,
//                new ArrayBlockingQueue<>(2), // 任务队列，用来储存等待执行任务的队列
                new LinkedBlockingQueue<>(2),
                new ThreadPoolExecutor.CallerRunsPolicy() // 拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
        );

        // 提交任务
        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            try {
                executor.submit(() -> {
                    System.out.println("Executing Task " + taskNo + " in thread " + Thread.currentThread().getName());
                    // 模拟任务执行时间
                    ThreadUtil.sleep(2000);
                });
            } catch (RejectedExecutionException e) {
                System.err.println("Task " + taskNo + " rejected: " + e.getMessage());
            }
        }

        // 关闭线程池
        executor.shutdown();
        try {
            // 等待直到所有任务完成
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}