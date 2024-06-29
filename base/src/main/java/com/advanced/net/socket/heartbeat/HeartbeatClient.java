package com.advanced.net.socket.heartbeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 心跳客户端
 */
public class HeartbeatClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8080;

        // 定义初始等待时间、最小和最大等待时间
        long waitTime = 1000; // 初始等待时间为1秒
        long minWaitTime = 1000; // 最小等待时间为1秒
        long maxWaitTime = 60000; // 最大等待时间为1分钟

        while (true) {
            try (Socket socket = new Socket(serverAddress, serverPort);
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // 发送心跳
                writer.println("Heartbeat");

                // 等待响应
                String response = reader.readLine();
                System.out.println(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                        + " Received response: " + response);

                // 成功响应后增加等待时间，直到最大等待时间
                waitTime = Math.min(waitTime + 1000, maxWaitTime);

            } catch (IOException e) {
                // 每一秒重新连接
                waitTime = minWaitTime;
                // 处理连接失败
                System.out.println(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                        " Connection failed. Retrying in " + (waitTime / 1000) + " seconds...");

            }

            try {
                // 暂停指定的等待时间
                Thread.sleep(waitTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}