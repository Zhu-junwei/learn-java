package com.zjw._05._01_timer;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Timer;

/**
 * @author 朱俊伟
 * @since 2023/04/30 10:29
 */

public class TimerTaskTest{

    /**
     * 通过TimerTask实现定时任务，1秒后打印系统时间
     */
    @Test
    public void testTimerTask() {
        System.out.println("testTimerTask start: " + DateUtil.now());
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 1000);
        //不加cancel timer不会停止，加了cancel有没有时间去执行
        timer.cancel();
    }

    /**
     * 让TimerTask实现定时任务，每隔1s执行一次
     */
    @Test
    public void testTimerTask2() {
        System.out.println("testTimerTask start: " + DateUtil.now());
        Timer timer = new Timer();
        for (int i = 0; i < 4; i++) {
            ThreadUtil.sleep(200);
            timer.schedule(new MyTimerTask("task" + i), new Date(),2000);
        }
        ThreadUtil.sleep(20000);
    }

    @Test
    public void testTimerOrder(){
        System.out.println("testTimerTask start: " + DateUtil.now());
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 10000);
        timer.schedule(new MyTimerTask(), 1000);
        //不加cancel timer不会停止，加了cancel又没有时间去执行
        ThreadUtil.sleep(15000);
//        timer.cancel();
    }
}


