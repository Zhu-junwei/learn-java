package com.zjw._01;

import org.junit.Test;

/**
 * 线程的简单使用 2。
 * <p>
 * 实现多线程主要有两种方式：
 *  1. 通过继承Thread类，重写run方法实现多线程编程
 *  2. 实现Runnable接口
 * <p>
 * 本例通过方法二实现多线程
 * @author 朱俊伟
 * @date 2023/02/18 19:17
 */
public class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("线程中的方法执行了" + Thread.currentThread().getName());
    }


    /**
     * 运行实现Runnable接口的多线程类
     * 将实现类交给一个线程去执行
     */
    @Test
    public void testMyThread2(){
        Runnable runnable = new MyThread2();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
