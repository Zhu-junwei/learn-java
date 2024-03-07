package com.zjw.observer;

import com.zjw.observer.observer.Fan;
import com.zjw.observer.observer.TemperatureDisplay;
import com.zjw.observer.subject.WeatherStation;


/**
 * 测试观察者模式
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        TemperatureDisplay display = new TemperatureDisplay();
        Fan fan = new Fan();

        station.addObserver(display);
        station.addObserver(fan);

        station.setTemperature(30);
        station.setTemperature(20);
    }
}