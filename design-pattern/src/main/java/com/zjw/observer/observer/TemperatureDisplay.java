package com.zjw.observer.observer;

/**
 * 温度显示器
 * ConcreteObserver（具体观察者）：实现Observer接口，定义当接收到主题状态变化通知时如何更新自己。
 */
public class TemperatureDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("TemperatureDisplay: Temperature changed to: " + temperature);
    }
}
