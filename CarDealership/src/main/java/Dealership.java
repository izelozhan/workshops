import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {

    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {

    }

    public ArrayList<Vehicle> getVehiclesByMileage(double min, double max) {

    }

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {

    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }


}
