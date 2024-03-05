package com.zjw._02._volatile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用AtomicInteger解决++操作的非原子性问题
 * @author 朱俊伟
 * @since 2023/03/03 0:06
 */
public class TestAtomicInteger2 {
    public static void main(String[] args) {
        List<MyThread2> thread2List = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            thread2List.add(new MyThread2());
        }
        thread2List.forEach(Thread::start);
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
