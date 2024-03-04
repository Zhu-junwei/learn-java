package com.zjw.io.reader_writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 字符输出流缓冲
 */
public class BufferedWriterTest {
    public static void main(String[] args) throws Exception {
        //1、定义要输出文件的路径
        File file = new File("g:" + File.separator + "demo" + File.separator + "test.txt");
        //判断父路径是否存在
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();//不存在就创建
        }
        //准备管子(字节流)
        FileOutputStream fos = new FileOutputStream(file);
        //字节流转字符流
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        //字节流写缓冲
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("好好学习！\r\n");
        bw.close();

    }
}
