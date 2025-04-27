package com.zjw.behavioral_patterns.mediator;

/**
 * 抽象用户类
 */
public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void send(User to, String msg);
    public abstract void receive(User from , String msg);
    public abstract void receive(String msg);
}
