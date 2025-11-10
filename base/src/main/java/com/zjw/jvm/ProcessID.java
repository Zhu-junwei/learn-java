package com.zjw.jvm;

import java.lang.management.ManagementFactory;

/**
 * @author jw
 * @since 2025/11/10 08:53
 */
public class ProcessID {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String PID = name.split("@")[0];
        System.out.println("当前进程ID:" + PID);
    }
}
