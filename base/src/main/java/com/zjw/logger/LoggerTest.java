package com.zjw.logger;

import java.util.logging.Logger;

/**
 * 基本日志
 * @author 朱俊伟
 * @since 2022/04/08 1:31
 */
public class LoggerTest {
    public static void main(String[] args) {
        // 取消日志
//        Logger.getGlobal().setLevel(Level.OFF);
        Logger logger = Logger.getGlobal();
        // global
        System.out.println(logger.getName());
        System.out.println(Logger.GLOBAL_LOGGER_NAME);
        //null
        System.out.println(logger.getLevel());

        logger.info("File->Open menu item selected");
        logger.info("Hello World!");

    }

}

