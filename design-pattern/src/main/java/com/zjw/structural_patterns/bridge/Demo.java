package com.zjw.structural_patterns.bridge;

import com.zjw.structural_patterns.bridge.device.Device;
import com.zjw.structural_patterns.bridge.device.Radio;
import com.zjw.structural_patterns.bridge.device.Tv;
import com.zjw.structural_patterns.bridge.remote.AdvancedRemote;
import com.zjw.structural_patterns.bridge.remote.BasicRemote;

/**
 * 客户端代码
 */
public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}