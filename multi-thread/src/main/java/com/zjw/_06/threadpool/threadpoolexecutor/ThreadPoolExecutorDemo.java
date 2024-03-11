package com.zjw._06.threadpool.threadpoolexecutor;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. 使用ThreadPoolExecutor创建线程池
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, // 线程池的核心线程数量
                4, // 线程池的最大线程数
                100, // 当线程数大于核心线程数时，多余的空闲线程存活的最长时间
                TimeUnit.MILLISECONDS, // 时间单位
                new ArrayBlockingQueue<>(2), // 任务队列，用来储存等待执行任务的队列
                new CustomThreadFactory("zjw"),   //线程工厂，用来定义线程的名称以及是否为守护线程，默认为Executors.defaultThreadFactory()
                new ThreadPoolExecutor.CallerRunsPolicy() // 拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
        );

        // 提交任务
        for (int i = 0; i < 10; i++) {
            int taskNo = i;
            try {
                executor.execute(() -> {
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

/**
 * 自定义线程工厂
 */
class CustomThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNumber = new AtomicInteger(1);

    private final String namePrefix;

    public CustomThreadFactory(String prefix) {
        this.namePrefix = prefix + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement());
        // 设置线程为守护线程（可选）
        t.setDaemon(true);
        // 设置线程优先级（可选）
        t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}