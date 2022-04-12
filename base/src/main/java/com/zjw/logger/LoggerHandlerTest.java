package com.zjw.logger;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 朱俊伟
 * @date 2022/04/12 14:50
 */
public class LoggerHandlerTest {

    private static final Logger logger = Logger.getLogger("com.zjw.logger.LoggerHandlerTest");

    public static void main(String[] args) throws IOException {
//        myHandler();

        myFileHandler();
        logMessage();
    }

    /**
     * 将日志记录到文件中
     *  Windows默认为 C:/Users/用户名/java0.log
     *  Linux默认为用户家目录
     */
    private static void myFileHandler() throws IOException {
        //定义日志级别
        logger.setLevel(Level.FINE);
        //不使用原先的日志处理器
        logger.setUseParentHandlers(false);
        /*
          新建日志处理器
          pattern 日志文件名的模式
          limit   文件的大小，FileHandler类中的0表示无限制
          count   日志记录数量，默认1(不循环)
          append  是否在原文件上追加，默认false(不追加)
         */
        FileHandler handler = new FileHandler("%h/java%u.log",1024,10,true);
        //设置编码
        handler.setEncoding("UTF-8");
        //设置日志处理器的级别
        handler.setLevel(Level.FINE);
        //为日志记录器设置日志处理器
        logger.addHandler(handler);
    }

    /**
     * 自定义的日志处理器
     */
    private static void myHandler() {
        //定义日志级别
        logger.setLevel(Level.FINE);
        //不使用原先的日志处理器
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        //设置日志处理器的级别
        handler.setLevel(Level.FINE);
        //为日志记录器设置日志处理器
        logger.addHandler(handler);
        logger.info("Hello World!");
    }

    /**
     * 记录不同级别的日志
     */
    private static void logMessage(){
        logger.severe("severe");
        logger.warning("warning");
        logger.info("Hello World!");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

}
