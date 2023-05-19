package com.zjw._03._07_wait_nofity;

/**
 * 2. 多个子线程相互等待。多个线程可以调用对方的join()方法,实现线程间的同步等待。
 * @author 朱俊伟
 * @date 2023/04/16 0:18
 */
public class JoinExample2 {
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
                    thread1.join();  //thread2等待thread1运行结束
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 end");
            }
        });
        thread1.start();
        thread2.start();
    }
    /*
     * 输出:
     * Thread1 end
     * Thread2 end
     * thread2调用了thread1.join()方法,所以会一直等待thread1运行结束之后,才会继续运行并打印“Thread2 end”。
     * 所以,join()方法的作用就是实现线程间的同步等待,调用join()方法的线程会一直等待,直到被调用线程运行结束。
     */
}