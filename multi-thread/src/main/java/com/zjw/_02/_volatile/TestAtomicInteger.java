package com.zjw._02._volatile;

/**
 * @author 朱俊伟
 * @since 2023/03/03 0:06
 */
public class TestAtomicInteger {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
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

    volatile public static int count;

    /**
     * 不加synchronized，结果不是10000，count++操作不是原子性的
     */
    synchronized private static void addCount(){
        for (int i = 0; i < 100; i++) {
            count ++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}
