package com.zjw.behavioral_patterns.command.demo2.receiver;

/**
 * Receiver：执行命令的真正操作对象。
 */
public class Door {
    public void open() {
        System.out.println("The Door is open");
    }

    public void close() {
        System.out.println("The Door is close");
    }
}
