package StrategyPattern.strategy;

public class NormalDrivingStrategy implements DrivingStrategy {
    public void drive() {
        System.out.println("Normal Driving");
    }
}
