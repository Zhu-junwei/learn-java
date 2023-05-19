package com.zjw._03._07_wait_nofity;

/**
 * 数据库备份工具类
 * @author 朱俊伟
 * @date 2023/04/15 23:46
 */
public class DBTools {
    // 用于标记当前执行的是A还是B备份方法
    volatile private boolean prevIsA = false;

    // A备份方法
    synchronized public void backupA(){
        try {
            // 如果prevIsA为true,表示当前正在执行B备份,则等待
            while (prevIsA){
                wait();
            }
            // 执行A备份
            for (int i = 0; i < 5; i++) {
                System.out.println("◈◈◈◈◈");
            }
            // 将标记设置为false,表示A备份结束
            prevIsA = true;
            // 唤醒其他等待的线程,开始执行B备份
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // B备份方法
    synchronized public void backupB(){
        try {
            // 如果prevIsA为false,表示当前正在执行A备份,则等待
            while (!prevIsA){
                wait();
            }
            // 执行B备份
            for (int i = 0; i < 5; i++) {
                System.out.println("◇◇◇◇◇");
            }
            // 将标记设置为true,表示B备份结束
            prevIsA = false;
            // 唤醒其他等待的线程,开始执行A备份
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}