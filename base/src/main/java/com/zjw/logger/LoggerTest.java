package com.zjw.logger;

import java.util.logging.Logger;

/**
 * 基本日志
 * @author 朱俊伟
 * @date 2022/04/08 1:31
 */
public class LoggerTest {
    public static void main(String[] args) {
        //取消日志
//        Logger.getGlobal().setLevel(Level.OFF);
        Logger logger = Logger.getGlobal();
        // Logger.GLOBAL_LOGGER_NAME "global"
        System.out.println(logger.getName());
        //null
        System.out.println(logger.getLevel());

        logger.info("File->Open menu item selected");
        logger.info("Hello World!");

    }

}

