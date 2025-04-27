package com.zjw.behavioral_patterns.chain_of_responsibility.request;

/**
 * 请求类
 */
public class Request {
    private String type;
    private String user;
    private String content;

    public Request(String type, String user, String content) {
        this.type = type;
        this.user = user;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }
}