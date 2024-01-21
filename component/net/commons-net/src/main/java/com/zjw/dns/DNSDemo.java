package com.zjw.dns;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS查询ip地址
 */
public class DNSDemo {
    public static void main(String[] args) {

        // 禁用 DNS 缓存
        System.setProperty("networkaddress.cache.ttl", "0");
        // 设置 DNS 缓存 TTL
        System.setProperty("networkaddress.cache.negative.ttl", "0");

        try {

            System.out.println(System.getProperty("networkaddress.cache.ttl"));
            System.out.println(System.getProperty("networkaddress.cache.negative.ttl"));

            // 通过主机名获取IP地址
            InetAddress address = InetAddress.getByName("www.baidu.com");
            System.out.println("IP Address: " + address.getHostAddress());

            // 通过IP地址获取主机名 不行
//            InetAddress reverseAddress = InetAddress.getByName("182.61.200.6");
//            System.out.println("Host Name: " + reverseAddress.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}