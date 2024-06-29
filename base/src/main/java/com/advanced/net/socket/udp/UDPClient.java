package com.advanced.net.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP发送消息客户端
 */
public class UDPClient {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 9876;
        int timeoutMillis = 5000; // 超时时间，单位为毫秒

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(serverHost);
            Scanner scanner = new Scanner(System.in);
            byte[] receiveData = new byte[4096];
            while (true) {
                // Send data to server
                System.out.println("请输入要发送的信息：");
                String message = scanner.nextLine();
                if ("".equals(message) || message == null)
                    continue;
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                clientSocket.send(sendPacket);

                // Set a timeout for receiving response
                clientSocket.setSoTimeout(timeoutMillis);

                // Receive response from server
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                clientSocket.receive(receivePacket);
                InetAddress receiveAddress = receivePacket.getAddress();
                int receivePort = receivePacket.getPort();
                String responseMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received response from server[" + receiveAddress.getHostAddress() + ":" + receivePort + "]: " + responseMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}