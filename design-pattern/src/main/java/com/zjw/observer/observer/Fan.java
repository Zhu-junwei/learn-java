package com.zjw.observer.observer;

/**
 * 风扇
 * ConcreteObserver（具体观察者）：实现Observer接口，定义当接收到主题状态变化通知时如何更新自己。
 */
public class Fan implements Observer {
    @Override
    public void update(float temperature) {
        if(temperature > 25) {
            System.out.println("Fan turned on");
        } else {
            System.out.println("Fan turned off");
        }
    }
}