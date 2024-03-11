package com.zjw._06.threadpool.executors;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 2. 使用Executors创建线程池
 * <p>
 * 《阿里Java开发手册》线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这
 * 样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 */
public class ExecutorsDemo {
    public static void main(String[] args) {
        // 使用Executors创建固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(4); // 设置线程池的大小为4

        // 提交任务
        for (int i = 0; i < 25; i++) {
            int taskNo = i;
            executor.execute(() -> {
                System.out.println("Executing Task " + taskNo + " in thread " + Thread.currentThread().getName());
                // 模拟任务执行时间
                ThreadUtil.sleep(2000);
            });
        }

        // 关闭线程池
        executor.shutdown();
        try {
            // 等待直到所有任务完成
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}