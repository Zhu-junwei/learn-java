package com.zjw._02.synstatic;

/**
 * @author 朱俊伟
 * @date 2023/02/28 22:09
 */
public class TestSyncString {
    public static void main(String[] args) {
        MyThread2 myThreadA = new MyThread2();
        MyThread2 myThreadB = new MyThread2();
        //发现只用线程A被执行了，因为锁name是同一个对象
        myThreadA.start();
        myThreadB.start();
    }
}

class MyService2 {
    public static void print(String name) {
        try {
            //同步String变量
            synchronized (name) {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + ":" +name);
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThread2 extends Thread{

    @Override
    public void run() {
        super.run();
        MyService2.print("AA");
    }
}
