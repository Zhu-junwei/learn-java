package com.zjw.behavioral_patterns.chain_of_responsibility.handler;

import com.zjw.behavioral_patterns.chain_of_responsibility.request.Request;

/**
 * 具体处理器：经理处理器
 */
public class ManagerHandler extends Handler {
    @Override
    public void handleRequest(Request request) {
        if ("请假".equals(request.getType()) && request.getContent().contains("3天以内")) {
            System.out.println("经理批准了" + request.getUser() + request.getContent());
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("没有人能处理这个请求: " + request.getContent());
            }
        }
    }
}