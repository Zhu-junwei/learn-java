package com.zjw._01.alive;

/**
 * 使用isAlive方法判断线程是否存活
 * @author 朱俊伟
 * @since 2023/02/19 10:37
 */
public class ThreadIsAlive extends Thread {

    public ThreadIsAlive() {
        System.out.println("构造方法……start");
        //Thread.currentThread() 当前方法被哪个对象调用
        System.out.println("Thread.currentThread().getName() =" + Thread.currentThread().getName());
        //this.getName() 当前对象的Name属性
        System.out.println("this.getName() =" + this.getName());
        System.out.println("构造方法……end");
    }

    @Override
    public void run() {
        System.out.println("run……start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Thread.currentThread() 当前方法被哪个对象调用
        System.out.println("Thread.currentThread().getName() =" + Thread.currentThread().getName());
        //this.getName() 当前对象的Name属性
        System.out.println("this.getName() =" + this.getName());
        System.out.println("run……end");
    }

    public static void main(String[] args) {
        ThreadIsAlive threadIsAlive = new ThreadIsAlive();
        Thread thread = new Thread(threadIsAlive, "A");
        thread.start();
        System.out.println("threadIsAlive isAlive = " + threadIsAlive.isAlive());
        System.out.println("thread isAlive = " + thread.isAlive());
    }
}
