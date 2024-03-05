package com.zjw._01.interrupt;

import cn.hutool.core.thread.ThreadUtil;

/**
 * 线程停止：interrupt方法停止线程
 * <p>
 *  说明：停止一个线程可以使用Thread.stop()方法，但不推荐使用此方法，这个方法是不安全的，而且是被弃用的。
 * isInterrupted方法判断线程是否已停止
 *
 * @author 朱俊伟
 * @since 2023/02/19 23:33
 */
public class ThreadInterrupted extends Thread {

    @Override
    public void run() {

        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            } else {
                // 其他业务操作
            }
        }

    }

    public static void main(String[] args) {
        ThreadInterrupted thread = new ThreadInterrupted();
        thread.start();
        ThreadUtil.sleep(3000);
        //sleep wait join中的线程interrupt,报错interruptedException
        thread.interrupt();
        System.out.println("thread.isInterrupted() = " + thread.isInterrupted()); // true
        System.out.println("thread.isInterrupted() = " + thread.isInterrupted()); // true
    }
}
