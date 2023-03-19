package com.zjw._03._02_wait_notify;

/**
 * 完整实现wait/notify机制
 * @author 朱俊伟
 * @date 2023/03/12 19:46
 */
public class WaitNotifyTest {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        WaitThread waitThread = new WaitThread(object);
        NotifyThread notifyThread = new NotifyThread(object);
        //wait线程一直等待
        waitThread.start();
        Thread.sleep(5000);
        //通知线程发出通知，wait线程继续执行
        notifyThread.start();
        /* 运行效果：
         * wait thread...start
         * notify thread...start
         * notify thread...end
         * wait thread...end
         */
    }
}

/**
 * 等待线程
 */
class WaitThread extends Thread {
    //锁对象
    Object object;

    public WaitThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                System.out.println("wait thread...start");
                //使当前线程等待
                object.wait();
                System.out.println("wait thread...end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * 通知线程，通知等待的线程可以执行了
 */
class NotifyThread extends Thread {
    //锁对象
    Object object;

    public NotifyThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        //需要先获取对象的锁
        synchronized (object) {
            System.out.println("notify thread...start");
            //通知可能等待该锁的其他线程继续执行
            object.notify();
            System.out.println("notify thread...end");
        }
    }
}
