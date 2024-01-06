package com.zjw._01.yield;

/**
 * yield方法的作用是放弃当前CPU资源，让其他任务去占用，放弃的时间不确定，有可能刚刚放弃，马上又获取CPU时间片
 * @author 朱俊伟
 * @since 2023/02/21 22:53
 */
public class MyThread extends Thread {
    boolean yield;

    public MyThread(boolean yield) {
        this.yield = yield;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 500000; i++) {
            if (yield) {
                Thread.yield();
            }
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("yield=" + yield + ",耗时:" + (endTime - startTime) + "ms");
        /*
         *yield=false,耗时:8ms
         *yield=true,耗时:470ms
         * 可以看到放弃CPU时间片后执行的时间变长了
         */
    }

    public static void main(String[] args) {
        MyThread threadA = new MyThread(true);
        threadA.start();
        MyThread threadB = new MyThread(false);
        threadB.start();
    }
}
