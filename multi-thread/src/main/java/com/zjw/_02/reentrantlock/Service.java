package com.zjw._02.reentrantlock;

/**
 * 可重入锁
 * 某个线程已经获得某个锁，可以再次获取锁而不会出现死锁
 * @author 朱俊伟
 * @date 2023/02/25 13:59
 */
public class Service {
    synchronized public void method1(){
        System.out.println("method1()");
        method2();
    }

    synchronized public void method2(){
        System.out.println("method2()");
        method3();
    }

    synchronized public void method3(){
        System.out.println("method3()");
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            Service service = new Service();
            service.method1();
        };
        Thread thread = new Thread(runnable);
        thread.start();
        //如果可重入锁，method1方法就不会调用到method2
    }
}
