package com.zjw.exception.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 我们可以使用 java.util.logging 工具将异常输出记录到日志中
 *
 * @author 朱俊伟
 * @date 2024/07/11
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }
}

class LoggingException extends Exception {
    private static final Logger logger = Logger.getLogger("LoggingException");

    LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
