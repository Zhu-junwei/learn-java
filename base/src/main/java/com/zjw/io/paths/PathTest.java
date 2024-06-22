package com.zjw.io.paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 朱俊伟
 * @since 2023/07/15 0:14
 */
public class PathTest {

    @TempDir
    Path tempDir;

    /**
     * 测试路径的创建和基本信息获取
     */
    @Test
    public void testPathCreationAndInfo() {
        // 创建路径
        Path filePath = tempDir.resolve("testFile.txt");

        // 获取路径信息
        System.out.println(filePath.getFileName().toString());
        System.out.println(filePath.getParent());
        System.out.println(filePath.isAbsolute());

        // 获取路径的绝对路径
        Path absolutePath = filePath.toAbsolutePath();
        System.out.println(absolutePath.isAbsolute());
    }

    /**
     * 测试路径的合并
     */
    @Test
    public void testPathResolution() {
        Path basePath = Paths.get("/base");
        Path relativePath = Paths.get("dir/file.txt");
        Path resolvedPath = basePath.resolve(relativePath);

        assertEquals("/base/dir/file.txt", resolvedPath.toString().replace('\\', '/'));

        Path siblingPath = Paths.get("sibling.txt");
        Path resolvedSiblingPath = resolvedPath.resolveSibling(siblingPath);

        assertEquals("/base/dir/sibling.txt", resolvedSiblingPath.toString().replace('\\', '/'));
    }

    /**
     * 测试获取相对路径
     */
    @Test
    public void testRelativePath() {
        Path path1 = Paths.get("/home/user");
        Path path2 = Paths.get("/home/user/docs/file.txt");
        Path relativePath = path1.relativize(path2);
        assertEquals("docs/file.txt", relativePath.toString().replace('\\', '/'));
    }

    /**
     * 测试路径的规范化和绝对化
     */
    @Test
    public void testPathNormalizationAndAbsolute() {
        Path path = Paths.get("/home/./user/../user/docs/file.txt");
        Path normalizedPath = path.normalize();

        assertEquals("/home/user/docs/file.txt", normalizedPath.toString().replace('\\', '/'));

        Path absolutePath = path.toAbsolutePath();
        assertTrue(absolutePath.isAbsolute());
    }

    /**
     * 测试路径属性检查
     */
    @Test
    public void testPathAttributes() throws IOException {
        Path filePath = tempDir.resolve("testFile.txt");
        Files.writeString(filePath, "Hello, World!");

        // 检查路径是否存在
        assertTrue(Files.exists(filePath));

        // 检查路径是否为文件
        assertTrue(Files.isRegularFile(filePath));

        // 检查路径是否为目录
        assertFalse(Files.isDirectory(filePath));

        // 检查路径是否可读、可写、可执行
        assertTrue(Files.isReadable(filePath));
        assertTrue(Files.isWritable(filePath));
        assertTrue(Files.isExecutable(filePath));
    }

    /**
     * 测试路径的比较, 不知道有什么用？
     */
    @Test
    public void testPathComparison() {
        Path path1 = Paths.get("/home/user/docs/file.txt");
        Path path2 = Paths.get("/home/user/docs/file.txt");
        Path path3 = Paths.get("/home/user/docs");

        assertEquals(path1, path2);
        assertNotEquals(path1, path3);

        int compareResult = path1.compareTo(path2);
        assertEquals(0, compareResult);

        compareResult = path1.compareTo(path3);
        assertTrue(compareResult > 0);
    }

    /**
     * 测试路径的迭代
     */
    @Test
    public void testPathIteration() {
        Path path = Paths.get("/home/user/docs/file.txt");
        List<String> elements = List.of("home", "user", "docs", "file.txt");

        int i = 0;
        for (Path element : path) {
            assertEquals(elements.get(i), element.toString());
            i++;
        }
    }

    /**
     * 测试创建目录和文件
     */
    @Test
    public void testCreateDirectoriesAndFiles() throws IOException {
        Path dirPath = tempDir.resolve("testDir");
        Path nestedDirPath = dirPath.resolve("nestedDir");
        Path filePath = dirPath.resolve("testFile.txt");

        // 创建目录
        Files.createDirectories(nestedDirPath);
        assertTrue(Files.exists(nestedDirPath));
        assertTrue(Files.isDirectory(nestedDirPath));

        // 创建文件
        Files.createFile(filePath);
        assertTrue(Files.exists(filePath));
        assertTrue(Files.isRegularFile(filePath));
    }
}
