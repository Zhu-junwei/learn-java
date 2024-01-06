package com.zjw.net;

import org.junit.jupiter.api.Test;

/**
 * 测试网络工具类
 * @author zjw
 * @since 2023/06/30 9:27
 */
public class NetUtilTest {

    @Test
    public void getPublicIP() {
        System.out.println(NetUtil.getPublicIP());
    }
}