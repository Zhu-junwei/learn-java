package com.zjw.heartbeat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 心跳客户端
 */
public class HeartbeatClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8080;

        while (true) {
            try (Socket socket = new Socket(serverAddress, serverPort);
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                // Send heartbeat
                writer.println("Heartbeat");

                // Wait for response
                String response = reader.readLine();
                System.out.println("Received response: " + response);

                // Pause for a moment (simulating a heartbeat interval)
                Thread.sleep(5000);

            } catch (IOException | InterruptedException e) {
                // Handle connection failure
                System.out.println("Connection failed. Retrying in 5 seconds...");
                try {
                    // Pause before retrying
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
