package com.zjw._04._01_reetrant_lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 是 ReentrantLock 提供的一个高级线程同步工具，它提供了类似于 Object.wait() 和 Object.notify() 组合的等待通知机制，但比 wait() 和 notify() 更加灵活、安全和高效。一般情况下，我们可以将一个 Lock 对象配合多个 Condition 对象来实现精确唤醒线程的目的。
 * <p>
 * Condition 接口提供了三个基本的方法：
 * <p>
 * await()：让当前线程等待，同时释放锁，直到其他线程调用 signal() 或者 signalAll() 唤醒当前线程。<p>
 * signal()：唤醒其中一个等待的线程，通常选择等待时间最长的。<p>
 * signalAll()：唤醒所有等待的线程。<p>
 */
public class ConditionDemo {
    // 定义缓冲区大小
    private static final int CAPACITY = 1000;
    // 定义缓冲区队列
    private final Queue<Integer> queue = new LinkedList<>();
    // 随机数生成器
    private final Random random = new Random();
    // 锁对象
    private final ReentrantLock lock = new ReentrantLock();
    // 缓冲区不满条件对象
    private final Condition isFull = lock.newCondition();
    // 缓冲区不空条件对象
    private final Condition isEmpty = lock.newCondition();
    //生产总数量
    public static int totalCount = 0;

    public static void main(String[] args) {
        // 初始化消费者的数量为3
        int numOfConsumers = 3;
        // 创建ConditionDemo对象
        ConditionDemo demo = new ConditionDemo();
        // 启动生产者线程

        for (int i = 0; i <= 1; i++) {
            new Thread(demo.new Producer()).start();
        }
        // 启动消费者线程
        for (int i = 1; i <= numOfConsumers; i++) {
            new Thread(demo.new Consumer(i)).start();
        }
    }

    /*
     * 生产者线程
     */
    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    // 生产者线程随机休眠一段时间
                    int sleepTime = (int)(Math.random()*500);
                    Thread.sleep(sleepTime);
                    // 获取锁
                    lock.lock();
                    try {
                        // 当缓冲区已满时，生产者线程等待
                        while (queue.size() == CAPACITY) {
                            System.out.println("缓冲区已满，生产者线程等待消费者线程取出数据");
                            isFull.await();
                        }
                        // 生产数据
                        int num = random.nextInt();
                        // 将生产的数据放入缓冲区
                        queue.offer(num);
                        totalCount++;
                        System.out.println("生产者线程生产数据：" + num + ",共生产：" + totalCount);
                        // 获取等待 isEmpty 条件的线程数
                        System.out.println("等待 isEmpty 条件的线程数：" + lock.getWaitQueueLength(isEmpty));
                        // 唤醒等待缓冲区不空条件的线程
                        isEmpty.signalAll();
                    } finally {
                        // 释放锁
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 消费者线程
     */
    class Consumer implements Runnable {
        private int id; // 消费者编号

        public Consumer(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    // 消费者线程随机休眠一段时间
                    Thread.sleep(500);
                    // 获取锁
                    lock.lock();
                    try {
                        // 当缓冲区为空时，消费者线程等待
                        while (queue.isEmpty()) {
//                            System.out.println("缓冲区为空，消费者" + id + "等待生产者线程生产数据");
                            isEmpty.await();
                        }
                        // 从缓冲区取出数据
                        int num = queue.poll();
                        System.out.println("消费者" + id + "消费数据：" + num);
                        // 获取等待 isFull条件的线程数
                        System.out.println("等待 isFull 条件的线程数：" + lock.getWaitQueueLength(isFull));
                        // 唤醒等待缓冲区不满条件的线程
                        isFull.signalAll();
                    } finally {
                        // 释放锁
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
