package com.zjw.io.stream;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * InputStream字节输入流
 *  因为每次都要读取一定数量的字节，如果遇到中文或其他多字节字符，确实有可能出现乱码问题。
 *  这是因为一个中文字符可能会被拆分在两个不同的读取操作中，特别是当中文字符恰好位于缓冲
 *  区边界时。第一部分字符可能在一个读取操作的末尾，而剩余部分在下一个读取操作的开始，这
 *  会导致字符编码不完整，从而出现乱码。
 */
public class InputStreamTest {
    public static void main(String[] args) throws Exception {
        //1、定义要输入文件的路径
        File file = new File("g:" + File.separator + "demo" + File.separator + "test.txt");
        //文件不存在就不操作了
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }
        // 使用 try-with-resources 确保 InputStream 正确关闭
        try (InputStream is = Files.newInputStream(file.toPath())) {
            byte[] data = new byte[1024]; // 缓冲区大小可根据实际情况调整
            int bytesRead;
            while ((bytesRead = is.read(data)) != -1) {
                // 直接打印读取的数据，而非每次读取一个字节
                System.out.println(new String(data, 0, bytesRead));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
