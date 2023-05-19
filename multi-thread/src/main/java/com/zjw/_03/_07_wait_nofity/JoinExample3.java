package com.zjw._03._07_wait_nofity;

/**
 * join(long millis)方法使用
 * join(long millis)方法与join()方法类似,但是会有等待时间的限制。调用该方法的线程会一直等待被调用线程运行结束,或者等待指定的毫秒数,以先达到的条件为准。
 *
 * @author 朱俊伟
 * @date 2023/04/16 10:44
 */
public class JoinExample3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread1 end");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join(1000);   //thread2等待thread1运行结束,或者等待1000毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread2 end");
            }
        });
        thread1.start();
        thread2.start();
        /*
         * 输出:
         * Thread2 end
         * Thread1 end
         * thread2调用thread1.join(1000)方法,表示:
         * - 如果thread1在1000毫秒内运行结束,则thread2会继续运行;
         * - 如果1000毫秒内thread1依然没有运行结束,则thread2不再等待,直接继续运行。
         * 所以,在本例中thread1运行了2000毫秒,而thread2只等待了1000毫秒,就不再等待thread1而继续运行了。
         */
    }
}