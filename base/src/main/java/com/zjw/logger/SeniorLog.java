package com.zjw.logger;

import java.util.logging.Logger;

/**
 * 高级日志
 * <p>
 * 通常，有以下 7 个日志记录器级别：<p>
 * • SEVERE 严重<p>
 * • WARNING 警告<p>
 * • INFO 信息（默认）↑<p>
 * • CONFIG 配置<p>
 * • FINE 详细<p>
 * • FINER 较详细<p>
 * • FINEST 非常详细<p>
 * 在默认情况下，只记录前三个级别。 也可以设置其他的级別。例如，<p>
 * logger.setLevel(Level.FINE);<p>
 * 现在，FINE 和更高级别的记录都可以记录下来。<p>
 * Level.ALL 开启所有级别的记录 Level.OFF 关闭所有级别的记录<p>
 *
 * @author 朱俊伟
 * @since 2022/04/08 1:31
 */
public class SeniorLog {
    //调用 getLogger 方法创建或获取记录器
    private static final Logger myLogger = Logger.getLogger("com.zjw.logger.SeniorLog");

    public static void logHello() {
        System.out.println(myLogger.getLevel());
        myLogger.severe("severe");
        myLogger.warning("warning");
        myLogger.info("Hello World!");
        //info级别一下的需要修改jar/lib/logging.properties 文件
        //修改日志记录级别 com.zjw.logger.SeniorLog=FINE
        //修改处理器(控制台)级别 java.util.logging.ConsoleHandler.level=FINE
        myLogger.config("config");
        myLogger.fine("fine");
        myLogger.finer("finer");
        myLogger.finest("finest");

    }

    public static void main(String[] args) {

        System.out.println();
        SeniorLog.logHello();
    }

}
