package com.zjw.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP发送消息客户端
 */
public class TCPClient {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 9876;

        try (Socket socket = new Socket(serverHost, serverPort);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("TCP Client connected to server");

            while (true) {
                // Send data to server
                System.out.println("请输入要发送的信息：");
                String message = scanner.nextLine();
                if ("".equals(message) || message == null)
                    continue;

                writer.println(message);

                // Receive response from server
                String responseMessage = reader.readLine();
                System.out.println("Received response from server: " + responseMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}