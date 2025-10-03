package design_pattern.factoryAbstract;

public class VehicleTypeClient {

    public static VehicleType getVehicle(String type) {
        switch (type) {
            case "Luxury":
                return new LuxuryVehicle();
            case "Ordinary":
                return new OrdinaryVehicle();
            default:
                return null;
        }
    }
}
