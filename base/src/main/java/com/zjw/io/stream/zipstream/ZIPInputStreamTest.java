package com.zjw.io.stream.zipstream;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author 朱俊伟
 * @since 2024/06/27 14:02
 */
public class ZIPInputStreamTest {

    @SneakyThrows
    @Test
    public void testGetNextEntry() {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("a.zip"))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                System.out.println("Reading entry: " + entry.getName());

                // 使用 BufferedReader 读取条目内容
                BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                zipInputStream.closeEntry(); // 关闭当前条目
            }
        }
    }

    /**
     * 
     */
    @Test
    @SneakyThrows
    public void putEntityTest() {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("a.zip"))) {
            ZipEntry zipEntry = new ZipEntry("README.md");
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.closeEntry();
        }
    }
}
