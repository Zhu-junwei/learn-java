package com.zjw._04._01_reetrant_lock;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock使用
 * <p>
 * ReentrantLock 是 Java 的一个可重入锁实现，它比 synchronized 更灵活，并且提供了更高的性能和更多扩展功能。<p>
 * ReentrantLock 对象有两种模式：公平模式和非公平模式。公平模式指的是线程获取锁的顺序与它们发出请求的顺序是一致的，而非公平模式则没有这个要求。默认情况下，ReentrantLock 是非公平模式。<p>
 * ReentrantLock 常用方法：<p>
 * lock()：获取锁。如果锁已经被占用，则当前线程会被阻塞，直到锁被释放。<p>
 * unlock()：释放锁。<p>
 * tryLock()：尝试获取锁，如果锁是可用的，则获取锁并返回 true，否则返回 false。<p>
 * tryLock(timeout, unit)：在指定的时间内尝试获取锁，如果指定的时间内锁是可用的，则获取锁并返回 true，否则返回 false。<p>
 * newCondition()：返回一个与该锁有关的条件对象，用于线程之间的通信。<p>
 * 公平模式<p>
 * @author 朱俊伟
 * @since 2023/04/16 18:32
 */
public class ReentrantLock1 {

    @SneakyThrows
    public static void main(String[] args) {

        /*  公平模式
            如果传入 true，则为公平模式，传入 false 或者不传入参数，则为非公平模式
            公平模式会使线程按发出请求的先后顺序依次竞争，而非公平模式则不一定
         */
        ReentrantLock lock = new ReentrantLock(false);

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is trying to acquire the lock.");
                //获取锁
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired the lock.");
                    Thread.sleep(500);
                } catch (InterruptedException e){
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName() + " released the lock.");
                    //释放锁
                    lock.unlock();
                }
            }, "Thread" + i));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
    }

}
