package com.zjw.io.stream;

import java.io.*;
import java.nio.file.Files;

/**
 * @描述：java--文件拷贝 BufferedInputStream BufferedOutputStream
 * @作者: zjw
 * @时间: 2018年7月15日 下午10:24:04
 */
public class CopyFileDemo {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();//开始时间

        File readFile = new File("g:/my.mp3");//源文件
        File writeFile = new File("g:/MyMusic/my.mp3");//目标文件

        //源文件是否存在
        if (!readFile.exists()) {
            System.out.println("文件不存在！");
            System.exit(1);
        }
        //目标目录是否存在
        if (!writeFile.getParentFile().exists()) {
            writeFile.getParentFile().mkdirs();//不存在创建
        }

        InputStream is = Files.newInputStream(readFile.toPath());//输入流
        OutputStream os = Files.newOutputStream(writeFile.toPath());//输出流


        BufferedInputStream bis = new BufferedInputStream(is);//缓冲输入流
        BufferedOutputStream bos = new BufferedOutputStream(os);//缓冲输出流


        byte[] data = new byte[1024];//输入的缓冲区
        int temp = 0;//读取的文件大小
        while ((temp = bis.read(data)) != -1) {
            bos.write(data, 0, temp);//写到目标文件
//			bos.flush();
        }
        //关闭操作
//		is.close();
//		os.close();

        bis.close();
        bos.close();

        long end = System.currentTimeMillis();//结束时间
        System.out.println("操作时间：" + (end - start) + "ms");
    }
}
