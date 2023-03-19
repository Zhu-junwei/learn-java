package com.zjw._03._03_wait_notifyAll;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

/**
 * notifyAll通知所有wait线程
 * @author 朱俊伟
 * @date 2023/03/18 19:27
 */
public class WaitNotifyAllTest {

    //等待线程个数
    int waitThreadNum = 10;
    //通知线程个数
    int notifyThreadNum = 5;
    //通知所有线程个数
    int notifyAllThreadNum = 1;
    //锁对象
    Object object = new Object();

    /**
     * 初始化10个等待线程
     */
    @SneakyThrows
    @Before
    public void initWaitThread(){
        for (int i = 0; i < waitThreadNum; i++) {
            WaitThread waitThread = new WaitThread(object);
            waitThread.start();
            Thread.sleep(1000);
        }

    }

    /**
     * 测试通知部分线程
     */
    @SneakyThrows
    @Test
    public void waitNotifyNotAll(){
        Thread.sleep(2000);
        System.out.println("######开始运行notify线程");
        for (int i = 0; i < notifyThreadNum; i++) {
            NotifyThread notifyThread = new NotifyThread(object);
            notifyThread.setName("notify-" + i);
            notifyThread.start();
            Thread.sleep(1000);
        }
        //防止Test方法退出
        Thread.sleep(15000);
    }

    /**
     * 测试通知所有等待线程
     * 需要注意的是，notifyAll会按照执行wait()方法的倒序依次对其他线程进行唤醒，要看JVM具体的实现
     */
    @SneakyThrows
    @Test
    public void waitNotifyAll(){
        Thread.sleep(2000);
        System.out.println("######开始运行notify线程");
        for (int i = 0; i < notifyAllThreadNum; i++) {
            NotifyAllThread notifyAllThread = new NotifyAllThread(object);
            notifyAllThread.setName("notifyAllThread-" + i);
            notifyAllThread.start();
            Thread.sleep(1000);
        }
        //防止Test方法退出
        Thread.sleep(15000);
    }
}

/**
 * 等待线程
 */
class WaitThread extends Thread {
    //锁对象
    Object object;

    public WaitThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                System.out.println("wait thread...start..." + Thread.currentThread().getName());
                //使当前线程等待
                object.wait();
                Thread.sleep(500);
                System.out.println("wait thread...end..." + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * 通知线程，通知等待的线程可以执行了
 */
class NotifyThread extends Thread {
    //锁对象
    Object object;

    public NotifyThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        //需要先获取对象的锁
        synchronized (object) {
            //通知可能等待该锁的其他线程继续执行
            object.notify();
            System.out.println("notify thread..." + Thread.currentThread().getName());
        }
    }
}

class NotifyAllThread extends Thread {
    //锁对象
    Object object;

    public NotifyAllThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        //需要先获取对象的锁
        synchronized (object) {
            //通知所有可能等待该锁的其他线程继续执行
            object.notifyAll();
            System.out.println("notify thread..." + Thread.currentThread().getName());
        }
    }
}