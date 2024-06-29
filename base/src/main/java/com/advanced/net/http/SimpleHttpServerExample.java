package com.advanced.net.http;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * 使用 JDK 内置的 HttpServer 来创建简单的 HTTP 服务
 */
public class SimpleHttpServerExample {

    public static void main(String[] args) throws IOException {
        // 创建一个 HttpServer 实例，绑定在指定的端口上
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        // 创建一个上下文路径为 "/hello" 的处理器，并注册到 HttpServer 中
        server.createContext("/hello", new HelloHandler());
        // 设置线程池，指定处理器的最大并发数
        server.setExecutor(null);
        // 启动 HttpServer，开始监听来自客户端的连接
        server.start();

        System.out.println("Server is running on port 8000...");
        System.out.println("http://localhost:8000/hello");
    }

    // 自定义处理器，处理 "/hello" 路径的 HTTP 请求
    static class HelloHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Hello, this is a simple HTTP server!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream outputStream = exchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }
}