import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    static String filePath = "src/main/resources/inventory.csv";
    Dealership dealership = null;

    private Dealership getDealership() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String input = reader.readLine();

            //dealership info from first line
            if (input != null) {
                String[] parts = input.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                dealership = new Dealership(name, address, phone);
            }

            //vehicle
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

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dealership;
    }

    private Dealership saveDealership(){
        return null;
    }
}
