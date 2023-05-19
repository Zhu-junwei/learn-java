package com.zjw._03._07_wait_nofity;

import lombok.SneakyThrows;

/**
 * InheritableThreadLocal类与ThreadLocal类类似,也是提供线程本地变量。但是不同的是,InheritableThreadLocal可以使线程的子线程访问父线程的值。
 * 主要使用方式:
 * 1. 在父线程中设置InheritableThreadLocal的值;
 * 2. 启动子线程;
 * 3. 子线程可以获取父线程设置的值。
 * 这样可以避免在子线程中重复设置相同的值,提高效率。
 * @author 朱俊伟
 * @date 2023/04/16 16:27
 */
public class InheritableThreadLocalExample {
    @SneakyThrows
    public static void main(String[] args) {
        // 创建InheritableThreadLocal对象
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        // 主线程设置值
        inheritableThreadLocal.set("father");

        // 启动子线程Thread-0
        new Thread(() -> {
            // Thread-0获取父线程的值
            System.out.println(Thread.currentThread().getName() + " " + inheritableThreadLocal.get());

            // Thread-0设置自己的值
            inheritableThreadLocal.set("son");

            // Thread-0启动子线程Thread-1
            new Thread(() -> {
                // Thread-1获取Thread-0设置的值
                System.out.println(Thread.currentThread().getName() + " " + inheritableThreadLocal.get());
            }).start();
        }).start();

        Thread.sleep(1000);

        //主线程获取值 子线程有最新值，父线程仍为旧值
        System.out.println(Thread.currentThread().getName() + " " + inheritableThreadLocal.get());

        /*
         * 输出:
         * Thread-0 father
         * Thread-1 son
         * main father
         * 子线程默认获取父线程的值,但是设置自己的值后,不会改变父线程的变量副本;
         * 各个线程操作的是自己的变量副本,对其他线程的变量副本没有任何影响。
         */
    }
}