package com.zjw.geoip2;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

/**
 * 只有一个Country数据库，获取国家信息
 *
 * @author jw
 * @since 2025/04/30 23:19
 */
public class Demo {

    private static DatabaseReader reader;
    public static void main(String[] args) throws IOException, GeoIp2Exception {
        // 1. 初始化数据库读取器
        initGepoIp2();

        // 2. 准备要查询的IP
//        String ip = "182.61.200.110";
//        InetAddress ipAddress = InetAddress.getByName(ip);
        InetAddress address = InetAddress.getByName("www.baidu.com");


        // 3. 执行查询 - 使用country()方法而不是city()
        CountryResponse response = reader.country(address);

        // 4. 解析结果
        Country country = response.getCountry();

        System.out.println("IP: " + address.getHostAddress());
        System.out.println("国家: " + country.getName() + " (" + country.getIsoCode() + ")");
    }

    private static void initGepoIp2() throws IOException {
        InputStream inputStream = Demo.class.getClassLoader().getResourceAsStream("Country.mmdb");
        reader = new DatabaseReader.Builder(inputStream).build();
    }
}
