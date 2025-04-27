package com.zjw.behavioral_patterns.observer.observer.WeatherObserve;

import com.zjw.behavioral_patterns.observer.data.WeatherData;
import com.zjw.behavioral_patterns.observer.observer.Observer;

/**
 * 具体观察者三：天气预报
 */
public class ForecastDisplay implements Observer<WeatherData> {
    @Override
    public void update(WeatherData data) {
        String forecast = data.temperature() > 28 ? "炎热天气" : 
                        data.temperature() < 10 ? "寒冷天气" : "舒适天气";
        System.out.println("【天气预报】未来将出现" + forecast);
    }
}