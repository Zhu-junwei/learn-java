package com.zjw;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.util.FormatUtil;

import java.util.List;

/**
 * 内存使用情况
 * @author 朱俊伟
 * @since 2024/12/04 10:20
 */
public class MemoryTest {
    public static void main(String[] args) {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hardware = si.getHardware();
        GlobalMemory memory = hardware.getMemory();
        System.out.println("memory = " + memory);

        // 已使用/总量
        long available = memory.getAvailable();
        long total = memory.getTotal();
        System.out.println("Available: " + available + " Total: " + total);
        String formatAvailable = FormatUtil.formatBytes(available);
        String formatTotal = FormatUtil.formatBytes(total);
        System.out.println("Format Available: " + formatAvailable + " Total: " + formatTotal);

        // 页大小
        System.out.println("memory.getPageSize() = " + FormatUtil.formatBytes(memory.getPageSize()));

        // 物理内存
        List<PhysicalMemory> pmList = memory.getPhysicalMemory();
        if (!pmList.isEmpty()) {
            for (PhysicalMemory pm : pmList) {
                System.out.println(pm);
                System.out.println("pm.getCapacity() = " + FormatUtil.formatBytes(pm.getCapacity()));
                System.out.println("pm.getMemoryType() = " + pm.getMemoryType());
                System.out.println("pm.getBankLabel() = " + pm.getBankLabel());
                System.out.println("pm.getManufacturer() = " + pm.getManufacturer());
                System.out.println("pm.getClockSpeed() = " + FormatUtil.formatHertz(pm.getClockSpeed()));
                System.out.println("pm.getPartNumber() = " + pm.getPartNumber());
                System.out.println("pm.getSerialNumber() = " + pm.getSerialNumber());
            }
        }
    }
}
