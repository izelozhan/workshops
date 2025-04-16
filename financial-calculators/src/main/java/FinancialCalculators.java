import java.util.Scanner;

public class FinancialCalculators {
    public static void main(String[] args) {
//        mortgageCalculator();
        futureValue();
    }

    public static void mortgageCalculator() {
        Scanner myScanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
//
        double principal, annualInterestRate, loanTermYear, monthlyInterestRate, numOfMonthlyPayment;

        System.out.println("What is your loan amount?");
        principal = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.println("What is your interest rate percentage?");
        annualInterestRate = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.println("What is your loan length (years)?");
        loanTermYear = myScanner.nextDouble();

        monthlyInterestRate = annualInterestRate / 12 / 100;
        numOfMonthlyPayment = loanTermYear * 12;

        //M=P×(i*(1+i)^n / ((1+i)^n)-1)

        double term1 = (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numOfMonthlyPayment));
        double term2 = (Math.pow(1 + monthlyInterestRate, numOfMonthlyPayment) - 1);
        double monthlyPayment = principal * (term1 / term2);

        double totalInterest = (monthlyPayment * numOfMonthlyPayment) - principal;

        builder.append("A $")
                .append(principal)
                .append(" loan at ")
                .append(annualInterestRate)
                .append("% interest for ")
                .append(loanTermYear)
                .append(" years would have a $")
                .append(String.format("%.2f", monthlyPayment))
                .append("/mo payment with a total interest of $")
                .append(String.format("%.2f", totalInterest))
                .append(".\nWould you like to apply for a loan today?");

        String myMortgage = builder.toString();
        System.out.println(myMortgage);
    }

    public static void futureValue() {
        Scanner myScanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        double principal, annualInterestRate, depositTermYear;

        System.out.println("What is your deposit amount?");
        principal = myScanner.nextDouble();
        myScanner.nextLine();

        System.out.println("What is your interest rate percentage?");
        annualInterestRate = myScanner.nextDouble() / 100; //%
        myScanner.nextLine();

        System.out.println("What is your deposit length (years)?");
        depositTermYear = myScanner.nextDouble();

        double futureValue = principal * Math.pow(1 + (annualInterestRate / 365), (depositTermYear * 365));
        double totalInterest = futureValue - principal;

        builder.append("Your future value is $")
                .append(String.format("%.2f", futureValue))
                .append(" and the total interest earned $")
                .append(String.format("%.2f", totalInterest));

        String myDeposit = builder.toString();
        System.out.println(myDeposit);
    }
}
