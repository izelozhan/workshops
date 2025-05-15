import Models.Dealership;
import Models.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static Scanner scanner = new Scanner(System.in);
    Dealership dealership;
    DealershipFileManager fileManager;

    public UserInterface() {
    }

    private void init() {
        fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }


    public void display() {
        init();
        displayMenuOptions();
        receiveAndPerformUserOption();
        displayVehicles();
    }

    public void displayMenuOptions() {
        System.out.println("\n--- Dealership Menu ---");
        System.out.println("1. Find vehicles by price");
        System.out.println("2. Find vehicles by make/model");
        System.out.println("3. Find vehicles by year");
        System.out.println("4. Find vehicles by color");
        System.out.println("5. Find vehicles by mileage");
        System.out.println("6. Find vehicles by type");
        System.out.println("7. Show all vehicles");
        System.out.println("8. Add a vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("10. Exit");
    }

    public void receiveAndPerformUserOption() {
        String option = "INVALID";
        while (option.equals("INVALID")) {
            String userOption = scanner.nextLine().toUpperCase();
            option = switch (userOption) {
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveRequest();
                case "10" -> exit();
                default -> "INVALID";
            };
        }
    }

    private String displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.printf("VIN: %d | Year: %d | Make: %s | Model: %s | Color: %s | Total Mileage: %d " +
                            "| Price: $%.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
        return null;
    }

    private String processGetByPriceRequest() {
        System.out.println("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter minimum price: ");
        double max = Double.parseDouble(scanner.nextLine());

        ArrayList<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        if (results == null || results.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            displayVehicles(results);
        }
        return "continue";
    }

    private String processGetByMakeModelRequest() {
        return "";
    }

    private String processGetByYearRequest() {
        return "";
    }

    private String processGetByColorRequest() {
        return "";
    }

    private String processGetByMileageRequest() {
        return "";
    }

    private String processGetByVehicleTypeRequest() {
        return "";
    }

    private String processGetAllVehiclesRequest() {
        ArrayList<Vehicle> allVehicle = dealership.getAllVehicles();

        return displayVehicles(allVehicle);
    }

    private String processAddVehicleRequest() {
        return "";
    }

    private String processRemoveRequest() {
        return "";
    }

    private String exit() {
        return "";
    }


}
