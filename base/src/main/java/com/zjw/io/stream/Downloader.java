package com.zjw.io.stream;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 使用InputStream和OutputStream下载文件
 */
public class Downloader {

    public static void main(String[] args) {

        String url = "https://dldir1v6.qq.com/weixin/Windows/WeChatSetup.exe";
        String fileName = "WeChatSetup.exe";

        System.out.printf("Downloading file: %s from %s\n", fileName, url);
        try (BufferedInputStream in = new BufferedInputStream(new URI(url).toURL().openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("Downloaded done.");
        } catch (IOException | URISyntaxException e) {
            System.err.println("Error downloading file: " + url);
            e.printStackTrace();
        }
    }
}
