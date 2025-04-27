package com.zjw.behavioral_patterns.chain_of_responsibility.handler;

import com.zjw.behavioral_patterns.chain_of_responsibility.request.Request;

/**
 * 具体处理器：CEO处理器
 */
public class CEOHandler extends Handler {
    @Override
    public void handleRequest(Request request) {
        if ("请假".equals(request.getType()) && request.getContent().contains("7天以上")) {
            System.out.println("CEO批准了" +  request.getUser() +request.getContent());
        } else if ("加薪".equals(request.getType())) {
            System.out.println("CEO需要开会讨论" +  request.getUser() +request.getContent());
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            } else {
                System.out.println("没有人能处理这个请求: " +  request.getUser() +request.getContent());
            }
        }
    }
}