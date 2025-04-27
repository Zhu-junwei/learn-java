package com.zjw.behavioral_patterns.observer.data;

public record WeatherData(float temperature, float humidity, float pressure) {
    @Override
    public String toString() {
        return String.format("温度: %.1f°C, 湿度: %.1f%%, 气压: %.1fhPa", 
                           temperature, humidity, pressure);
    }
}