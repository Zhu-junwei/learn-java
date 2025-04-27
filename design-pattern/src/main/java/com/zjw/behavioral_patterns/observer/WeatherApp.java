package com.zjw.behavioral_patterns.observer;

import com.zjw.behavioral_patterns.observer.observer.WeatherObserve.CurrentConditionsDisplay;
import com.zjw.behavioral_patterns.observer.observer.WeatherObserve.ForecastDisplay;
import com.zjw.behavioral_patterns.observer.observer.WeatherObserve.StatisticsDisplay;
import com.zjw.behavioral_patterns.observer.subject.WeatherSubject;

public class WeatherApp {
    public static void main(String[] args) {
        // 创建主题
        WeatherSubject weatherSubject = new WeatherSubject();
        
        // 创建观察者
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        
        // 注册观察者
        weatherSubject.registerObserver(currentDisplay);
        weatherSubject.registerObserver(statisticsDisplay);
        weatherSubject.registerObserver(forecastDisplay);
        
        // 使用Lambda表达式也可以注册观察者
        weatherSubject.registerObserver(data ->
            System.out.println("【Lambda观察者】数据更新: " + data));
        
        // 模拟天气数据变化
        System.out.println("=== 第一次数据更新 ===");
        weatherSubject.setMeasurements(26.5f, 65, 1013.2f);
        
        System.out.println("\n=== 第二次数据更新 ===");
        weatherSubject.setMeasurements(30.2f, 70, 1012.8f);
        
        System.out.println("\n=== 第三次数据更新 ===");
        weatherSubject.setMeasurements(8.5f, 55, 1020.0f);
        
        // 移除一个观察者
        weatherSubject.removeObserver(statisticsDisplay);
        
        System.out.println("\n=== 第四次数据更新(移除了统计观察者) ===");
        weatherSubject.setMeasurements(22.0f, 60, 1015.0f);
    }
}