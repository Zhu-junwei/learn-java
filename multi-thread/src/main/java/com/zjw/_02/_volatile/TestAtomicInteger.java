package com.zjw._02._volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 朱俊伟
 * @since 2023/03/03 0:06
 */
public class TestAtomicInteger {
    public static void main(String[] args) {

        List<MyThread> threadList = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            threadList.add(new MyThread());
        }
        threadList.forEach(Thread::start);

    }
}

class MyThread extends Thread{

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
