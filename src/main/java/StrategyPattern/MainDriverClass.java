package StrategyPattern;

import StrategyPattern.strategy.NormalDrivingStrategy;
import StrategyPattern.strategy.SpecialDrivingStrategy;

public class MainDriverClass {
    public static void main(String[] args) {
        NormalDrivingStrategy normalDrivingStrategy = new NormalDrivingStrategy();
        SpecialDrivingStrategy specialDrivingStrategy= new SpecialDrivingStrategy();

        Vehicle normalVehicle = new NormalCar(normalDrivingStrategy);
        Vehicle sportsVehicle= new SportsCar(specialDrivingStrategy);
        Vehicle specialDriveVehicle = new SportsCar(specialDrivingStrategy);

        normalVehicle.drive();
        sportsVehicle.drive();
        specialDriveVehicle.drive();
    }
}
