package com.zjw.exception;


import java.io.FileInputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author 朱俊伟
 * @date 2022/04/05 16:13
 */
public class ExceptionTest {
    public static void main(String[] args) {

        /*
            不论这个块如何退出，in和out都会关闭，就好像使用了finally块一样
         */
        try (Scanner in = new Scanner(new FileInputStream("E:/logs/a.txt"), StandardCharsets.UTF_8.name());
             PrintWriter out = new PrintWriter("out.txt")){
            while (in.hasNext()){
                String next = in.next();
                System.out.println(next);
                out.println(next.toUpperCase());
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("异常了");
        }
    }


}