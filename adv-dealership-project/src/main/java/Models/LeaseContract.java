package Models;

public class LeaseContract extends Contract {
    double vehiclePrice;

    final double expectedEndingValue = 0.50;
    final double leaseFee = 0.07;
    final int termMonths = 36;
    final double annualRate = 0.04;


    public LeaseContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold, double vehiclePrice) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.vehiclePrice = vehiclePrice;
    }

    public double getTotalPrice() {
        return 0;
    }

    public double getMonthlyPayment() {
        double amount = getTotalPrice();
        return calculateMonthlyPayment(termMonths, amount, annualRate);
    }


}
