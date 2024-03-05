package com.zjw._01.create;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程的简单使用 3
 * <p>
 * 实现Callable接口，可以拿到线程的执行结果
 * @author 朱俊伟
 * @since 2024/03/05 13:44
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("call()....");
        ThreadUtil.sleep(5000);
        return "hello";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("futureTask.get() = " + futureTask.get());
    }
}
