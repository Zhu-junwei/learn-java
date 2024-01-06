package com.zjw._03._07_wait_nofity;

/**
 * 用于测试DBTools类
 * @author 朱俊伟
 * @since 2023/04/15 23:55
 */
public class DBToolsTest {
    public static void main(String[] args) {
        // 创建DBTools实例
        DBTools dbTools = new DBTools();
        // 启动20组A、B备份线程
        for (int i = 0; i < 20; i++) {
            // 启动B备份线程
            BackupB output = new BackupB(dbTools);
            output.start();
            // 启动A备份线程
            BackupA input = new BackupA(dbTools);
            input.start();
        }
    }

}

// A备份线程类,执行backupA()方法
class BackupA extends Thread{

    private DBTools dbTools;

    public BackupA(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        super.run();
        // 执行backupA()方法
        dbTools.backupA();
    }
}

// B备份线程类,执行backupB()方法
class BackupB extends Thread{

    private DBTools dbTools;

    public BackupB(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        super.run();
        //执行backupB()方法
        dbTools.backupB();
    }
}