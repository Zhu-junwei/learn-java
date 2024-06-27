package com.zjw.io.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * java--文件拷贝 BufferedInputStream BufferedOutputStream
 *
 * @author : zjw
 * @since : 2018年7月15日 下午10:24:04
 */
public class CopyFileDemo {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        Path readFile = Paths.get("g:/my.mp3");
        Path writeFile = Paths.get("g:/MyMusic/my.mp3");

        if (!Files.exists(readFile)) {
            System.out.println("文件不存在！");
            System.exit(1);
        }

        Files.createDirectories(writeFile.getParent());

        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(readFile));
             BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(writeFile))) {

            byte[] data = new byte[1024];
            int temp;
            while ((temp = bis.read(data)) != -1) {
                bos.write(data, 0, temp);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("操作时间：" + (end - start) + "ms");
    }
}
