package com.zjw._03._07_wait_nofity;

/**
 * join 和 sleep 对比
 * 2. join()可以相互调用,实现线程同步,sleep()不能。
 * @author 朱俊伟
 * @date 2023/04/16 10:57
 */
public class JoinVsSleep2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 end");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();   //thread2等待thread1结束
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 end");
            }
        });
        thread1.start();
        thread2.start();
        /*
         * 输出:
         * Thread1 end
         * Thread2 end
         * thread2调用thread1.join()方法等待thread1运行结束,实现线程同步。
         * 如果thread2调用thread1.sleep(1000),是行不通的,sleep()不能用于线程间同步。
         */

        /*
         * 所以,join()和sleep()的主要区别在于:
         * 1. join()会等待被调用线程结束,sleep()简单使线程睡眠。
         * 2. join()可以用于线程间同步,sleep()不能。
         */
    }
}