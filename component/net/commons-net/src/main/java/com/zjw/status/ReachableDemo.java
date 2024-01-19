package com.zjw.status;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 判断主机是否可达
 *
 * @author 朱俊伟
 * @since 2024/01/20 2:03
 */
public class ReachableDemo {

    public static void main(String[] args) {
        String host = "google.com";
        int port = 80; // 可以根据需要更改端口号

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(host, port), 5000); // 设置超时时间（毫秒）

            // 如果连接成功，主机可达
            System.out.println("Host is reachable.");

            // 关闭 Socket 连接
            socket.close();
        } catch (Exception e) {
            System.out.println("Host is not reachable.");
            e.printStackTrace();
        }
    }
}
