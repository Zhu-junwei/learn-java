package com.zjw.structural_patterns.bridge.remote;

import com.zjw.structural_patterns.bridge.device.Device;

/**
 * 高级远程控制器
 */
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    /**
     * 静音
     */
    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}