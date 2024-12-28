package com.temp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

/**
 * @author 朱俊伟
 * @since 2024/03/20 22:11
 */
public class TempTest {

    public static void main(String[] args) throws IOException {
        // 指定目标目录路径
        Path path = Paths.get("D:\\系统文件夹\\Desktop\\download\\中华经典名著全本全注全译——整理\\精选_ocr");

        // 使用 try-with-resources 自动关闭流
        try (Stream<Path> files = Files.list(path)) {
            files.forEach(p -> {
                try {
                    String fileName = p.getFileName().toString();
                    // 检查文件名是否符合条件
                    if (fileName.startsWith("[OCR]_")) {
                        // 生成新的文件名
                        String newName = fileName.substring(6, fileName.length() - 12) + ".pdf";
                        Path newPath = path.resolve(newName);

                        // 执行文件重命名
                        Files.move(p, newPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("重命名成功: " + fileName + " -> " + newName);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}