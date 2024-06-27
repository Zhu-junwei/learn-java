package com.zjw.io.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * 利用打印流PrintStream输出信息
 *
 * @author : zjw
 */
public class PrintStreamTest {
    public static void main(String[] args) throws Exception {
        try (PrintStream ps = new PrintStream(
                new FileOutputStream("g:" + File.separator + "test.txt"),
                true,
                StandardCharsets.UTF_8)) {
            ps.print("Hello,");
            ps.println("zjw");
            ps.print("This is PrintStream.");
        }

    }

}
