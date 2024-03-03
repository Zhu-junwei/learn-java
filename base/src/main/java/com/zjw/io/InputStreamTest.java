package com.zjw.io;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

public class InputStreamTest {
    public static void main(String[] args) throws Exception {
        //1、定义要输入文件的路径
        File file = new File("g:" + File.separator + "demo" + File.separator + "test.txt");
        //文件不存在就不操作了
        if (!file.exists()) {
            System.out.println("文件不存在");
        } else {
            //2、找一根传输的管子
            InputStream is = Files.newInputStream(file.toPath());
            //3、存放传输的数据
            byte[] data = new byte[1024];
            int temp = 0;
            int foot = 0;
            while ((temp = is.read()) != -1) {
                data[foot++] = (byte) temp;
            }
            System.out.println("【" + new String(data, 0, foot) + "】");
            //4、关闭
            is.close();

        }
    }
}
