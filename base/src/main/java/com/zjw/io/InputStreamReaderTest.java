package com.zjw.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @描述：字符输入流：读取键盘上输入的数据
 * @作者: zjw
 * @时间: 2018年7月16日 下午2:17:39
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
