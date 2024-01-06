package com.zjw._01.stop;

/**
 * stop方法会抛出java.lang.ThreadDeath异常，但是不能通过Exception捕获
 *
 * @author 朱俊伟
 * @since 2023/02/19 23:33
 */
public class ThreadStop2 extends Thread {

    @Override
    public void run() {
        try {
            this.stop();
        } catch (ThreadDeath e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        ThreadStop2 thread = new ThreadStop2();
        thread.start();
    }
}
