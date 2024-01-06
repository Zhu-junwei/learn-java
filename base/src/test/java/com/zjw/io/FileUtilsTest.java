package com.zjw.io;

import org.junit.jupiter.api.Test;

/**
 * @author 朱俊伟
 * @since 2023/06/25 11:22
 */
public class FileUtilsTest{

    @Test
    public void testGetFileMD5() {
        String md5 = FileUtils.getFileMD5("D:\\test.txt");
        System.out.println(md5);
    }
}