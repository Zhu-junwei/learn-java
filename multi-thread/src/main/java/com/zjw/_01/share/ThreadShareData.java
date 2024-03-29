package com.zjw._01.share;

/**
 * 线程间共享数据
 *
 * @author 朱俊伟
 * @since 2023/02/18 23:34
 */
public class ThreadShareData extends Thread {

    int count = 5;

    public ThreadShareData(String name) {
        this.setName(name);
    }

    /**
     * 使用synchronized关键字是让多个线程在执行run方法的时候排队处理，解决 “非线程安全问题”
     * synchronized可以对任意对象及方法加锁，加锁的代码称为 “互斥区” 或 “临界区”
     */
    @Override
    synchronized public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "=" + count);
    }

    public static void main(String[] args) {
        //共享数据
        Thread myThread = new ThreadShareData("myThread");
        Thread threadA = new Thread(myThread, "A");
        Thread threadB = new Thread(myThread, "B");
        Thread threadC = new Thread(myThread, "C");
        Thread threadD = new Thread(myThread, "D");
        Thread threadE = new Thread(myThread, "E");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
    }
}
