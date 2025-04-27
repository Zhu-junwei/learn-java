package com.zjw.behavioral_patterns.state;

/**
 * 测试类
 */
public class Demo {
    public static void main(String[] args) {
        Light light = new Light();
        
        light.switchOn();  // 开灯
        light.switchOff(); // 关灯
        light.switchOff(); // 已经是关着的
        light.switchOn();  // 开灯
        light.switchOn();  // 已经是开着的
    }
}