package design_pattern.factoryAbstract;

public class AbstractFactoryRunner {
    public static void main(String[] args) {
        VehicleType  luxury = VehicleTypeClient.getVehicle("Luxury");
        VehicleType  ordinary = VehicleTypeClient.getVehicle("Ordinary");

        VehicleClient luxuryVehicleClient = new VehicleClient(luxury);
        VehicleClient ordinaryVehicleClient = new VehicleClient(ordinary);

        luxuryVehicleClient.getVehicle("BMW").drive();
        ordinaryVehicleClient.getVehicle("Swift").drive();



    }
}
