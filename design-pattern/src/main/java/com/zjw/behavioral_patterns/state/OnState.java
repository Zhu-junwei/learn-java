package com.zjw.behavioral_patterns.state;

/**
 * 开状态
 */
public class OnState implements LightState {
    @Override
    public void switchOn(Light light) {
        System.out.println("灯已经是开着的了");
    }

    @Override
    public void switchOff(Light light) {
        System.out.println("关灯");
        light.setState(new OffState()); // 切换到关状态
    }
}