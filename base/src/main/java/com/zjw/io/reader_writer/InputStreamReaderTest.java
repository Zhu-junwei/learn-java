package com.zjw.io.reader_writer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 字符输入流缓冲
 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws Exception {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        String str = null;
        System.out.println("请输入数据：");
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        br.close();
    }
}
