package com.zjw.net;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zjw
 * @date 2023/06/30 9:27
 */
public class NetUtilTest {

    @Test
    public void getPublicIP() {
        System.out.println(NetUtil.getPublicIP());
    }
}