package design_pattern.factoryAbstract;

public class LuxuryVehicle implements VehicleType {
    @Override
    public Vehicle getVehicle(String vehicleType) {
        switch (vehicleType) {
            case "BMW":
                return new BMW();
            case "Mercedes":
                return new Mercedes();
            default:
                return null;
        }
    }
}
