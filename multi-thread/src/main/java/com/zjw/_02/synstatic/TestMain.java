package com.zjw._02.synstatic;

/**
 * @author 朱俊伟
 * @date 2023/02/25 20:20
 */
public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThreadA = new MyThread();
        MyThread myThreadB = new MyThread();
        MyThread myThreadC = new MyThread(new Service());
        myThreadA.setName("a");
        myThreadB.setName("b");
        myThreadC.setName("c");
        myThreadA.start();
        myThreadB.start();
        myThreadC.start();

        /*
         * printA、printB方法之间是同步执行的
         * printA/printB方法和printC方法之间是异步执行的
         * 因为他们之间的锁不同。
         */
    }
}

class Service {

    synchronized public static void printA() {
        try {
            System.out.println("start printA(),ThreadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end printA(),ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * synchronized方法作用在static方法上相当于锁当前对象的Class对象
     */
    synchronized public static void printB() {
        try {
            System.out.println("start printB(),ThreadName=" + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end printB(),ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * synchronized 作用在非static方法上相当于锁this对象
     */
    synchronized public void printC() {
        try {
            System.out.println("start printC(),ThreadName=" + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end printC(),ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThread extends Thread{

    private Service service;
    public MyThread() {
    }

    public MyThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("a")){
            Service.printA();
        } else if (threadName.equals("b")){
            Service.printB();
        } else {
            service.printC();
        }
    }
}