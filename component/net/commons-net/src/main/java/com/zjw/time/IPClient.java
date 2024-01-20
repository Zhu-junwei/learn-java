package com.zjw.time;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * get IP Address，调用的是java的API
 *
 * @author 朱俊伟
 * @since 2024/01/20 1:30
 */
public class IPClient {
    public static void main(String[] args) throws UnknownHostException {
        // 本机地址
        System.out.println("InetAddress.getLocalHost() = " + InetAddress.getLocalHost());
        // 环路地址
        System.out.println("InetAddress.getLoopbackAddress() = " + InetAddress.getLoopbackAddress());
        // 根据域名返回IP地址
        InetAddress inetAddress = InetAddress.getByName("google.com");
        System.out.println(inetAddress.getHostAddress());

        // 根据域名返回多个IP地址，返回的是一个数组，数组中的每一个元素都是一个InetAddress对象。
        InetAddress[] googleIPAddress = InetAddress.getAllByName("google.com");
        for (InetAddress address : googleIPAddress) {
            System.out.println(address);
        }

    }
}
