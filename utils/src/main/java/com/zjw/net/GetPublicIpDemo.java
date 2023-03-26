package com.zjw.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 朱俊伟
 * @date 2023/03/26 23:29
 */
public class GetPublicIpDemo {

    public static String GetPublicIp() {
        String IP = null;
        try {
            URL url = new URL("http://checkip.amazonaws.com/");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            IP = reader.readLine();
            String pattern = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(IP);
            if (m.find()) {
                IP = m.group();
            }
            System.out.println("Public IP address is: " + IP);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return IP;
    }
}