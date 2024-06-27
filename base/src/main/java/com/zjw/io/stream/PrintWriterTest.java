package com.zjw.io.stream;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 朱俊伟
 * @since 2024/06/24 11:48
 */
public class PrintWriterTest {

    @TempDir
    Path tempDir;

    /**
     * writeAndRead 写文件和读文件
     */
    @Test
    @SneakyThrows
    public void writeAndReadTest() {
        // 文件写到临时目录中
        Path path = tempDir.resolve("hello.txt");
        try (PrintWriter writer = new PrintWriter(path.toFile(), StandardCharsets.UTF_8)) {
            writer.println("hello world");
            writer.println("This is PrintWriter print.");
            writer.println("你好呀");
        }

        // 读取所有行
        String string = Files.readString(path, StandardCharsets.UTF_8);
        System.out.println(string);

        // 读取为list
        List<String> lineList = Files.readAllLines(path, StandardCharsets.UTF_8);
        lineList.forEach(System.out::println);

        // 读取为stream
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEach(System.out::println);
        }
    }
}
