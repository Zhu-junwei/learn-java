package com.zjw._03._06_pipe;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Java IO中的管道流实现的字节流
 */
public class ByteStreamTest {

    @SneakyThrows
    public static void main(String[] args) {

        // 创建写入数据的对象和读取数据的对象
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();

        // 创建管道输出流和管道输入流，并将它们连接起来
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream();
        outputStream.connect(inputStream);

        // 创建写入数据的线程和读取数据的线程
        WriteThread writeThread = new WriteThread(writeData, outputStream);
        ReadThread readThread = new ReadThread(readData, inputStream);

        // 启动线程
        writeThread.start();
        readThread.start();
    }
}

// 写入数据的线程
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
class WriteThread extends Thread {
    private WriteData writeData;
    private PipedOutputStream outputStream;

    @Override
    public void run() {
        // 调用写入数据对象的写入方法
        writeData.writeMethod(outputStream);
    }
}

// 读取数据的线程
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
class ReadThread extends Thread {
    private ReadData readData;
    private PipedInputStream inputStream;

    @Override
    public void run() {
        // 调用读取数据对象的读取方法
        readData.readMethod(inputStream);
    }
}

// 写入数据的对象
class WriteData {
    public void writeMethod(PipedOutputStream outputStream) {
        try {
            System.out.println("write:");
            // 循环写入300条数据
            for (int i = 0; i < 300; i++) {
                String data = i + "";
                outputStream.write(data.getBytes()); // 将数据转为字节数组写入管道输出流中
                System.out.print(data);
            }
            System.out.println();
            outputStream.close(); // 关闭管道输出流
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

// 读取数据的对象
class ReadData {
    public void readMethod(PipedInputStream inputStream) {
        try {
            System.out.println("read:");
            byte[] bytes = new byte[20];
            int length = inputStream.read(bytes); // 从管道输入流中读取数据到字节数组中
            while (length != -1) {
                String data = new String(bytes, 0, length);
                System.out.print(data);
                length = inputStream.read(bytes);
            }
            System.out.println();
            inputStream.close(); // 关闭管道输入流
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
