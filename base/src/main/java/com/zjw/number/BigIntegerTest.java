package com.zjw.number;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * @author 朱俊伟
 * @since 2024/04/07 22:37
 */
public class BigIntegerTest {

    /**
     * 测试使用BigInteger add加法
     */
    @Test
    public void addTest() {
        BigInteger bigInteger = new BigInteger("12312312412456789098765434567899876543456789876");
        BigInteger result = bigInteger.add(new BigInteger("1"));
        System.out.println(result);
    }

    /**
     * 测试使用BigInteger modPow
     * <p>
     * 2<sup>3</sup> mod 5 = 3
     */
    @Test
    public void modPowTest() {
        // 2^3 mod 5 = 3
        BigInteger bigInteger = new BigInteger("2");
        BigInteger result = bigInteger.modPow(new BigInteger("3"), new BigInteger("5"));
        System.out.println(result);
    }
}
