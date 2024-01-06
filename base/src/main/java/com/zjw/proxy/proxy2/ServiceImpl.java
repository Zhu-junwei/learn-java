package com.zjw.proxy.proxy2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱俊伟
 * @since 2021/02/20
 */

public class ServiceImpl implements Service {

    /**
     * 登录
     */
    @Override
    public boolean login(String username, String password) {
        simulateDaOperation(100);
        System.out.println("用户名：" + username + ", 密码：" + password + "  登录成功");
        return true;
    }

    /**
     * 根据用户名获取用户信息
     */
    @Override
    public Map<String, Object> getUserInfo(String username) {
        Map<String, Object> userInfo = new HashMap<>();
        simulateDaOperation(150);
        userInfo.put("username", username);
        userInfo.put("sex", "男");
        userInfo.put("age", 18);
        System.out.println("用户名：" + username + ", 获取用户信息：" + userInfo);
        return userInfo;
    }

    /**
     * 模拟数据库操作，休眠
     *
     * @param millis 毫秒数
     */
    private void simulateDaOperation(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}