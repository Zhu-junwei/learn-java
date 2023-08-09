package com.zjw.base64;


import lombok.SneakyThrows;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * 测试Base64类
 */
public class Base64Test {

    /**
     * 测试Encode
     */
    @Test
    public void testEncode() {
        String str = "你好";
        Base64.Encoder encoder = Base64.getEncoder();
        String encode = encoder.encodeToString(str.getBytes());
        System.out.println(encode);
    }

    /**
     * 测试Decode
     */
    @Test
    @SneakyThrows
    public void testDecode() {
        String str = "5L2g5aW9";
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(str);
        System.out.println(Arrays.toString(decode));
        System.out.println(new String(decode,"UTF-8"));
        System.out.println(new String(decode,"GBK"));
        System.out.println(new String(decode, "US-ASCII"));
        System.out.println(new String(decode, "ISO-8859-1"));
        System.out.println(new String(decode, "UTF-16BE"));
        System.out.println(new String(decode, "UTF-16LE"));
        System.out.println(new String(decode, "UTF-16"));
    }

    /**
     * 测试UrlEncode
     * 用于进行 URL 安全的 BASE64 编码。URL 安全的 BASE64 编码是为了在 URL 中传输数据而设计的，它使用 - 替代 +，使用 _ 替代 /，并且可以省略结尾的 =。
     */
    @Test
    public void testUrlEncode() {
        String originalData = "你好";
        // 进行 BASE64 编码并将结果作为 URL 参数传递
        Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        String encodedData = urlEncoder.encodeToString(originalData.getBytes(StandardCharsets.UTF_8));
        String url = "https://example.com/api?data=" + encodedData;
        System.out.println("URL: " + url);
    }

    /**
     * 把 URL 中的 BASE64 码解码为字符串
     */
    @Test
    public void testUrlDecode() {
        String url = "https://example.com/api?data=5L2g5aW9";
        // 解码 URL 中的 BASE64 数据
        Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        byte[] data = urlDecoder.decode(url.substring(url.lastIndexOf("=") + 1));
        System.out.println(new String(data, StandardCharsets.UTF_8));
    }
}
