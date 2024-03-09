package com.zjw._01.interrupt;

import cn.hutool.core.thread.ThreadUtil;

/**
 * 测试线程在获取不到锁时可被中断
 * <p>
 * 1. 重入锁
 * <p>
 * 2. 锁中断
 */
public class ThreadInterrupted4 {

    private static final Object obj = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            // 线程在获取不到锁的时候会一直阻塞在这里，不能被中断
            // 解决方法可以使用ReentrantLock，它可以在线程获取不到锁的时候进行中断
            synchronized (obj){
                try {
                    System.out.println("Thread 1 acquired the lock");
                    Thread.sleep(5000); // 模拟线程1持有锁的一些操作
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 got interrupted");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (obj){
                System.out.println("Thread 2 acquired the lock");
                ThreadUtil.sleep(5000); // 模拟线程1持有锁的一些操作
            }
        });

        thread2.start();
        thread1.start();

        // 主线程等待一段时间后中断线程1
        ThreadUtil.sleep(1000);
        thread1.interrupt();
    }
}