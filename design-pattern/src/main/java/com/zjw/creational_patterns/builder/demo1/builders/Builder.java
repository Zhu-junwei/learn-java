package com.zjw.creational_patterns.builder.demo1.builders;

import com.zjw.creational_patterns.builder.demo1.cars.CarType;
import com.zjw.creational_patterns.builder.demo1.components.Engine;
import com.zjw.creational_patterns.builder.demo1.components.GPSNavigator;
import com.zjw.creational_patterns.builder.demo1.components.Transmission;
import com.zjw.creational_patterns.builder.demo1.components.TripComputer;

/**
 * 通用生成器接口
 * <p>
 * Builder interface defines all possible ways to configure a product.
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}