package com.advanced.net.socket;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Socket测试，连接服务器，接收请求
 *
 * @author 朱俊伟
 * @since 2024/06/23 00:53
 */
public class SocketTest {

    /**
     * 获取daytime协议服务器的时间
     */
    @Test
    @SneakyThrows
    public void socketTest() {
        String host = "time-a.nist.gov";
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


}
