package com.zjw._02.lockexception;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import lombok.AllArgsConstructor;

/**
 * @author 朱俊伟
 * @since 2023/02/25 16:29
 */
public class LockException {

    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + ",run beginTime=" + DateUtil.now());
            while (true) {
                if ((Math.random() + "").startsWith("0.123456")) {
                    ThreadUtil.sleep(5000);
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + ",exception beginTime=" + DateUtil.now());
                    throw new RuntimeException("我异常了");
                }
            }
        } else {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + ",run beginTime=" + DateUtil.now());
        }
    }
}

class TestMain {
    public static void main(String[] args){
        LockException lockException = new LockException();
        new Thread(new MyRunnable(lockException),"a").start();
        ThreadUtil.sleep(100);
        //线程A执行的时候出现异常释放锁，线程B接着执行
        new Thread(new MyRunnable(lockException),"b").start();
    }
}

@AllArgsConstructor
class MyRunnable implements Runnable {

    private final LockException lockException;

    @Override
    public void run() {
        lockException.testMethod();
    }
}