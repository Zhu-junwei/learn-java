package com.zjw.behavioral_patterns.chain_of_responsibility;

import com.zjw.behavioral_patterns.chain_of_responsibility.handler.CEOHandler;
import com.zjw.behavioral_patterns.chain_of_responsibility.handler.DirectorHandler;
import com.zjw.behavioral_patterns.chain_of_responsibility.handler.Handler;
import com.zjw.behavioral_patterns.chain_of_responsibility.handler.ManagerHandler;
import com.zjw.behavioral_patterns.chain_of_responsibility.request.Request;

/**
 * 测试类
 */
public class Demo {
    public static void main(String[] args) {
        // 创建处理器
        Handler manager = new ManagerHandler();
        Handler director = new DirectorHandler();
        Handler ceo = new CEOHandler();

        // 构建责任链
        manager.setNextHandler(director);
        director.setNextHandler(ceo);

        // 创建请求
        Request request1 = new Request("请假", "张三","3天以内");
        Request request2 = new Request("请假", "李四","3-7天");
        Request request3 = new Request("请假", "王五","7天以上");
        Request request4 = new Request("加薪", "赵六","申请加薪");
        Request request5 = new Request("采购", "前台","采购一批电脑");

        // 处理请求
        manager.handleRequest(request1);
        manager.handleRequest(request2);
        manager.handleRequest(request3);
        manager.handleRequest(request4);
        manager.handleRequest(request5);
    }
}