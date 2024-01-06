package com.zjw._01.interrupt;

/**
 * 让线程停下来
 *
 * @author 朱俊伟
 * @since 2023/02/19 23:33
 */
public class ThreadInterrupted2 extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                if (i == 2) {
                    Thread.currentThread().interrupt();
                    //虽然线程是停止状态，但是后面的代码并没有停止运行
                    //抛出异常，使线程停止
                    throw new InterruptedException();
                }
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().isInterrupted());
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+":我异常了");
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        ThreadInterrupted2 thread = new ThreadInterrupted2();
        thread.start();
    }
}
