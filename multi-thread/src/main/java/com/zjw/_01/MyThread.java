package com.zjw._01;

/**
 * 线程的简单使用。
 * <p>
 * 实现多线程主要有两种方式：
 *  1. 通过继承Thread类，重写run方法实现多线程编程
 *  2. 实现Runnable接口
 * <p>
 * 本例通过方法一实现多线程
 * @author 朱俊伟
 * @date  2023/02/18 15:52
 */
public class MyThread extends Thread{

    public static void main(String[] args) {
        Thread thread = new MyThread();
        //通过运行start方法运行线程，将会自动调用run的方法
        thread.start();
        //由于创建线程耗时大，所以下行打印语句大概率先被执行
        System.out.println("end!");
    }

    /**
     * 重写Thread类中的run方法
     */
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
