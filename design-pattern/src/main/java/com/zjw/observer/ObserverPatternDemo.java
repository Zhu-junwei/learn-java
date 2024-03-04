package com.zjw.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer（观察者）：所有观察者需要实现的接口，定义了当主题状态改变时需要调用的更新方法。
 */
interface Observer {
    void update(float temperature);
}

/**
 * Subject（主题）：拥有添加和删除观察者的方法，以及通知所有观察者状态变化的方法。
 */
interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

/**
 * ConcreteSubject（具体主题）：实现Subject接口，当其状态改变时，会向所有的观察者发出通知。
 */
class WeatherStation implements Subject {
    private final List<Observer> observers;
    private float temperature;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}

/**
 * 温度显示器
 * ConcreteObserver（具体观察者）：实现Observer接口，定义当接收到主题状态变化通知时如何更新自己。
 */
class TemperatureDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("TemperatureDisplay: Temperature changed to: " + temperature);
    }
}

/**
 * 风扇
 * ConcreteObserver（具体观察者）：实现Observer接口，定义当接收到主题状态变化通知时如何更新自己。
 */
class Fan implements Observer {
    @Override
    public void update(float temperature) {
        if(temperature > 25) {
            System.out.println("Fan turned on");
        } else {
            System.out.println("Fan turned off");
        }
    }
}

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