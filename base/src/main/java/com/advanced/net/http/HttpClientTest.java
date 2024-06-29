package com.advanced.net.http;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试使用HttpClient发送请求
 *
 * @author 朱俊伟
 * @since 2024/06/29 00:42
 */
public class HttpClientTest {

    @Test
    @SneakyThrows
    public void testHttpClientGet() {
        // 创建一个 HttpClient 实例
        HttpClient client = HttpClient.newHttpClient();

        // 构建一个 HttpRequest 发送一个 GET 请求
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.baidu.com"))
                .GET() // 默认是GET请求
                .build();

        // 发送请求并处理响应
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        printResponse(response);
    }

    /**
     * 发送异步请求
     */
    @Test
    @SneakyThrows
    public void testHttpClientAsync() {
        // 可以异步地处理响应。 在构建客户端时， 可以提供一个执行器
        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建一个 HttpClient 实例
        HttpClient client = HttpClient.newBuilder()
                .executor(executor)
                .build();

        // 构建一个 HttpRequest 发送一个 GET 请求
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.baidu.com"))
                .GET() // 默认是GET请求
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(this::printResponse)
                .join(); // 等待执行完成

    }

    /**
     * 打印响应的结果
     */
    private void printResponse(HttpResponse<String> response) {
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Headers:");
        response.headers().map().forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("Response Body: " + response.body());
    }
}
