package com.zjw.io.stream.randomAccess;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataIO {
    public static String readFixedString(int size, DataInput in) throws IOException {
        var b = new StringBuilder(size);
        int i = 0;
        boolean done = false;
        while (!done && i < size) {
            char ch = in.readChar();
            i++;
            if (ch == 0) done = true;
            else b.append(ch);
        }
        // 跳过空白填充部分
        in.skipBytes(2 * (size - i));
        return b.toString();
    }

    public static void writeFixedString(String s, int size, DataOutput out) throws IOException {
        for (int i = 0; i < size; i++) {
            char ch = 0;
            if (i < s.length()) ch = s.charAt(i);
            // 将一个由两个字节组成的值写入 char 输出流
            out.writeChar(ch);
        }
    }
}