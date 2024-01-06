package com.zjw._03._06_pipe;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.io.*;

/**
 * 管道流测试类，使用管道流实现字符流通信
 * 使用PipedWriter与PipedReader连接，向管道流中写入数据，然后从管道流中读取数据
 * @author 朱俊伟
 * @since 2023/03/19 22:27
 */
public class CharStreamTest {

    @SneakyThrows
    public static void main(String[] args) {

        // 创建写数据线程和读数据线程所需的类
        WriteCharData writeCharData = new WriteCharData();
        ReadCharData readCharData = new ReadCharData();

        // 创建PipedWriter和PipedReader，并将它们连接起来
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);

        // 创建写数据线程和读数据线程
        WriteCharThread writeCharThread = new WriteCharThread(writeCharData, writer);
        ReadCharThread readCharThread = new ReadCharThread(readCharData, reader);

        // 启动线程
        writeCharThread.start();
        readCharThread.start();
    }
}

/**
 * 用于写入数据的线程类
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
class WriteCharThread extends Thread {
    private WriteCharData writeCharData;
    private PipedWriter writer;

    @Override
    public void run() {
        writeCharData.writeMethod(writer);
    }
}

/**
 * 用于读取数据的线程类
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
class ReadCharThread extends Thread {
    private ReadCharData readCharData;
    private PipedReader reader;

    @Override
    public void run() {
        readCharData.readMethod(reader);
    }
}

/**
 * 用于写入数据的类
 */
class WriteCharData {
    /**
     * 向管道流中写入数据的方法
     * @param writer 管道写入流
     */
    public void writeMethod(PipedWriter writer) {
        try {
            System.out.println("write:");
            // 循环写入数据
            for (int i = 0; i < 300; i++) {
                String data = i + "";
                writer.write(data);
                System.out.print(data);
            }
            System.out.println();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * 用于读取数据的类
 */
class ReadCharData {
    /**
     * 从管道流中读取数据的方法
     * @param reader 管道读取流
     */
    public void readMethod(PipedReader reader) {
        try {
            System.out.println("read:");
            // 创建缓冲区，读取数据
            char[] bytes = new char[20];
            int length = reader.read(bytes);
            while (length != -1) {
                String data = new String(bytes, 0, length);
                System.out.print(data);
                length = reader.read(bytes);
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
