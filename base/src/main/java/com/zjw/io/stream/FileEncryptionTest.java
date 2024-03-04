package com.zjw.io.stream;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * 文件加密解密
 */
public class FileEncryptionTest {
    public static void main(String[] args) {
        //源文件
        File file1 = new File("g:" + File.separator + "my.png");
        //加密文件
        File file2 = new File("g:" + File.separator + "myenc.png");
        //解密文件
        File file3 = new File("g:" + File.separator + "mydec.png");
//		EnFile(file1,file2);
        DecFile(file2, file3);

    }

    //加密方法
    public static void EnFile(File srcFile, File tarFile) {
        try (InputStream is = Files.newInputStream(srcFile.toPath());
             OutputStream os = Files.newOutputStream(tarFile.toPath());
             BufferedInputStream bis = new BufferedInputStream(is);
             BufferedOutputStream bos = new BufferedOutputStream(os);
        ) {
            byte[] data = new byte[100];
            int len = 0;
            while ((len = bis.read(data, 10, 60)) != -1) {
                if (len == 60) {
                    bos.write(data, 0, 100);
                } else {
                    bos.write(data, 10, len);
                }
                System.out.println(Arrays.toString(data));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //解密方法
    public static void DecFile(File srcFile, File tarFile) {

        try (
                InputStream is = Files.newInputStream(srcFile.toPath());
                OutputStream os = Files.newOutputStream(tarFile.toPath());
                BufferedInputStream bis = new BufferedInputStream(is);
                BufferedOutputStream bos = new BufferedOutputStream(os);
        ) {
            byte[] data = new byte[100];
            int len = 0;
            while ((len = bis.read(data)) != -1) {
                if (len == 100) {
                    bos.write(data, 10, 60);
                } else {
                    bos.write(data, 0, len);
                }
                System.out.println(Arrays.toString(data));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
