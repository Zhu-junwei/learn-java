package com.feature.java14.records;

public record Vehicle(String make, String model, int year) {
    public Vehicle {
        model = model == null ? "Unknown123" : model;
    }
}