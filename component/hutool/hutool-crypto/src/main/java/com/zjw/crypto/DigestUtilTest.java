package com.zjw.crypto;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.digest.DigestUtil;
import org.junit.jupiter.api.Test;

/**
 * @author 朱俊伟
 * @since 2024/12/27 16:00
 */
public class DigestUtilTest {
    /**
     * md5加密测试
     */
    @Test
    public void md5Test() {
        String testStr = "2147483647/s/link127.0.0.1 secret";
        // 16进制形式md5
        System.out.println(DigestUtil.md5Hex(testStr));
        // 字节数组形式md5
        byte[] md5Bytes = DigestUtil.md5(testStr);
        // md5字节数组转标准Base64编码
        System.out.println(Base64.encode(md5Bytes));
        // md5字节数组转URL安全Base64编码
        String urlSafeEncode = Base64.encode(md5Bytes).replace("-","+")
                .replace("/","_")
                .replace("=","");
        System.out.println(urlSafeEncode);

    }
}
