package com.zjw.io.paths;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

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
        System.out.println(filePath.getFileName()); // testFile.txt
        System.out.println(filePath.getRoot()); // C:\
        System.out.println(filePath.getParent()); // C:\Users\<your_username>\AppData\Local\Temp\junit5161789360708147242
        System.out.println(filePath.isAbsolute()); // true

        // 获取路径的绝对路径 会带上盘符 如E:
        Path absolutePath = filePath.toAbsolutePath();
        System.out.println(absolutePath.isAbsolute()); // true
    }

    /**
     * 测试路径的合并
     */
    @Test
    public void testResolve() {
        Path basePath = Paths.get("/base");
        Path filePath = Paths.get("dir/file.txt");
        Path resolvedPath = basePath.resolve(filePath);

        assertEquals("/base/dir/file.txt", resolvedPath.toString().replace('\\', '/'));
    }

    /**
     * resolveSibling
     */
    @Test
    public void resolveSiblingTest() {
        Path basePath = Paths.get("/base");
        Path baseFile = basePath.resolve("base.txt");

        // 兄弟路径 /tmp
        Path siblingPath = basePath.resolveSibling("tmp");
        assertEquals("/tmp", siblingPath.toString().replace('\\', '/'));
        // 兄弟文件 /base/dir/sibling.txt
        Path siblingFile = baseFile.resolveSibling("sibling.txt");
        assertEquals("/base/sibling.txt", siblingFile.toString().replace('\\', '/'));
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
    public void testPathNormalize() {
        Path path = Paths.get("/home/./user/../user/docs/file.txt");
        Path normalizedPath = path.normalize();

        assertEquals("/home/user/docs/file.txt", normalizedPath.toString().replace('\\', '/'));
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
    @SneakyThrows
    public void testCreateDirectoryAndFile() {
        Path dirPath = tempDir.resolve("testDir");
        Path filePath = dirPath.resolve("testFile.txt");

        // 创建目录, 如果由于目录已存在而无法创建目录，则不会引发异常
        Files.createDirectory(dirPath);
        assertTrue(Files.exists(dirPath));
        assertTrue(Files.isDirectory(dirPath));

        // 如果需要创建中间目录，可以使用Files.createDirectories()
        Files.createDirectories(dirPath.resolve("a/b/c"));

        // 创建文件 如果已经存在了会抛出FileAlreadyExistsException
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    /**
     * createTempFile
     * Path newPath = Files.createTempFile(dir, prefix, suffix);
     * Path newPath = Files.createTempFile(prefix, suffix);
     */
    @Test
    @SneakyThrows
    public void createTempFileTest() {
        // C:\Users\zjw\AppData\Local\Temp\1313986944649793987.txt
        // 如果后缀是null，默认为“.tmp”
        Path file = Files.createTempFile(null, ".txt");
        assertTrue(Files.exists(file));
        Files.deleteIfExists(file);

        // C:\Users\zjw\AppData\Local\Temp\myTempFile13786741576167869291.txt
        Path myTempFile = Files.createTempFile("myTempFile", ".txt");
        assertTrue(Files.exists(myTempFile));
        Files.deleteIfExists(myTempFile);
    }

    /**
     * createTempDirectory
     */
    @Test
    @SneakyThrows
    public void createTempDirectoryTest() {
        // C:\Users\zjw\AppData\Local\Temp\myTemp629953881742931720
        Path myTemp = Files.createTempDirectory("myTemp");
        assertTrue(Files.exists(myTemp));
        Files.deleteIfExists(myTemp);

        Path myTemp2 = Files.createTempDirectory(Path.of("E:\\"), "myTemp2");
        System.out.println(myTemp2);
        assertTrue(Files.exists(myTemp2));
        Files.deleteIfExists(myTemp2);
    }

    /**
     * copy
     */
    @Test
    @SneakyThrows
    public void copyTest() {
        Path source = Files.createTempFile(null, ".txt");
        Path target = tempDir.resolve("a.txt");
        // 如果target已经存在会报错，FileAlreadyExistsException
        Files.copy(source, target);
        // 可以选择如果存在可以进行覆盖 StandardCopyOption.REPLACE_EXISTING
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        // 拷贝属性StandardCopyOption.COPY_ATTRIBUTES
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
        assertTrue(Files.exists(target));

        Files.deleteIfExists(source);
        Files.deleteIfExists(target);
    }

    /**
     * copy 复制文件夹
     */
    @Test
    @SneakyThrows
    public void copy2Test() {
        Path baseDir = tempDir.resolve("baseDir");
        Path targetDir = tempDir.resolve("targetDir");

        Files.createDirectories(baseDir);
        Path file1 = Files.createTempFile(baseDir, null, ".txt");
        Path file2 = Files.createTempFile(baseDir, null, ".txt");
        // 可以复制空文件夹，但是如果文件夹不为空则不能复制
//        Files.copy(baseDir, targetDir);
        // 调用自定义的复制文件夹方法
        copyDirectory(baseDir, targetDir);
        assertTrue(Files.exists(targetDir));

        // 递归删除文件夹
        deleteDirectoryRecursively(baseDir);
        deleteDirectoryRecursively(targetDir);
    }

    /**
     * 自定义的复制文件夹方法
     */
    public void copyDirectory(Path source, Path target) throws IOException {
        Files.walkFileTree(source, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path targetDir = target.resolve(source.relativize(dir));
                if (!Files.exists(targetDir)) {
                    Files.createDirectories(targetDir);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, target.resolve(source.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }


    /**
     * 移动文件
     */
    @Test
    @SneakyThrows
    public void moveTest() {
        Path source = Files.createTempFile(null, ".txt");
        Path target = tempDir.resolve("a.txt");
        Files.move(source, target);
        assertFalse(Files.exists(source));
        assertTrue(Files.exists(target));

        Path source2 = Files.createTempFile(null, ".txt");
        Path target2 = tempDir.resolve("b.txt");
        Files.copy(source2, target2);
        // 如果target2已经存在会报错，FileAlreadyExistsException
        // Files.move(source2, target2);
        // 可以选择如果存在可以进行覆盖 StandardCopyOption.REPLACE_EXISTING
        // 设置移动的原子性，StandardCopyOption.ATOMIC_MOVE
        Files.move(source2, target2, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);

        Files.deleteIfExists(source);
        Files.deleteIfExists(target);
        Files.deleteIfExists(source2);
        Files.deleteIfExists(target2);
    }

    /**
     * move 移动文件夹
     */
    @Test
    @SneakyThrows
    public void move2Test() {
        Path baseDir = tempDir.resolve("baseDir");
        Path targetDir = tempDir.resolve("targetDir");

        Files.createDirectories(baseDir);
        Path file1 = Files.createTempFile(baseDir, null, ".txt");
        Path file2 = Files.createTempFile(baseDir, null, ".txt");
        // 可以移动非空文件夹
        Files.move(baseDir, targetDir);
        assertTrue(Files.exists(targetDir));

        Files.deleteIfExists(baseDir);
        // 不能删除非空的文件夹 DirectoryNotEmptyException
//        Files.deleteIfExists(targetDir);
        // 调用自定义的递归删除文件夹
        deleteDirectoryRecursively(targetDir);
    }

    /**
     * 自定义的递归删除文件夹
     */
    public void deleteDirectoryRecursively(Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.deleteIfExists(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.deleteIfExists(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * list 列里目录的子项
     */
    @Test
    @SneakyThrows
    public void listTest() {
        try (Stream<Path> pathStream = Files.list(tempDir.getParent())) {
            pathStream.forEach(System.out::println);
        }
    }

    /**
     * walk 可以进入子目录
     */
    @Test
    @SneakyThrows
    public void walkTest() {
        System.out.println(System.getProperty("user.dir"));
        Path path = Paths.get(System.getProperty("user.dir")).getParent();

        try (Stream<Path> pathStream = Files.walk(path)) {
            long javaFileCount = pathStream
                    .filter(f -> Files.isRegularFile(f) && f.toString().endsWith(".java"))
                    .count();

            System.out.println("Number of .java files: " + javaFileCount);
        }

        // Re-run the walk to calculate the total number of lines in .java files
        try (Stream<Path> pathStream = Files.walk(path)) {
            long totalLines = pathStream
                    .filter(f -> Files.isRegularFile(f) && f.toString().endsWith(".java"))
                    .mapToLong(f -> {
                        try {
                            return Files.lines(f).count();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();

            System.out.println("Total number of lines in .java files: " + totalLines);
        }
    }

    @Test
    @SneakyThrows
    public void listAccessibleFilesAndDirectories() {
        Files.walkFileTree(tempDir.getParent(), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (Files.isReadable(dir) && Files.isExecutable(dir)) {
                    System.out.println("Directory: " + dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    System.out.println("No access to directory: " + dir);
                    return FileVisitResult.SKIP_SUBTREE;
                }
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (Files.isReadable(file)) {
                    System.out.println("File: " + file);
                } else {
                    System.out.println("No access to file: " + file);
                }
                return FileVisitResult.CONTINUE;
            }

        });
    }

}
