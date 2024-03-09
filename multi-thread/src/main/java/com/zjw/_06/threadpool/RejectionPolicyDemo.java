package com.zjw._06.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 1.1 ThreadPoolExecutor创建线程池拒绝策略：
 * <p>
 * AbortPolicy：默认，直接抛出 RejectedExecutionException 异常。
 * <p>
 * CallerRunsPolicy：直接在调用者线程中运行被拒绝的任务。
 * <p>
 * DiscardPolicy：默默地丢弃被拒绝的任务，不做任何处理。
 * <p>
 * DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（如果再次失败，则重复此过程）。
 *
 */
public class RejectionPolicyDemo {
    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, // 核心线程数
            4, // 最大线程数
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(2), // 队列大小
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy() // 调用者运行策略
        );

        // 提交任务
        for (int i = 0; i < 20; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("执行任务: " + taskId + ", 执行线程: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 模拟任务执行时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown(); // 关闭线程池
    }
}