package com.zjw.io;

import java.io.File;

/**
 * File应用：打印目录的层级
 */
public class FileTreeMain {
    public static void main(String[] args) {
        String path = "E:\\code\\IdeaProjects\\learn-java\\base\\src\\main\\java";
        File file = new File(path);

        treeFile(file, 0);
    }

    public static void treeFile(File file, int level) {
        /* 前缀字符串 */
        String preStr = "";
        for (int i = 0; i < level; i++) {
            preStr = preStr + "|-->";
        }
        System.out.println(preStr + file.getName());
        if (file.isFile()) {
            /* 重复的代码要删除 */
            /* 重复的代码,封装成一个方法
             * 自己调用自己:递归 */
            return;
        }
        /* 列出当前目录下面的文件和文件夹 */
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            File fileTemp = listFiles[i];
            /* 第二级 */
            /* 调用一次方法 */
            treeFile(fileTemp, level + 1);
        }
    }

}
