package com.advanced.net.socket.tcp;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TCP发送消息服务器
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        int port = 9876;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP Server listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new TCPServerHandler(clientSocket)).start();
            }
        }
    }

}

class TCPServerHandler implements Runnable {
    private final Socket clientSocket;

    public TCPServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @SneakyThrows
    @Override
    public void run() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String hostPost = clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort();
            System.out.println("Client connected: " + clientSocket.getLocalPort() + " <- " + hostPost);

            String message;
            boolean done = false;
            while ((message = reader.readLine()) != null && !done) {

                System.out.printf("Received [%s]: %s\n", hostPost, message);

                String responseMessage = "Hello, client! " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                // You can add your server-side processing here
                if ("quit".equalsIgnoreCase(message)
                        || "exit".equalsIgnoreCase(message)
                        || "bye".equalsIgnoreCase(message)) {
                    responseMessage = "Bye";
                    done = true;
                }

                // Respond to the client
                writer.println(responseMessage);
            }
        }
    }
}
