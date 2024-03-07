package com.zjw.observer.observer;

/**
 * Observer（观察者）：所有观察者需要实现的接口，定义了当主题状态改变时需要调用的更新方法。
 */
public interface Observer {
    void update(float temperature);
}