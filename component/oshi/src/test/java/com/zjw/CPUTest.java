package com.zjw;

/**
 * CPU使用情况
 *
 * @author 朱俊伟
 * @since 2024/12/04 11:00
 */
public class CPUTest {
    public static void main(String[] args) {
//        SystemInfo si = new SystemInfo();
//        HardwareAbstractionLayer hai = si.getHardware();
//        CentralProcessor processor = hai.getProcessor();
//        System.out.println("processor = " + processor);
//        System.out.println("****************************************");
//        // CPU包（处理器）。一些高端系统可能会有多个物理CPU包（例如双CPU系统）。
//        System.out.println("processor.getPhysicalPackageCount() = " + processor.getPhysicalPackageCount());
//        // 物理核心
//        System.out.println("processor.getPhysicalProcessorCount() = " + processor.getPhysicalProcessorCount());
//        // 逻辑核心
//        System.out.println("processor.getLogicalProcessorCount() = " + processor.getLogicalProcessorCount());
//        // 计算 CPU 使用率
//        for (int i = 0; i < 10; i++) {
//            long[] prevTicks = processor.getSystemCpuLoadTicks();  // 获取当前 CPU 时间戳
//            // 等待一定时间后再获取 CPU 使用率，可以根据需要调整等待时间
//            Util.sleep(1000);  // 等待 1 秒，确保能有时间差来计算负载变化
//            processor.getSystemCpuLoadTicks();  // 获取 1 秒后的 CPU 时间戳
//            double cpuLoad = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100;  // 计算负载变化
//            System.out.printf("CPU load: %.1f%%\n", cpuLoad);  // 输出 CPU 使用率
//        }
    }
}
