package StrategyPattern;

import StrategyPattern.strategy.DrivingStrategy;

public class SpecialCar extends Vehicle {
    SpecialCar(DrivingStrategy drivingStrategy) {
        super(drivingStrategy);
    }

    public void drive() {
        drivingStrategy.drive();
    }
}
