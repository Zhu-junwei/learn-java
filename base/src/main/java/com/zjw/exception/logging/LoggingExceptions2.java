package com.zjw.exception.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 捕捉别人的异常，并将其记录到日志中，所以我们必须在异常处理程序中生成日志信息
 *
 * @author 朱俊伟
 * @date 2024/07/11
 */
public class LoggingExceptions2 {
    private static final Logger logger = Logger.getLogger("LoggingExceptions2");

    // 捕捉别人的异常，并将其记录到日志中，所以我们必须在异常处理程序中生成日志信息
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
        }
    }
}