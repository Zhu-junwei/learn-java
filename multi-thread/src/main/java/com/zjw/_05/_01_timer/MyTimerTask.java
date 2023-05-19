package com.zjw._05._01_timer;

import com.zjw.date.DateTimeUtil;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 朱俊伟
 * @date 2023/04/30 10:29
 */
public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(DateTimeUtil.currentDateTime());
    }

    @Test
    public void testTimerTask() {
        System.out.println("testTimerTask start: " + DateTimeUtil.currentDateTime());
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 1000);
        //不加cancel timer不会停止，加了cancel有没有时间去执行
        timer.cancel();
    }

    @SneakyThrows
    @Test
    public void testTimerOrder(){
        System.out.println("testTimerTask start: " + DateTimeUtil.currentDateTime());
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 10000);
        timer.schedule(new MyTimerTask(), 1000);
        //不加cancel timer不会停止，加了cancel有没有时间去执行
        Thread.sleep(15000);
        timer.cancel();
    }
}
