package com.zjw.proxy.proxy2;

import java.util.Map;

/**
 * @author 朱俊伟
 * @since 2021/02/20
 */
public interface Service {

    boolean login(String username, String password);

    Map<String, Object> getUserInfo(String username);

}
