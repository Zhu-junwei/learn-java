package com.zjw.behavioral_patterns.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体中介者 - 聊天室实现
 */
public class ChatRoom implements ChatMediator {
    private final List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, User from, User to) {

        for (User u : users) {
            // 消息不应该被发送者自己收到
            if (u == to) {
                u.receive(from, msg);
            }
        }
    }

    @Override
    public void sendMessage(String msg, User user) {

        for (User u : users) {
            // 消息不应该被发送者自己收到
            if (u != user) {
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}