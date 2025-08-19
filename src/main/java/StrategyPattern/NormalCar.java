package StrategyPattern;

import StrategyPattern.strategy.DrivingStrategy;

public class NormalCar extends Vehicle {

    NormalCar(DrivingStrategy drivingStrategy) {
        super(drivingStrategy);
    }

    public void drive() {
        drivingStrategy.drive();
    }
}
