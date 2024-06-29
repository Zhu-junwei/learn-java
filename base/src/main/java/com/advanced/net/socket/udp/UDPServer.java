package com.advanced.net.socket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP接收消息服务器
 */
public class UDPServer {
    public static void main(String[] args) {
        int port = 9876;

        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            System.out.println("UDP Server listening on port " + port);
            byte[] receiveData = new byte[4096];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // 服务器在没有收到消息的时候会一直阻塞在这里，所以在开发中需要开启一个线程来处理来自客户端的连接
                serverSocket.receive(receivePacket);

                // 开启新线程处理通信
                new Thread(() -> {
                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    InetAddress receiveAddress = receivePacket.getAddress();
                    int receivePort = receivePacket.getPort();
                    System.out.println("Received message from client[" + receiveAddress.getHostAddress()+":"+ receivePort+ "]: " + message);

                    // 你可以在这里添加服务器端的处理逻辑

                    // Respond to the client
                    String responseMessage = "Hello, client!";
                    byte[] sendData = responseMessage.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receiveAddress, receivePort);

                    try {
                        serverSocket.send(sendPacket);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}