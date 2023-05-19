package com.zjw._03._07_wait_nofity;

/**
 * join()方法的作用是等待该线程终止。调用join()方法的线程会一直等待,直到被调用的线程运行结束为止。
 * 主要有两种使用join()方法的场景:
 * 1. 主线程等待子线程结束。主线程可以调用子线程的join()方法,等待子线程运行结束之后再继续运行。
 *
 * @author 朱俊伟
 * @date 2023/04/16 0:15
 */
public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Child thread start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Child thread end");
            }
        });
        thread.start();
        thread.join();  //主线程调用子线程的join()方法,等待其运行结束
        System.out.println("Main thread end");
        /*
         * 输出:
         * Child thread start
         * Child thread end
         * Main thread end
         * 可以看到,主线程调用了thread.join()方法,等待thread子线程运行结束之后,才会继续运行并打印“Main thread end”。
         */
    }
}