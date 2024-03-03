package com.zjw.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @描述：利用打印流PrintStream输出信息
 * @作者: zjw
 * @时间: 2018年7月16日 上午9:31:51
 */
public class PrintStreamTest {
    public static void main(String[] args) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream(new File("g:" + File.separator + "test.txt")));
        ps.println("Hello");
        ps.write("World".getBytes());
        ps.close();

    }

}
