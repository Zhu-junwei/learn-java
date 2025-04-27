package com.zjw.behavioral_patterns.mediator;

/**
 * 具体用户类
 */
public class ChatUser extends User {
    public ChatUser(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + " 发送消息: " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void send(User to, String msg) {
        System.out.println(this.name + " 发送消息给" +to.name + ": " + msg);
        mediator.sendMessage(msg, this, to);
    }

    @Override
    public void receive(User from, String msg) {
        System.out.println(this.name + " 收到" + from.name + "私信消息: " + msg);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + " 收到广播消息: " + msg);
    }
}