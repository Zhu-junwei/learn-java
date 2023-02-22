package com.zjw._01.interrupt;

/**
 * interrupt方法停止线程
 *  说明：停止一个线程可以使用Thread.stop()方法，但不推荐使用此方法，这个方法是不安全的，而且是被弃用的。
 * isInterrupted方法判断线程是否已停止
 * @author 朱俊伟
 * @date 2023/02/19 23:33
 */
public class ThreadInterrupted extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i == 2){
                Thread.currentThread().interrupt();
                //虽然线程是停止状态，但是后面的代码并没有停止运行
            }
            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isInterrupted());
        }

    }

    public static void main(String[] args) {
        ThreadInterrupted thread = new ThreadInterrupted();
        thread.start();
        //sleep中的线程不能interrupt,报错sleep interrupted
//        thread.interrupt();
        //Thread.interrupted判断的是当前线程（这里是main）是否停止
        System.out.println("Thread.interrupted():" + Thread.interrupted());//false
        //停止主线程
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isInterrupted());
        /*
         * 测试当前线程是否已经中断。线程的中断状态由该方法清除。
         * 换句话说，如果连续两次调用该方法，则第二次调用将返回 false
         * (在第一次调用已清除了其中断状态之后，且第二次调用检验完中断状态前，当前线程再次中断的情况除外)。
         * 这个方法根据没有必要使用。最好使用Thread.currentThread().isInterrupted()代替
         */
        System.out.println("Thread.interrupted():" + Thread.interrupted());//false
        System.out.println("Thread.interrupted():" + Thread.interrupted());//true
    }
}
