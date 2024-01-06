package com.zjw._01.daemon;

/**
 * 守护线程
 *
 * @author 朱俊伟
 * @since 2023/02/21 23:31
 */
public class ThreadDaemon extends Thread {

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDaemon threadDaemon = new ThreadDaemon();
        //设置为守护线程，要在线程启动先设置
        threadDaemon.setDaemon(true);
        threadDaemon.start();
        Thread.sleep(5000);
        //用户线程(非守护线程)退出后，守护线程也就停止了工作。
    }
}

