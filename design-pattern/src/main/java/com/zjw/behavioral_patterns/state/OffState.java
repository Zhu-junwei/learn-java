package com.zjw.behavioral_patterns.state;

/**
 * 关状态
 */
public class OffState implements LightState {
    @Override
    public void switchOn(Light light) {
        System.out.println("开灯");
        light.setState(new OnState()); // 切换到开状态
    }

    @Override
    public void switchOff(Light light) {
        System.out.println("灯已经是关着的了");
    }
}