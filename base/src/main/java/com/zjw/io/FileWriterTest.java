package com.zjw.io;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

/**
 * @描述：字节输出流Writer,子类FileWriter,BufferedWriter 输出文件中的数据
 * @作者: zjw
 * @时间: 2018年7月16日 下午12:16:58
 */
public class FileWriterTest {
    public static void main(String[] args) throws Exception {
        //1、定义要输出文件的路径
        File file = new File("g:" + File.separator + "demo" + File.separator + "test.txt");
        //判断父路径是否存在
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();//不存在就创建
        }
        //实例化Writer对象
        Writer out = new FileWriter(file);
        //准备数据
        String str = "好好学习！";
        //写入数据
        out.write(str);
        //关闭操作
        out.close();
    }
}
