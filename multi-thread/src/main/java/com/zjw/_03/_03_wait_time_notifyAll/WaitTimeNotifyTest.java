package com.zjw._03._03_wait_time_notifyAll;

import com.zjw.date.DateTimeUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * wait(long)方法，使线程等待指定的时间长度
 *
 * @author 朱俊伟
 * @date 2023/03/18 19:27
 */
public class WaitTimeNotifyTest {

    /**
     * 测试通知部分线程
     */
    @SneakyThrows
    @Test
    public void waitTimeNotify() {
        //等待线程个数
        int waitThreadNum = 10;
        //锁对象
        Object object = new Object();

        for (int i = 0; i < waitThreadNum; i++) {
            WaitThread waitThread = new WaitThread(object);
            waitThread.start();
            Thread.sleep(500);
        }
        //防止Test方法退出
        Thread.sleep(15000);
    }

}

/**
 * 等待指定之间的线程
 */
@AllArgsConstructor
class WaitThread extends Thread {

    /**
     * 锁对象
     */
    final Object object;

    @Override
    public void run() {
        synchronized (object) {
            try {
                System.out.println(DateTimeUtils.timestampToDateTime(System.currentTimeMillis()) + " wait thread...start..." + Thread.currentThread().getName() + "...");
                //使当前线程等待10S，10S后如果有锁就继续往下执行
                //如果不能获得锁，则会继续等待
                object.wait(10000);
                System.out.println(DateTimeUtils.timestampToDateTime(System.currentTimeMillis()) + " wait thread...end..." + Thread.currentThread().getName() + "...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}