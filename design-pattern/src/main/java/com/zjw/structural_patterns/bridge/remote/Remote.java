package com.zjw.structural_patterns.bridge.remote;

/**
 * 所有远程控制器的通用接口
 */
public interface Remote {

    /**
     * 电源开关
     */
    void power();

    /**
     * 音量下调
     */
    void volumeDown();

    /**
     * 音量上调
     */
    void volumeUp();

    /**
     * 频道上调
     */
    void channelDown();

    /**
     * 频道下调
     */
    void channelUp();
}