package com.zjw._03;

/**
 * wait() 使当前线程暂停运行，并释放锁
 * @author 朱俊伟
 * @date 2023/03/12 18:50
 */
public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        String str = new String("hello world");
        System.out.println("main...start");
        synchronized (str){
            System.out.println("sync...start");
            //不是当前线程wait,是锁对象调用wait方法
//            Thread.currentThread().wait();
            /*
             * 发现线程一直卡在这里等待，需要使用notify()方法结束这种状态
             */
            str.wait();
            System.out.println("sync...end");
        }
        System.out.println("main...end");
    }
}
