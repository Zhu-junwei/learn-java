package com.zjw.io.stream.pushback;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * 使用PushbackInputStream寻找特殊字符
 */
public class ModifyStreamExample {

    public static void main(String[] args){
        String input = "12345";
        try( ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
             PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            int byteRead;
            while ((byteRead = pushbackInputStream.read()) != -1) {
                if (byteRead == '3') {// 将 '3' 退回到输入流中
                    byteArrayOutputStream.write('8'); // 修改 '3' 为 '8'
                } else {
                    byteArrayOutputStream.write(byteRead);
                }
            }
            System.out.println("Modified Output: " + byteArrayOutputStream);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
