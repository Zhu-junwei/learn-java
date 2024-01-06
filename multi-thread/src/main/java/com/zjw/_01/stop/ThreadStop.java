package com.zjw._01.stop;

/**
 * stop方法强行终止线程，是不被采用的方法，原因是stop方法容易造成业务处理的不确定性
 *
 * @author 朱俊伟
 * @since 2023/02/19 23:33
 */
public class ThreadStop extends Thread {

    int i = 1;

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + i++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStop thread = new ThreadStop();
        thread.start();
        Thread.sleep(5000);
        //stop方法废弃，不被采用
        thread.stop();
    }
}
