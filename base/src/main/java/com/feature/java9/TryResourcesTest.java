package com.feature.java9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * try-resources改进，使用有效最终变量的功能<a href="https://openjdk.org/jeps/213">EJP213</a>,
 * 允许在管理资源时使用更简洁和可读的代码
 * <p>
 * 有效最终变量(effectively-final variables): 有效最终变量是指在初始化后不会被修改的变量。
 * 即使它没有显式声明为final，只要它不被重新分配，它就被认为是有效的final
 *
 * @author 朱俊伟
 * @date 2024/07/02
 */
public class TryResourcesTest {

    public static void main(String[] args) throws FileNotFoundException {
        tryResourcesBefore();
        tryResourcesAfter();
    }

    /**
     * java9之前的写法，将需要释放的资源写到try里面，会自动释放
     */
    public static void tryResourcesBefore() throws FileNotFoundException {
        // 需要释放的资源写到try里面
        try (Scanner scanner = new Scanner(new File("C:\\Windows\\System32\\drivers\\etc\\hosts"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }

    /**
     * java9之后的写法，可以需要释放的资源定义写到try外面，并且将变量写在try里面，多个资源使用;隔开
     */
    public static void tryResourcesAfter() throws FileNotFoundException {
        // 需要释放的资源可以写到try外面
        Scanner scanner = new Scanner(new File("C:\\Windows\\System32\\drivers\\etc\\hosts"));
        try (scanner) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
