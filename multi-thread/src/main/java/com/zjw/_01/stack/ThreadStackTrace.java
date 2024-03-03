package com.zjw._01.stack;

import java.util.Map;
import java.util.Set;

/**
 * getStackTrace() 获取当前线程的堆栈信息
 * Thread.dumpStack() 将当前线程的堆栈跟踪信息输出至标准错误流
 * Thread.getAllStackTraces() 获取所有线程的堆栈信息映射
 * @author 朱俊伟
 * @since 2023/02/19 22:05
 */
public class ThreadStackTrace {

    public void a() {
        b();
    }

    public void b() {
        c();
    }

    public void c() {
        d();
    }

    public void d() {
        e();
    }

    public void e() {
        //输出当前线程的堆栈信息
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        this.printStackTraceElement(stackTrace);
    }

    public void printStackTraceElement(StackTraceElement[] stackTrace) {
        System.out.println("打印堆栈信息******start");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String stackTraceElementInfo = "ClassName:" + stackTraceElement.getClassName() + "," +
                    "FileName:" + stackTraceElement.getFileName() + "," +
                    "MethodName:" + stackTraceElement.getMethodName() + "," +
                    "LineNumber:" + stackTraceElement.getLineNumber();
            System.out.println(stackTraceElementInfo);
        }
        System.out.println("打印堆栈信息******end");
    }

    public void printThread(Thread thread){
        System.out.println("打印线程信息******start");
        String threadInfo = "Name:" + thread.getName() + "," +
                "ID:" + thread.getId() + "," +
                "Priority:" + thread.getPriority() + "," +
                "State:" + thread.getState();
        System.out.println(threadInfo);
        System.out.println("打印线程信息******end\n");
    }

    public void dumpStack(){
        //将当前线程的堆栈跟踪信息输出至标准错误流
        Thread.dumpStack();
    }

    public void allStackTraces() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (!allStackTraces.isEmpty()){
            Set<Thread> threadSet = allStackTraces.keySet();
            for (Thread thread : threadSet) {
                printThread(thread);
                StackTraceElement[] stackTrace = allStackTraces.get(thread);
                printStackTraceElement(stackTrace);
            }
        }
    }

    public static void main(String[] args) {
        ThreadStackTrace threadStackTrace = new ThreadStackTrace();
//        threadStackTrace.a();
//        threadStackTrace.dumpStack();
        threadStackTrace.allStackTraces();
    }
}
