package com.zjw.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @描述：字节输出流Writer,子类FileWriter,BufferedWriter
 * @作者: zjw
 * @时间: 2018年7月16日 下午12:16:58
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
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        //字节流写缓冲
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("好好学习！\r\n");
        bw.close();

    }
}
