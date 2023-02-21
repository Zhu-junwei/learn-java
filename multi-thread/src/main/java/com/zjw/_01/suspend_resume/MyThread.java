package com.zjw._01.suspend_resume;

/**
 * suspend和resume方法可以实现线程的暂停和恢复
 * 但是容易造成锁不释放和数据不完整，可以使用wait() notify() notifyAll()方法
 * @author 朱俊伟
 * @date 2023/02/21 21:59
 */
public class MyThread extends Thread {

    int count = 0;

    @Override
    public void run() {
        while (true) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        //启动线程让数字加一会儿
        thread.start();
        //主线程停1秒后让子线程跑一会儿
        Thread.sleep(1000);
        //暂停子线程看看到哪里了
        thread.suspend();
        System.out.println(System.currentTimeMillis()+":"+thread.count);
        //主线程停5秒后看数字有没有变化
        Thread.sleep(5000);
        System.out.println(System.currentTimeMillis()+":"+thread.count);
        //再启动子线程让数字接着跑
        thread.resume();
        //1秒后暂停子线程看看跑到哪里了
        Thread.sleep(1000);
        thread.suspend();
        System.out.println(System.currentTimeMillis()+":"+thread.count);
        //5秒后看看子线程还会不会跑
        Thread.sleep(5000);
        System.out.println(System.currentTimeMillis()+":"+thread.count);
        thread.stop();

    }
}
