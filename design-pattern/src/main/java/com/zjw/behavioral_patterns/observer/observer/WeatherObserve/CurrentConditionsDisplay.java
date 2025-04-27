package com.zjw.behavioral_patterns.observer.observer.WeatherObserve;

import com.zjw.behavioral_patterns.observer.data.WeatherData;
import com.zjw.behavioral_patterns.observer.observer.Observer;

/**
 * 具体观察者一：当前天气状况
 */
public class CurrentConditionsDisplay implements Observer<WeatherData> {
    @Override
    public void update(WeatherData data) {
        System.out.println("【当前天气状况】" + data);
    }
}
