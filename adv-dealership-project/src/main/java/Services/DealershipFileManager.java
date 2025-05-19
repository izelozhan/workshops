package Services;

import Models.Dealership;
import Models.Vehicle;
import java.io.*;

public class DealershipFileManager {
    static String filePath = "src/main/resources/inventory.csv";
    Dealership dealership;

    public Dealership getDealership() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String input = reader.readLine();

            //dealership info from first line
            if (input != null) {
                String[] parts = input.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                System.out.println("Creating Dealership...");
                dealership = new Dealership(name, address, phone);
            }

            //add vehicle to dealership
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                String[] parts = inputLine.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(filePath));
            printWriter.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            for (Vehicle vehicle : dealership.getAllVehicles()){
                printWriter.println(vehicle.toFileString());
            }
            printWriter.close();

        } catch (IOException e){
            throw new RuntimeException("Failed to save dealership");
        }
    }
}
