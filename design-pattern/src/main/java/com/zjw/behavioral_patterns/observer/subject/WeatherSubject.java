package com.zjw.behavioral_patterns.observer.subject;


import com.zjw.behavioral_patterns.observer.data.WeatherData;
import com.zjw.behavioral_patterns.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteSubject（具体主题）：实现Subject接口，当其状态改变时，会向所有的观察者发出通知。
 */
public class WeatherSubject implements Subject<WeatherData> {
    private final List<Observer<WeatherData>> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer<WeatherData> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<WeatherData> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(WeatherData data) {
        observers.forEach(observer -> observer.update(data));
    }

    /**
     * 设置天气数据
     * @param temperature 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        WeatherData data = new WeatherData(temperature, humidity, pressure);
        // 通知所有观察者
        notifyObservers(data);
    }
}
