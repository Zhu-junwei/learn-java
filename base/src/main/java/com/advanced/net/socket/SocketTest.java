package com.advanced.net.socket;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Socket测试，连接服务器，接收请求。
 * <p>
 * 测试以下 TCP/IP 服务:
 * {@code Echo（7）}、
 * {@code Discard（9）}、
 * {@code Daytime（13）}、
 * {@code Quote of the Day（17）}、
 * {@code Character Generator（19）}。
 * 需要开启Windows的{@code Simple TCP/IP Services}服务
 *
 * @author 朱俊伟
 * @since 2024/06/23 00:53
 */
public class SocketTest {


    /**
     * echo服务会将接收到的数据原样返回。
     */
    @Test
    @SneakyThrows
    public void echoTest() {
        String host = "localhost";
        try (var s = new Socket(host, 7)) { // Echo 使用端口 7
            s.setSoTimeout(5000);
            try (OutputStream out = s.getOutputStream();
                 Scanner in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8)) {
                String message = "Hello, Echo! 你好呀";
                out.write(message.getBytes(StandardCharsets.UTF_8));
                out.flush();

                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
        }
    }

    /**
     * Discard 服务会丢弃所有接收到的数据，并且不返回任何数据。为了验证这个服务，可以发送一些数据并观察没有响应。
     */
    @Test
    @SneakyThrows
    public void discardTest() {
        String host = "localhost";
        try (var s = new Socket(host, 9)) { // Discard 使用端口 9
            s.setSoTimeout(5000);
            System.out.println("connect localhost Discard 9 port : " + s.isConnected());
            try (OutputStream out = s.getOutputStream()) {
                out.write("Test data".getBytes(StandardCharsets.UTF_8));
                out.flush();
            }
            System.out.println("Data sent, no response expected.");
        }
    }

    /**
     * 获取daytime协议服务器的时间
     */
    @Test
    @SneakyThrows
    public void socketTest() {
//        String host = "time-a.nist.gov";
        String host = "localhost";
        try (var s = new Socket(host, 13)) {
            s.setSoTimeout(5000);
            try (var in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8)) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
        }
    }


    /**
     * quote of the day，返回一句名言
     */
    @Test
    @SneakyThrows
    public void quoteTest() {
        String host = "localhost";
        try (var s = new Socket(host, 17)) { // Quote of the Day 使用端口 17
            s.setSoTimeout(5000);
            try (var in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8)) {
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
        }
    }


    /**
     * Character Generator 服务会发送一个字符序列，每个字符由一个字节表示。
     */
    @Test
    @SneakyThrows
    public void characterGeneratorTest() {
        String host = "localhost";
        try (var s = new Socket(host, 19)) { // Character Generator 使用端口 19
            s.setSoTimeout(5000);
            try (var in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8)) {
                for (int i = 0; i < 10 && in.hasNextLine(); i++) {
                    String line = in.nextLine();
                    System.out.println(line);
                }
            }
        }
    }
}