package com.zjw._02._volatile;

import lombok.Data;

/**
 * 多线程造成死锁及解决方法
 * @author zjw
 * @date 2023/03/02 13:20
 */
public class TestMultiThreadDeadLock {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        Thread cantStopThread = new Thread(runnable);
        Thread canStopThread = new Thread(runnable);
        cantStopThread.setName("cantStop");
        canStopThread.setName("canStop");
        cantStopThread.start();
        canStopThread.start();
        Thread.sleep(1000);
        //run变量虽然设置为了false，但是runnable的cantStop方法依然没有停止
        //造成这种情况是因为run、volatileRun同时存在于线程堆栈和公共堆栈中
        //runnable.setRun(false)只是改变了公共堆栈中的值，并没有改变线程堆栈的值，cantStop方法的while判断的是线程堆栈的值
        //canStop方法因为volatileRun使用了volatile修饰，强制从公共堆栈取值
        runnable.setRun(false);
        runnable.setVolatileRun(false);
        System.out.println("我设置了false");
    }
}

@Data
class MyRunnable implements Runnable {

    private boolean run = true;

    //多了个volatile关键字,取值从主内存取
    volatile private boolean volatileRun = true;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if ("cantStop".equals(name)){
            cantStop();
        }else if ("canStop".equals(name)){
            canStop();
        }
    }

    public void cantStop(){
        System.out.println("cantStop()....start");
        //run变量从线程内存获取
        while (run){}
        System.out.println("cantStop()....end");
    }

    public void canStop(){
        System.out.println("canStop()....start");
        //volatileRun变量从主内存获取
        while (volatileRun){}
        System.out.println("canStop()....end");
    }
}

