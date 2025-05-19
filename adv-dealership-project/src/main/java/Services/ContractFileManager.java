package Services;

import Models.Contract;
import Models.LeaseContract;
import Models.SalesContract;
import Models.Vehicle;

public class ContractFileManager {
    static String filePath = "src/main/resources/contracts.csv";

    public void saveContract (Contract contract){
        Vehicle vehicle = contract.getVehicleSold();

        if (contract instanceof SalesContract) {
            contractAttributes =
                    "SALE" + "|" + contract.getContractDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail()
                            + "|" + "|" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|"
                            + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|"
                            + ((SalesContract) contract).calculateSalesTax() + "|" + ((SalesContract) contract).getRecordingFee() + "|"
                            + ((SalesContract) contract).calculateProcessingFee() + "|" + contract.calculateTotalPrice() + "|" + ((SalesContract) contract).isFinance
                            + "|" + contract.calculateMonthlyPayment();

        } else if (contract instanceof LeaseContract) {
            contractAttributes =
                    "LEASE" + "|" + contract.getDateOfContract() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail()
                            + "|" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|"
                            + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice()
                            + "|" + ((LeaseContract) contract).calculateExpectedEnding() + "|" + ((LeaseContract) contract).calculateLeaseFee()
                            + "|" + contract.calculateTotalPrice() + "|" + contract.calculateMonthlyPayment();
        }
    }

}
