package com.zjw.io.file;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author 朱俊伟
 * @since 2024/06/20 04:19
 */
public class FilesTest {

    @TempDir
    Path tempDir;

    /**
     * 测试Path.of()获取Path
     */
    @Test
    public void pathOfTest() {
        String tempDir = System.getProperty("java.io.tmpdir");
        Path path = Path.of(tempDir);
        System.out.println(path);
    }

    /**
     * 测试创建文件并写入内容
     */
    @Test
    public void testCreateAndWriteFile() throws IOException {
        // C:/Users/<user>/AppData/Local/Temp/junitxxxxxx
        System.out.println("Temporary directory: " + tempDir);
        // 创建文件路径
        Path filePath = tempDir.resolve("testFile.txt");
        // C:/Users/<user>/AppData/Local/Temp/junitxxxxxx/testFile.txt
        System.out.println("File path: " + filePath);
        // 写入文件（如果文件已存在，则覆盖）
        Files.writeString(filePath, "Hello, World!");
        // 断言文件存在
        assertTrue(Files.exists(filePath));
        // 读取文件内容
        String content = Files.readString(filePath);
        System.out.println(content);
        // 断言文件内容正确
        assertEquals("Hello, World!", content);
        // 追加内容
        Files.writeString(filePath, "\nAppend!", StandardOpenOption.APPEND);
        System.out.println(Files.readString(filePath));
    }

    /**
     * 读取行
     */
    @SneakyThrows
    @Test
    public void readLineTest() {
        Path filePath = tempDir.resolve("testFile.txt");
        Files.writeString(filePath, "hello1\n");
        Files.writeString(filePath, "hello2\n", StandardOpenOption.APPEND);
        Files.writeString(filePath, "hello3\n", StandardOpenOption.APPEND);
        Files.writeString(filePath, "hello4\n", StandardOpenOption.APPEND);
        // 读取所有行
        List<String> list = Files.readAllLines(filePath);
        list.forEach(System.out::println);
        // 读取为stream，筛选偶数行
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.filter(s -> (Integer.parseInt(s.substring(5))) % 2 == 0)
                    .forEach(System.out::println);
        }

    }

    /**
     * 测试创建目录并删除
     */
    @Test
    public void testCreateAndDeleteDirectory() throws IOException {
        // 创建目录路径
        Path dirPath = tempDir.resolve("testDir");
        System.out.println(dirPath);
        // 创建目录, 创建多级目录可以使用createDirectories
        Files.createDirectory(dirPath);
        // 断言目录存在
        assertTrue(Files.exists(dirPath));
        assertTrue(Files.isDirectory(dirPath));
        // 删除目录
        Files.delete(dirPath);
        // 断言目录已删除
        assertFalse(Files.exists(dirPath));
    }

    /**
     * 测试复制和移动文件
     */
    @Test
    public void testCopyAndMoveFile() throws IOException {
        // 创建源文件路径
        Path sourceFilePath = tempDir.resolve("sourceFile.txt");
        // 创建源文件并写入内容
        Files.writeString(sourceFilePath, "Content to copy");
        // 创建目标文件路径
        Path targetFilePath = tempDir.resolve("targetFile.txt");
        // 复制文件
        Files.copy(sourceFilePath, targetFilePath);
        // 断言目标文件存在并且内容相同
        assertTrue(Files.exists(targetFilePath));
        assertEquals("Content to copy", Files.readString(targetFilePath));
        // 移动文件(重命名)
        Path movedFilePath = tempDir.resolve("movedFile.txt");
        Files.move(targetFilePath, movedFilePath);
        // 断言目标文件已移动并且源文件不存在
        assertTrue(Files.exists(movedFilePath));
        assertFalse(Files.exists(targetFilePath));
    }

    /**
     * 测试获取文件属性
     */
    @Test
    public void testFileAttributes() throws IOException {
        Path filePath = tempDir.resolve("testFile.txt");
        Files.writeString(filePath, "Hello, World!");

        // 获取文件大小
        long size = Files.size(filePath);
        assertEquals("Hello, World!".length(), size);

        // 获取最后修改时间
        FileTime lastModifiedTime = Files.getLastModifiedTime(filePath);
        // 打印原始 FileTime
        System.out.println("FileTime: " + lastModifiedTime);
        // 将 FileTime 转换为 Instant
        Instant instant = lastModifiedTime.toInstant();
        // 将 Instant 转换为本地时间的 LocalDateTime
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        // 打印本地时间
        System.out.println("LocalDateTime: " + localDateTime);

        // 检查文件可读性、可写性和可执行性
        assertTrue(Files.isReadable(filePath));
        assertTrue(Files.isWritable(filePath));
        assertTrue(Files.isExecutable(filePath));
    }

    /**
     * 测试列出和遍历目录
     */
    @Test
    public void testListAndWalkDirectories() throws IOException {
        Path dirPath = tempDir.resolve("testDir");
        Path subdir = dirPath.resolve("subdir");
        Files.createDirectory(dirPath);
        Files.createDirectory(subdir);
        Files.writeString(dirPath.resolve("file1.txt"), "File 1");
        Files.writeString(dirPath.resolve("file2.txt"), "File 2");
        Files.writeString(subdir.resolve("file3.txt"), "File 3");

        // 列出目录中的文件和子目录
        try (Stream<Path> list = Files.list(dirPath)) {
            List<Path> files = list.toList();
            files.forEach(System.out::println);
        }
        System.out.println("**********");
        // 递归遍历目录及其子目录中的文件和目录
        try (Stream<Path> walk = Files.walk(dirPath)) {
            List<Path> files = walk.filter(Files::isRegularFile).toList();
            files.forEach(System.out::println);
        }
    }

    /**
     * 测试设置文件权限
     */
    @Test
    public void testSetPosixFilePermissions() throws IOException {
        // 检查是否是支持POSIX文件权限的操作系统
        assumeTrue(FileSystems.getDefault().supportedFileAttributeViews().contains("posix"), "Skipping POSIX permissions test on non-POSIX file system");

        Path filePath = tempDir.resolve("testFile.txt");
        Files.writeString(filePath, "Hello, World!");

        // 设置文件的POSIX权限
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwxr-x---");
        Files.setPosixFilePermissions(filePath, perms);

        // 验证文件的POSIX权限
        Set<PosixFilePermission> filePerms = Files.getPosixFilePermissions(filePath);
        assertEquals(perms, filePerms);
    }

    /**
     * 测试探测文件类型
     */
    @Test
    public void testProbeContentType() throws IOException {
        Path filePath = tempDir.resolve("testFile.txt");
        Files.writeString(filePath, "Hello, World!");

        // 探测文件的内容类型（MIME类型）
        String contentType = Files.probeContentType(filePath);
        assertEquals("text/plain", contentType);
    }

    /**
     * 测试字节级别的文件读写
     */
    @Test
    public void testReadAndWriteBytes() throws IOException {
        Path filePath = tempDir.resolve("testFile.bin");
        byte[] data = {0x01, 0x02, 0x03, 0x04};

        // 写入字节到文件
        Files.write(filePath, data);

        // 读取文件的所有字节
        byte[] readData = Files.readAllBytes(filePath);
        assertArrayEquals(data, readData);
    }

}
