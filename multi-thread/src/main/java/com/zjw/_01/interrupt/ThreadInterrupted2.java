package com.zjw._01.interrupt;

import cn.hutool.core.thread.ThreadUtil;

/**
 * 线程停止：interrupt方法停止线程
 * <p>
 * sleep wait join中的线程interrupt,会抛出Exception
 */
public class ThreadInterrupted2 extends Thread {

    @Override
    public void run() {

        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            } else {
                try {
//                    wait(5000);
                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()+":我异常了");
                }
            }
        }

    }

    public static void main(String[] args) {
        ThreadInterrupted2 thread = new ThreadInterrupted2();
        thread.start();
        ThreadUtil.sleep(3000);
        //sleep wait join中的线程interrupt,会抛出Exception
        /*
        sleep wait join中的线程interrupt,会抛出Exception
            sleep   InterruptedException
            wait    IllegalMonitorStateException
            join
         */
        thread.interrupt();
        System.out.println("thread.isInterrupted() = " + thread.isInterrupted()); // true
        System.out.println("thread.isInterrupted() = " + thread.isInterrupted()); // true
    }
}
