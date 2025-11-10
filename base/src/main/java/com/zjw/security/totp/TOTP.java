package com.zjw.security.totp;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;

/**
 * 
 * TOTP（Time-based One-Time Password）时间动态验证码生成器。
 */
public class TOTP {

    /** 生成 TOTP */
    public static String generateTOTP(byte[] key, long timestep, int digits) throws Exception {
        // 将时间步转换成 8 字节 big-endian
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(timestep);
        byte[] timeBytes = buffer.array();

        // HMAC-SHA1
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(key, "HmacSHA1"));
        byte[] hash = mac.doFinal(timeBytes);

        // 动态截断（Dynamic Truncation）
        int offset = hash[hash.length - 1] & 0x0F;
        int binary = ((hash[offset] & 0x7f) << 24)
                | ((hash[offset + 1] & 0xff) << 16)
                | ((hash[offset + 2] & 0xff) << 8)
                | (hash[offset + 3] & 0xff);

        int otp = binary % (int) Math.pow(10, digits);

        // 前导零补齐
        return String.format("%0" + digits + "d", otp);
    }

    public static void main(String[] args) throws Exception {
        // 假设给定的 secret 是 Base32 格式（例如 otpauth:// 里的 secret）
        String secretB32 = "GDDEGGYHDBWDGRNQPZV3UILYAPF7XS4Y";
        byte[] secretBytes = Base32.decode(secretB32); // 解码成密钥字节

        while (true) {
            long timestep = (System.currentTimeMillis() / 1000) / 30;
            String totp = generateTOTP(secretBytes, timestep, 6); // 6 位
            System.out.println(LocalDateTime.now() + " 当前 TOTP 验证码: " + totp);
            Thread.sleep(1000);
        }
    }
}
