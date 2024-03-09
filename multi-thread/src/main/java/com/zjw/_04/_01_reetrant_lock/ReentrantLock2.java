package com.zjw._04._01_reetrant_lock;

import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试线程在获取不到锁时可被中断
 * <p>
 * 1. 重入锁
 * <p>
 * 2. 锁中断
 */
public class ReentrantLock2 {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                lock.lockInterruptibly(); // 线程1尝试获取锁，可被中断
                System.out.println("Thread 1 acquired the lock");
                Thread.sleep(5000); // 模拟线程1持有锁的一些操作
            } catch (InterruptedException e) {
                System.out.println("Thread 1 got interrupted");
            } finally {
                // 如何线程在获取到锁的情况下，需要释放锁
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                lock.lock(); // 线程2获取锁
                System.out.println("Thread 2 acquired the lock");
                ThreadUtil.sleep(3000);
            } finally {
                lock.unlock();
            }
        });

        thread2.start();
        thread1.start();

        // 主线程等待一段时间后中断线程1
        ThreadUtil.sleep(1000);
        thread1.interrupt();
    }
}