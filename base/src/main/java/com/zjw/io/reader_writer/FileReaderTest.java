package com.zjw.io.reader_writer;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * 描述：字符输入流 FileReader
 */
public class FileReaderTest {

    public static void main(String[] args) throws Exception {
        // 1、定义要输出文件的路径
        File file = new File("g:" + File.separator + "demo" + File.separator + "test.txt");
        // 判断文件是否存在
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }

        // 2、创建 FileReader 对象
        Reader reader = new FileReader(file);

        // 3、读取文件内容
        char[] data = new char[1024];
        int read;
        while ((read = reader.read(data)) != -1) {
            // 将读取到的字符数组转换为字符串
            String str = new String(data, 0, read);
            System.out.print(str);
        }

        // 4、关闭 Reader 对象
        reader.close();
    }
}