package com.zjw.crypto;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.junit.jupiter.api.Test;

/**
 * 加密解密工具-SecureUtil
 *
 * @author 朱俊伟
 * @since 2024/03/02 23:50
 */
public class SecureUtilTest {

    /**
     * AES对称加密
     */
    @Test
    public void testAES() {
        AES aes = SecureUtil.aes();
        String decrypt = aes.encryptBase64("你好");
        System.out.println("decrypt = " + decrypt);
        String data = aes.decryptStr(decrypt);
        System.out.println("data = " + data);
    }
}
