package com.zjw.behavioral_patterns.mediator;

/**
 * 测试类
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatRoom();
        
        User user1 = new ChatUser(mediator, "张三");
        User user2 = new ChatUser(mediator, "李四");
        User user3 = new ChatUser(mediator, "王五");
        User user4 = new ChatUser(mediator, "赵六");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);
        mediator.addUser(user4);
        
        user1.send("大家好！");
        System.out.println();
        user3.send(user1, "今天天气不错！");
    }
}