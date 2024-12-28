package com.zjw;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 * @author 朱俊伟
 * @since 2024/06/30 03:10
 */
public class Info {
    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        CentralProcessor cpu = hal.getProcessor();
        System.out.println(cpu);
        OperatingSystem os = si.getOperatingSystem();
        System.out.println("os.toString() = " + os.toString());

    }
}
