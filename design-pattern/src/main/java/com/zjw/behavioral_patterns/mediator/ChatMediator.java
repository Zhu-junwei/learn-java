package com.zjw.behavioral_patterns.mediator;

/**
 * 中介者接口
 */
public interface ChatMediator {
    /**
     * 发送消息给指定的人
     */
    void sendMessage(String msg, User user, User to);

    /**
     * 发送消息给所有
     */
    void sendMessage(String msg, User user);

    /**
     * 添加用户
     */
    void addUser(User user);
}