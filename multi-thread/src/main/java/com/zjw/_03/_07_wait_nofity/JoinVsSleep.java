package com.zjw._03._07_wait_nofity;

/**
 * join 和 sleep 对比
 * join(long)方法和sleep(long)方法都是使当前线程等待一定时间,但是二者有较大区别:
 * 1. join(long)会等待被调用的线程结束,或者超过指定的毫秒数,以先达到的条件为准。sleep(long)只是简单地使当前线程睡眠指定毫秒数。
 *
 * @author 朱俊伟
 * @date 2023/04/16 10:55
 */
public class JoinVsSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join(1000);   //等待thread运行结束,或1000毫秒
        System.out.println("Main end");

        Thread.sleep(1000);   //主线程睡眠1000毫秒
        /*
         * 输出:
         * Main end
         * thread.join(1000)会等待thread运行结束或1000毫秒,这里thread运行了2000毫秒,所以join()等待结束返回。
         * 而Thread.sleep(1000)会直接睡眠1000毫秒,与thread的运行时间无关。
         */
    }
}
