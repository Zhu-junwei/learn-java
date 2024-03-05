package com.zjw._01.interrupt;

import cn.hutool.core.thread.ThreadUtil;
import lombok.Setter;

/**
 *  线程停止：使用退出标识符使线程退出
 * @author 朱俊伟
 * @since 2024/03/05 15:19
 */
@Setter
public class ThreadStop implements Runnable{

    // 使用退出标识符使线程退出
    private volatile boolean stop = false;

    @Override
    public void run() {
        while (true){
            if (stop) {
                System.out.println(Thread.currentThread().getName() + "：我退出了。");
                return;
            } else {
                // 其他业务操作
            }
        }
    }

    public static void main(String[] args) {
        ThreadStop thread = new ThreadStop();
        new Thread(thread).start();
        ThreadUtil.sleep(3000);
        thread.setStop(true);
    }

}
