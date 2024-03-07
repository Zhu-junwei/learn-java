package com.zjw.observer.subject;

import com.zjw.observer.observer.Observer;

/**
 * Subject（主题）：拥有添加和删除观察者的方法，以及通知所有观察者状态变化的方法。
 */
public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}