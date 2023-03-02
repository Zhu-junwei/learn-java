package com.zjw._02._volatile;

import lombok.Data;

/**
 * 多线程造成死锁
 * @author zjw
 * @date 2023/03/02 13:20
 */
public class MultiThreadDeadLock {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        //虽然设置为了false，但是runnable的run方法依然没有停止
        //造成这种情况是因为isRunning同时存在于线程堆栈和公共堆栈中
        //runnable.setRunning(false)只是改变了公共堆栈中的值，并没有改变线程堆栈的值，run方法的while判断的是线程堆栈的值
        runnable.setRunning(false);
        System.out.println("我设置了false");
    }
}

@Data
class MyRunnable implements Runnable {

    private boolean isRunning = true;

    @Override
    public void run() {
        System.out.println("run()....start");
        while (isRunning){}
        System.out.println("run()...end");
    }
}

