package com.zjw.behavioral_patterns.observer.observer.WeatherObserve;

import com.zjw.behavioral_patterns.observer.data.WeatherData;
import com.zjw.behavioral_patterns.observer.observer.Observer;

/**
 * 具体观察者二：天气统计
 */
public class StatisticsDisplay implements Observer<WeatherData> {
    @Override
    public void update(WeatherData data) {
        System.out.println("【天气统计】" + data);
    }
}