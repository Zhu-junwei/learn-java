package com.feature.java7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * try-resources用法
 *
 * @author 朱俊伟
 * @date 2024/07/02
 */
public class TryResourcesTest {

    public static void main(String[] args) {
        //java7之前的写法，需要在finally手动关闭资源
        tryFinally();
        //java7之后的写法
        tryResources();
    }

    /**
     * java7之前的写法，需要在finally手动关闭资源
     */
    public static void tryFinally() {
        //读取文本文件的内容
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("D://read.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * java7之后的写法，将需要释放的资源写到try里面，会自动释放
     */
    public static void tryResources() {
        //读取文本文件的内容
        try (Scanner scanner = new Scanner(new File("D://read.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
