package com.zjw.io;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 朱俊伟
 * @since 2023/07/15 0:14
 */
public class PathTest {

    /**
     * 测试Paths.get(fileName)
     */
    @Test
    public void testGet() {
        Path path = Paths.get("a/b/c", "test.txt");
        System.out.println(path);// a\b\c\test.txt
        System.out.println(path.getFileName());//test.txt
        System.out.println(path.getFileSystem());//sun.nio.fs.WindowsFileSystem@7cf10a6f
    }
}
