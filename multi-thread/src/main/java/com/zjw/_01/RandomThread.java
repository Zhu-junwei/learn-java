package com.zjw._01;

/**
 * 线程的调用是随机的。
 *
 * 多线程的随机输出的原因是CPU将时间片分给不同的线程，线程获得时间片后就执行任务，一个线程在一个时间片内没有执行完毕，CPU接着将时间片分配给其他的线程去执行，表现为多线程随机（交替）执行。
 * @author 朱俊伟
 * @date 2023/02/18 18:36
 */
public class RandomThread extends Thread{

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 1000; i++) {
            System.out.println("RandomThread.run=" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread thread = new RandomThread();
        thread.setName("randomThread");
        //start方法系统异步执行，线程对象交给“线程规划器”。main方法中的循环和线程中的循环交替随机执行
        thread.start();
        //调用run方法相当于main主线程调用run方法，会同步执行，发现thread的name也是main,应该没有没人这样使用吧
//        thread.run();

        for (int i = 0; i < 1000; i++) {
            System.out.println("RandomThread.main=" + Thread.currentThread().getName());
        }
    }


}
