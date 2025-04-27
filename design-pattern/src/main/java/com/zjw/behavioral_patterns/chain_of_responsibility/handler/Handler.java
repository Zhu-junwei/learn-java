package com.zjw.behavioral_patterns.chain_of_responsibility.handler;

import com.zjw.behavioral_patterns.chain_of_responsibility.request.Request;

/**
 * 抽象处理器
 */
public abstract class Handler {
    protected Handler nextHandler;

    // 设置下一个处理者
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // 处理请求的方法
    public abstract void handleRequest(Request request);
}