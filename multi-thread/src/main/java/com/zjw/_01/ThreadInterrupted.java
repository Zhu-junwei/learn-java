package com.zjw._01;

/**
 * interrupt方法停止线程
 * isInterrupted方法判断线程是否已停止
 * @author 朱俊伟
 * @date 2023/02/19 23:33
 */
public class ThreadInterrupted extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i == 2){
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isInterrupted());
        }

    }

    public static void main(String[] args) {
        ThreadInterrupted thread = new ThreadInterrupted();
        thread.start();
        //sleep中的线程不能interrupt,报错sleep interrupted
//        thread.interrupt();
        //停止主线程
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isInterrupted());
    }
}
