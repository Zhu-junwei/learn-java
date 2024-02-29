package com.zjw._02._volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用AtomicInteger解决++操作的非原子性问题
 * @author 朱俊伟
 * @since 2023/03/03 0:06
 */
public class TestAtomicInteger2 {
    public static void main(String[] args) {
        MyThread2[] myThread2s = new MyThread2[100];
        for (int i = 0; i < myThread2s.length; i++) {
            myThread2s[i] = new MyThread2();
        }
        for (MyThread2 thread2 : myThread2s) {
            thread2.start();
        }

    }
}

class MyThread2 extends Thread{

    public static AtomicInteger count = new AtomicInteger(0);

    /**
     * 使用AtomicInteger解决++操作的非原子性问题
     */
    private static void addCount(){
        for (int i = 0; i < 100; i++) {
            count.getAndIncrement();
        }
        System.out.println("count=" + count.get());
    }

    @Override
    public void run() {
        addCount();
    }
}
