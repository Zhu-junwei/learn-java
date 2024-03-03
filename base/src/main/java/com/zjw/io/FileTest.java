package com.zjw.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * File类的常用方法
 */
public class FileTest {

    public static void main(String[] args) {
        //路径分隔符 ；
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        //名称分隔符 \
        System.out.println(File.separator);
        System.out.println(File.separatorChar);

        File file1 = new File("D:\\test");
        File file2 = new File("D:/test/a.txt");


        //路径
        System.out.println("*********路径******");
        //D:\test
        System.out.println(file1);
        //绝对路径 D:\test
        System.out.println(file1.getPath());
        //获取父路径 D:\
        System.out.println(file1.getParent());
        //当前最后一级的名字 test
        System.out.println(file1.getName());

        System.out.println("****文件的大小****");
        //文件的大小
        //文件所在分区的盘符大小
        System.out.println(file1.getTotalSpace());
        //盘符可用空间大小
        System.out.println(file1.getUsableSpace());
        System.out.println(file1.getFreeSpace());
        //文件的长度
        System.out.println(file2.length());

        //判断是文件还是文件夹
        System.out.println("***判断是文件还是文件夹***");
        System.out.println(file1.isFile());
        System.out.println(file1.isDirectory());

        //容器的问题 文件夹的容器
        //CRUD
        //增加 创建文件 创建文件夹
        System.out.println("****CRUD****");
        //创建文件 文件存在返回false 父目录不存在返回异常
        try {
            boolean createNewFileFlag = file2.createNewFile();
            System.out.println(createNewFileFlag);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建文件夹 文件夹存在返回false 父目录不存在返回异常
        System.out.println(file1.mkdir());

        //查询
        String[] listStrs = file1.list();
        System.out.println(Arrays.toString(listStrs));

        //修改
        File file3 = new File("d:/test_a");
//		boolean renameFlag = file1.renameTo(file3);
//		System.out.println(renameFlag);

        //删除 只能删除空文件夹或文件
        System.out.println(file2.delete());


    }
}