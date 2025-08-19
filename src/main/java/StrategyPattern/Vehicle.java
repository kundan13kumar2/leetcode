package StrategyPattern;

import StrategyPattern.strategy.DrivingStrategy;

public class Vehicle {
    DrivingStrategy drivingStrategy;

    Vehicle(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
    }

    public void drive(){
        drivingStrategy.drive();
    }
}
