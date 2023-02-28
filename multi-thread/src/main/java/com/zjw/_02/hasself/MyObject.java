package com.zjw._02.hasself;

/**
 * @author 朱俊伟
 * @date 2023/02/25 0:20
 */
public class MyObject {
    //同步方法，同一个对象访问此方法时同步执行
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("methodA end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //异步方法，同一个对象访问时可以异步执行
    public void methodB() {
        System.out.println("begin methodB threadName=" + Thread.currentThread().getName());
        System.out.println("methodB end");

    }

    public static void main(String[] args) throws InterruptedException {
        MyObject object = new MyObject();
        MyThreadObject threadObjectA = new MyThreadObject(object);
        MyThreadObject threadObjectB = new MyThreadObject(object);
        threadObjectA.setName("a");
        threadObjectB.setName("b");
        threadObjectA.start();
        Thread.sleep(2000);
        threadObjectB.start();
        /*
         * a线程先持有object对象的Lock锁，b线程可以以异步的方法调用object对象中的非synchronized类型的方法
         */
    }
}

class MyThreadObject extends Thread {

    private final MyObject object;

    public MyThreadObject(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        if (Thread.currentThread().getName().equals("a")) {
            object.methodA();
        } else {
            object.methodB();
        }
    }
}