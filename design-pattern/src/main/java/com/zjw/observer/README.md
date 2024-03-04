# 观察者设计模式

> 观察者设计模式是一种行为设计模式，允许对象在其状态改变时通知其他依赖对象。它创建了一种发布者（Subject）和订阅者（Observer）之间的依赖关系。这种模式经常用于实现事件处理系统。

观察者模式的关键组成部分：

`Subject（主题）`：拥有添加和删除观察者的方法，以及通知所有观察者状态变化的方法。

`Observer（观察者）`：所有观察者需要实现的接口，定义了当主题状态改变时需要调用的更新方法。

`ConcreteSubject（具体主题）`：实现Subject接口，当其状态改变时，会向所有的观察者发出通知。

`ConcreteObserver（具体观察者）`：实现Observer接口，定义当接收到主题状态变化通知时如何更新自己。

示例实现

> 以下是一个简单的观察者模式示例，演示了一个简单的天气应用，其中`WeatherStation`作为`Subject`，当天气更新时，它会通知所有注册的观察者。

```java
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
```

解释：

`WeatherStation`（具体主题）管理观察者列表并在天气（这里是温度）改变时通知它们。

`TemperatureDisplay` 和 `Fan`（具体观察者）实现了`Observer`接口，定义了如何在接收到温度更新时响应。

当`WeatherStation`的`setTemperature`方法被调用时，它会更新温度并通知所有观察者，观察者随后根据更新的信息进行相应的操作。

运行结果：

```
TemperatureDisplay: Temperature changed to: 30.0
Fan turned on
TemperatureDisplay: Temperature changed to: 20.0
Fan turned off
```