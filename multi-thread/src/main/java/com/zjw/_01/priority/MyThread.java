package com.zjw._01.priority;

import lombok.Getter;

import java.util.Random;

/**
 * setPriority方法设置线程的优先级 1~10 ，1最低，10最高
 *
 * @author 朱俊伟
 * @date 2023/02/21 23:17
 */
@Getter
public class MyThread extends Thread {
    private long count = 0;

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            random.nextInt();
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread threadA = new MyThread();
        MyThread threadB = new MyThread();
        threadA.setPriority(Thread.MAX_PRIORITY);
        threadB.setPriority(Thread.MIN_PRIORITY);
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadA.stop();
        threadB.stop();
        System.out.println("线程A循环次数：" + threadA.getCount());
        System.out.println("线程B循环次数：" + threadB.getCount());
        /*
         * 线程A循环次数：7341454
         * 线程B循环次数：7312004
         * 好像差别不大
         */


    }
}
