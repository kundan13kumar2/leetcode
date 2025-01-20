package StrategyPattern;

import StrategyPattern.strategy.DrivingStrategy;

public class SportsCar extends Vehicle {
    SportsCar(DrivingStrategy drivingStrategy) {
        super(drivingStrategy);
    }

    public void drive() {
        drivingStrategy.drive();
    }
}
