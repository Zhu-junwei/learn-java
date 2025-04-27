package com.zjw.behavioral_patterns.observer.subject;

import com.zjw.behavioral_patterns.observer.observer.Observer;

/**
 * Subject（主题）：拥有添加和删除观察者的方法，以及通知所有观察者状态变化的方法。
 */
public interface Subject<T> {
    void registerObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers(T data);
}