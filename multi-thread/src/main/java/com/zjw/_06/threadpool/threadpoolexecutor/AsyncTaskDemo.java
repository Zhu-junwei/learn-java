package com.zjw._06.threadpool.threadpoolexecutor;

import java.util.concurrent.*;

/**
 * 3. 使用Future获取线程的执行状态
 */
public class AsyncTaskDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 创建一个单线程的线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 提交任务到线程池，并得到 Future 对象
        Future<String> futureTask = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                // 模拟任务执行时间
                TimeUnit.SECONDS.sleep(5);
                return "任务完成";
            }
        });

        // 在等待任务完成的同时，可以做一些其他事情
        System.out.println("等待任务完成，同时可以做一些其他事情...");
        // 模拟做其他事情的时间
        TimeUnit.SECONDS.sleep(2);
        System.out.println("做了一些其他事情...");

        // 取消任务
        // futureTask.cancel(true); // 如果需要取消任务，取消注释这行

        // 获取任务执行状态
        if (!futureTask.isCancelled()) {
            System.out.println("任务是否完成: " + futureTask.isDone());

            // 获取任务的结果，如果任务还没有完成，这个方法会阻塞直到任务完成
            String result = futureTask.get();
            System.out.println("任务的结果: " + result);
        } else {
            System.out.println("任务已被取消");
        }

        // 关闭线程池
        executor.shutdown();
    }
}