package com.zjw.behavioral_patterns.command.demo2.receiver;

/**
 * Receiver：执行命令的真正操作对象。
 */
public class Light {
    public void turnOn() {
        System.out.println("The light is ON");
    }

    public void turnOff() {
        System.out.println("The light is OFF");
    }
}
