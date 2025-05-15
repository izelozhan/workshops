import Models.Dealership;

public class Program {
    public static void main(String[] args) {
        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.getDealership();
        UserInterface ui = new UserInterface();

        if (dealership != null) {
            System.out.println("Dealership: " + dealership.getName() + dealership.getAddress() + dealership.getPhone());
            System.out.println("Vehicles: " + dealership.getAllVehicles()) ;
        }
    }
}
