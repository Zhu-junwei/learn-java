package com.zjw.io;

import junit.framework.TestCase;

/**
 * @author 朱俊伟
 * @date 2023/06/25 11:22
 */
public class FileUtilsTest extends TestCase {


    public void testGetFileMD5() {
        String md5 = FileUtils.getFileMD5("D:\\test.txt");
        System.out.println(md5);
    }
}