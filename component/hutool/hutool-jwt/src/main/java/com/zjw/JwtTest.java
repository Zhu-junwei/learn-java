package com.zjw;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTHeader;

import java.util.Base64;
import java.util.Date;

/**
 * JSON Web Token 测试
 *
 * @author 朱俊伟
 * @since 2024/06/15 10:58
 */
public class JwtTest {
    public static void main(String[] args) {
        // 密钥
        byte[] key = "1234567890".getBytes();
        // HS256(HmacSHA256)算法
        String token = JWT.create()
                .setExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .setPayload("sub", "1234567890")
                .setPayload("name", "looly")
                .setPayload("admin", true)
                .setKey(key)
                .sign();
        System.out.println("token = " + token);

        // 解析token，获取里面的数据，并不依赖key
        parseJWT(token);

        // 默认验证HS256的算法
        boolean verified = JWT.of(token).setKey(key).verify();
        System.out.println("verified = " + verified);
        boolean validate = JWT.of(token).setKey(key).validate(0L);
        System.out.println("validate = " + validate);
    }

    private static void parseJWT(String token) {
        System.out.println("********parseJWT********");
        JWT jwt = JWT.of(token);
        // JWT
        Object type = jwt.getHeader(JWTHeader.TYPE);
        System.out.println("type = " + type);
        Object algorithm = jwt.getHeader(JWTHeader.ALGORITHM);
        System.out.println("algorithm = " + algorithm);
        System.out.println("jwt.getPayload(\"sub\") = " + jwt.getPayload("sub"));
        System.out.println("jwt.getPayload(\"name\") = " + jwt.getPayload("name"));
        System.out.println("jwt.getPayload(\"admin\") = " + jwt.getPayload("admin"));
        System.out.println(new String(Base64.getDecoder().decode(token.split("\\.")[0])));
        System.out.println(new String(Base64.getDecoder().decode(token.split("\\.")[1])));
    }
}
