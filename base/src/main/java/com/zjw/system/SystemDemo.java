package com.zjw.system;

import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

/**
 * @author 朱俊伟
 * @since 2022/01/20
 */
public class SystemDemo {

    public static void main(String[] args) {

        // 获取系统中的一些配置
        Properties properties = System.getProperties();
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String propertyName : propertyNames) {
            System.out.println(propertyName + "--->" +properties.getProperty(propertyName) );
        }

        // 获取系统使用的java版本
        String javaVersion = System.getProperty("java.version");
        System.out.println(javaVersion);

    }

    @Test
    public void sysInfoTest(){
        // 可用处理器的数量(不是CPU内核数量，是逻辑数量)
        System.out.println(Runtime.getRuntime().availableProcessors());
        // 版本信息
        System.out.println(Runtime.version());
        // VM总内存大小
        System.out.println(formatSize(Runtime.getRuntime().totalMemory()));
        // VM可用内存大小
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024 + "M");

        // 获取操作系统的 MXBean
        System.out.println("***********osBean**********");
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        // 返回操作系统架构
        System.out.println("osBean.getArch() = " + osBean.getArch());
        // 操作系统名字
        System.out.println("osBean.getName() = " + osBean.getName());
        // 操作系统版本
        System.out.println("osBean.getVersion() = " + osBean.getVersion());
        // CPU可用的逻辑处理器数量
        System.out.println("osBean.getAvailableProcessors() = " + osBean.getAvailableProcessors());


        // Java虚拟机内存系统的托管bean
        System.out.println("***********memoryMXBean**********");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        System.out.println("HeapMemoryUsage Committed = " + formatSize(memoryMXBean.getHeapMemoryUsage().getCommitted()));
        System.out.println("HeapMemoryUsage Init = " + formatSize(memoryMXBean.getHeapMemoryUsage().getInit()));
        System.out.println("HeapMemoryUsage Max = " + formatSize(memoryMXBean.getHeapMemoryUsage().getMax()));
        System.out.println("HeapMemoryUsage Used = " + formatSize(memoryMXBean.getHeapMemoryUsage().getUsed()));

        // Java虚拟机运行时的MXBean
        System.out.println("***********runtimeMXBean**********");
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println("runtimeMXBean.getName() = " + runtimeMXBean.getName());
        System.out.println("runtimeMXBean.getClassPath() = " + runtimeMXBean.getClassPath());
        System.out.println("runtimeMXBean.getPid() = " + runtimeMXBean.getPid());
        System.out.println("runtimeMXBean.getInputArguments() = " + runtimeMXBean.getInputArguments());
        System.out.println("runtimeMXBean.getManagementSpecVersion() = " + runtimeMXBean.getManagementSpecVersion());
        System.out.println("runtimeMXBean.getSpecName() = " + runtimeMXBean.getSpecName());
        System.out.println("runtimeMXBean.getSpecVendor() = " + runtimeMXBean.getSpecVendor());
        System.out.println("runtimeMXBean.getSpecVersion() = " + runtimeMXBean.getSpecVersion());
        System.out.println("runtimeMXBean.getStartTime() = " + new Date(runtimeMXBean.getStartTime()));
        System.out.println("runtimeMXBean.getVmName() = " + runtimeMXBean.getVmName());
        System.out.println("runtimeMXBean.getLibraryPath() = " + runtimeMXBean.getLibraryPath());
    }

    // 将字节大小格式化为可读的字符串
    private String formatSize(long size) {
        String[] units = {"B", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;

        while (size > 1024 && unitIndex < units.length - 1) {
            size /= 1024;
            unitIndex++;
        }

        return size + units[unitIndex];
    }

}
