package design_pattern.factoryAbstract;

public class VehicleClient {
    VehicleType vehicleType;

    VehicleClient(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getVehicle(String type) {
        switch (type) {
            case "Swift":
                return vehicleType.getVehicle("Swift");
            case "Alto":
                return vehicleType.getVehicle("Alto");
            case "BMW":
                return vehicleType.getVehicle("BMW");
            case "Mercedes":
                return vehicleType.getVehicle("Mercedes");
            default:
                return null;
        }
    }
}
