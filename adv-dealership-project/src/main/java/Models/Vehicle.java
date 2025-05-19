package Models;

public class Vehicle {
    int vin;
    int year;
    String make;
    String model;
    String vehicleType;
    String color;
    int odometer;
    double price;


    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }


    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%5d | %-4d | %-9s | %-9s | %-5s | %-6s | %7d | $%,8.2f",
                vin, year, make, model, vehicleType, color, odometer, price);
    }

    public String toFileString() {
        return vin + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" +
                color + "|" + odometer + "|" + price;
    }
}
