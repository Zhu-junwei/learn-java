package com.zjw.behavioral_patterns.state;

/**
 * 电灯类 - 上下文
 */
public class Light {
    private LightState state;

    public Light() {
        this.state = new OffState(); // 初始状态为关
    }

    public void setState(LightState state) {
        this.state = state;
    }

    public void switchOn() {
        state.switchOn(this);
    }

    public void switchOff() {
        state.switchOff(this);
    }
}