package com.zjw.io.stream.reader_writer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 字符输入流缓冲 读取网页数据
 */
public class BufferedReaderTest2 {
    public static void main(String[] args) throws Exception {
        //准备网址
        URL url = new URL("https://www.baidu.com/");
        //准备管子（字节输入流）
        InputStream in = url.openStream();
        //变为字符输入流
        Reader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
        //字符输入流缓冲
        BufferedReader br = new BufferedReader(isr);
        //进行数据读取
        String str = null;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        //关闭操作
        br.close();
    }
}
