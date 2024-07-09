package com.zjw.io.file;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;

/**
 * @author 朱俊伟
 * @since 2023/07/15 0:14
 */
public class Files2Test {

    @TempDir
    Path tempDir;

    /**
     * pathWatch 查找特定的文件
     */
    @Test
    @SneakyThrows
    @SuppressWarnings("all")
    public void pathWatchTest() {
        Path filePath = tempDir.getParent();

        System.out.println("******** glob:**/*.{tmp,txt} *******");
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.{tmp,txt}");
        Files.walk(filePath)
                .filter(matcher::matches)
                .forEach(System.out::println);

        System.out.println("******** glob:*.tmp *******");
        PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:*.tmp");
        Files.walk(filePath)
                .map(Path::getFileName)
                .filter(matcher2::matches)

                .forEach(System.out::println);

        System.out.println("******** isRegularFile glob:*.tmp *******");
        Files.walk(filePath) // 只查找文件
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .filter(matcher2::matches)
                .forEach(System.out::println);
    }

}
