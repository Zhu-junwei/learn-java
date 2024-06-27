package com.zjw.io.stream.pushback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * 使用 PushbackInputStream 读取标识符，并在读取到特殊终止符后将其推回。
 * 特殊终止符为 `#`。
 */
public class PushbackInputStreamExample {
    public static void main(String[] args) {
        // 示例输入，其中标识符由特殊符号 # 结束
        String input = "identifier#123";
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
             PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream)) {

            int data;
            StringBuilder identifier = new StringBuilder();

            // 读取标识符，直到遇到特殊符号 #
            while ((data = pushbackInputStream.read()) != -1) {
                char ch = (char) data;
                if (ch == '#') {
                    // 遇到终止符，将其推回流中
                    pushbackInputStream.unread(data);
                    break;
                } else {
                    identifier.append(ch);
                }
            }

            System.out.println("Identifier: " + identifier);

            // 读取并显示下一个字符（应该是终止符 #）
            data = pushbackInputStream.read();
            if (data != -1) {
                char ch = (char) data;
                System.out.println("Next character after identifier: " + ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}