package com.zjw.io.stream.reader_writer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * 字符输入流缓冲
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws Exception {
        //1、定义要输入文件的路径
        File file = new File("g:" + File.separator + "test.txt");
        //判断文件是否存在
        if (!file.exists()) {
            System.out.println("文件不存在！");
            System.exit(1);
        }
        //准备管子
        InputStream in = Files.newInputStream(file.toPath());
        //字节输入流变为字符输入流
        Reader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
        //准备字符输入流缓冲
        BufferedReader br = new BufferedReader(isr);
        //进行数据读取
        String str = null;
        while ((str = br.readLine()) != null)//每次读取一行
        {
            System.out.println(str);
        }
        //关闭操作
        br.close();
    }
}
