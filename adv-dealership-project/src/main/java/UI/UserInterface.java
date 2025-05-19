package UI;

import Models.Dealership;
import Models.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;
import Services.DealershipFileManager;

public class UserInterface {
    Scanner scanner;
    Dealership dealership;
    DealershipFileManager fileManager;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    private void init() {
        fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    public void display() {
     init();
     int userAction;
     do {
         displayMenuOptions();
         userAction = Integer.parseInt(scanner.nextLine());
         switch (userAction){
             case 1 -> processGetByPriceRequest();
             case 2 -> processGetByMakeModelRequest();
             case 3 -> processGetByYearRequest();
             case 4 -> processGetByColorRequest();
             case 5 -> processGetByMileageRequest();
             case 6 -> processGetByVehicleTypeRequest();
             case 7 -> processGetAllVehiclesRequest();
             case 8 -> processAddVehicleRequest();
             case 9 -> processRemoveVehicleRequest();
             case 10 -> processSellLeaseRequest();
             case 99 -> System.out.println("App is closing, see you next time!");
             default -> System.out.println("Invalid choice.");
         }
     } while (userAction != 99);
    }

    public void displayMenuOptions() {
        System.out.println("""
                ---------------- Dealership Menu ----------------
                1 - Find vehicles within a price
                2 - Find vehicles by make / model
                3 - Find vehicles by year
                4 - Find vehicles by color
                5 - Find vehicles by mileage range
                6 - Find vehicles by type (car, truck, SUV, van)
                7 - Show ALL vehicles
                8 - Add a vehicle
                9 - Remove a vehicle
                10 - Sell/Lease a vehicle
                99 - Quit
                """);
    }

    private void displayVehicles(ArrayList<Vehicle> list) {
        if (list.isEmpty()) {
            System.out.println("No matching vehicles.\n");
        } else {
            for (Vehicle v : list) {
                System.out.println(v);
            }
            System.out.println();
        }
    }

    private void processGetByPriceRequest() {
        System.out.println("Min Price: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.println("Max Price: ");
        double max = Double.parseDouble(scanner.nextLine());

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    private void processGetByMakeModelRequest() {
        System.out.print("Make : ");
        String make = scanner.nextLine().trim();
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    private void processGetByYearRequest() {
        System.out.println("Earliest year: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.println("Latest year : ");
        int max = Integer.parseInt(scanner.nextLine());
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    private void processGetByColorRequest() {
        System.out.print("Color: ");
        String color = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByMileageRequest() {
        System.out.println("Minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.println("Maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    private void processGetByVehicleTypeRequest() {
        System.out.print("Type (car/truck/suv/van): ");
        String type = scanner.nextLine().trim();
        displayVehicles(dealership.getVehiclesByType(type));
    }

    private void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest() {
        fileManager.getDealership();

        System.out.println("VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());
        System.out.println("Year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Make: ");
        String make = scanner.nextLine().trim();
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        System.out.print("Type (car/truck/suv/van): ");
        String vehicleType = scanner.nextLine().trim();
        System.out.print("Color: ");
        String color = scanner.nextLine().trim();
        System.out.println("Odometer: ");
        int odometer = Integer.parseInt(scanner.nextLine());
        System.out.println("Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        fileManager.saveDealership(dealership);
        System.out.println("Vehicle added.\n");
    }

    private void processRemoveVehicleRequest() {
        System.out.println("Enter VIN to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());
        Vehicle target = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                target = v;
                break;
            }
        }
        if (target == null) {
            System.out.println("VIN not found.\n");
        } else {
            dealership.removeVehicle(target);
            fileManager.saveDealership(dealership);
            System.out.println("Vehicle removed.\n");
        }
    }

    private void processSellLeaseRequest(){

    }

}
