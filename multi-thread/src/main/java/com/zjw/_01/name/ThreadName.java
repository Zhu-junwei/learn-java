package com.zjw._01.name;

/**
 * 获取线程的名字
 * @author 朱俊伟
 * @since 2023/02/19 10:37
 */
public class ThreadName extends Thread {

    public ThreadName() {
        System.out.println("构造方法……start");
        //Thread.currentThread() 当前方法被哪个对象调用
        System.out.println("Thread.currentThread().getName() =" + Thread.currentThread().getName());//main
        //this.getName() 当前对象的Name属性
        System.out.println("this.getName() =" + this.getName());//Thread-0
        System.out.println("构造方法……end");
    }

    @Override
    public void run() {
        System.out.println("run……start");
        //Thread.currentThread() 当前方法被哪个对象调用
        System.out.println("Thread.currentThread().getName() =" + Thread.currentThread().getName());//Thread-0
        //this.getName() 当前对象的Name属性
        System.out.println("this.getName() =" + this.getName());//Thread-0
        System.out.println("run……end");
    }

    public static void main(String[] args) {
        ThreadName threadName = new ThreadName();
        threadName.start();
    }
}
