package com.zjw.creational_patterns.builder.demo1.builders;

import com.zjw.creational_patterns.builder.demo1.cars.Car;
import com.zjw.creational_patterns.builder.demo1.cars.CarType;
import com.zjw.creational_patterns.builder.demo1.components.Engine;
import com.zjw.creational_patterns.builder.demo1.components.GPSNavigator;
import com.zjw.creational_patterns.builder.demo1.components.Transmission;
import com.zjw.creational_patterns.builder.demo1.components.TripComputer;

/**
 * 汽车生成器
 * <p>
 * Concrete builders implement steps defined in the common interface.
 */
public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}