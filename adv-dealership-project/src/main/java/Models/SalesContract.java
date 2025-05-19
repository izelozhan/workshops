package Models;

public class SalesContract extends Contract {
    boolean isFinanced;

    final double salesTaxRate = 0.05;
    final double recordingFee = 100;
    final double processingFeeUnder1000 = 295.;
    final double processingFee = 495;

    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(contractDate, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
    }

    public double getTotalPrice() {
        return 0;
    }

    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0;
        }

        double loanAmount = getTotalPrice();
        if (loanAmount >= 10000) {
            return calculateMonthlyPayment(48, loanAmount, 0.0425);
        } else {
            return calculateMonthlyPayment(24, loanAmount, 0.525);
        }

    }


}
