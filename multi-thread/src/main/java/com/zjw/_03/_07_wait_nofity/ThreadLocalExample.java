package com.zjw._03._07_wait_nofity;

/**
 * ThreadLocal类提供线程本地变量,它可以在每个线程中单独存储值,不同线程中的值互不影响。也就是说每个线程的ThreadLocal变量都有一个
 * 独立的副本,互不影响。这主要用于指定线程的数据存储,解决多线程程序中的线程干扰问题。
 * 主要特征:
 * 1. 每个线程都有自己的私有变量副本,互不干扰。
 * 2. 可以在线程中的任何位置获取或设置该线程的副本变量。
 * 3. 适合在多线程环境下共享对象,同时又不想被其他线程修改数据。
 * 常用方法:
 * - ThreadLocal():构造方法。
 * - T get():获得当前线程的变量副本值。
 * - void set(T value):设置当前线程的变量副本值。
 * - void remove():移除当前线程的变量副本值。
 *
 * @author 朱俊伟
 * @date 2023/04/16 16:11
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        new Thread(() -> {
            threadLocal.set("thread1");
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
        }).start();

        new Thread(() -> {
            threadLocal.set("thread2");
            System.out.println(Thread.currentThread().getName() + " " + threadLocal.get());
        }).start();
    }
    /*
     * 输出:
     * Thread-0 thread1
     * Thread-1 thread2
     * 可以看到,虽然两个线程操作的是同一个ThreadLocal变量,但是由于每个线程有自己的变量副本,所以各自设置和获取到的值互不干扰,不受其他线程的值的影响。
     * ThreadLocal适用于将对象与线程绑定在一起,每个线程可以访问自己的对象副本,并且各个线程之间的副本相互隔离。这较好地解决了多线程数据隔离的问题。
     */
}