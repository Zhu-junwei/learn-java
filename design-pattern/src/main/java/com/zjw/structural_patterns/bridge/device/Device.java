package com.zjw.structural_patterns.bridge.device;

/**
 * 所有设备的通用接口（实现部分接口）
 */
public interface Device {
    /**
     * 是否启用
     */
    boolean isEnabled();

    /**
     * 启用
     */
    void enable();

    /**
     * 禁用
     */
    void disable();

    /**
     * 获取音量
     */
    int getVolume();

    /**
     * 设置音量
     */
    void setVolume(int percent);

    /**
     * 获取频道
     */
    int getChannel();

    /**
     * 设置频道
     */
    void setChannel(int channel);

    /**
     * 打印设备状态
     */
    void printStatus();
}