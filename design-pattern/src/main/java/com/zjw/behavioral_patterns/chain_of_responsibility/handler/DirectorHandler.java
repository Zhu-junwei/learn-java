package com.zjw.behavioral_patterns.chain_of_responsibility.handler;

import com.zjw.behavioral_patterns.chain_of_responsibility.request.Request;

/**
 * 具体处理器：总监处理器
 */
public class DirectorHandler extends Handler {
    @Override
    public void handleRequest(Request request) {
        if ("请假".equals(request.getType()) && request.getContent().contains("3-7天")) {
            System.out.println("总监批准了" +  request.getUser() +request.getContent());
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("没有人能处理这个请求: " + request.getContent());
            }
        }
    }
}