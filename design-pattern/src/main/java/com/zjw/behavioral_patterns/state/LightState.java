package com.zjw.behavioral_patterns.state;

/**
 * 电灯状态接口
 */
public interface LightState {
    void switchOn(Light light);
    void switchOff(Light light);
}