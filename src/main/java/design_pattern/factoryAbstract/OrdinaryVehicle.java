package design_pattern.factoryAbstract;

public class OrdinaryVehicle implements VehicleType {
    @Override
    public Vehicle getVehicle(String vehicleType) {
        switch (vehicleType) {
            case "Swift":
                return new Swift();
            case "Alto":
                return new Alto();
            default:
                return null;
        }
    }
}
