package com.zjw.npe;

import java.util.Optional;

/**
 * https://mp.weixin.qq.com/s/-640skGdyCn1wOeOPnVmEw
 * @author 朱俊伟
 * @date 2022/04/18 20:17
 */
public class OptionalTest {
    public static void main(String[] args) {
        String str = "123";
        Optional<String> optional = Optional.ofNullable(str);
        String orElse = optional.orElse("456");
        System.out.println(orElse);

    }

}
