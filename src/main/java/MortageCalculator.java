import java.io.InputStream;
import java.util.Scanner;

public class MortageCalculator {

    public static void main(String[] args) {
        try {
            // Load the prospects.txt file using the class loader
            InputStream inputStream = MortageCalculator.class.getClassLoader().getResourceAsStream("prospects.txt");

            // Check if the input stream is not null
            if (inputStream != null) {
                Scanner scanner = new Scanner(inputStream);

                // Skip the header line
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");

                    if (parts.length == 4) {
                        String customerName = parts[0];
                        double loanAmount = Double.parseDouble(parts[1]);
                        double interestRate = Double.parseDouble(parts[2]);
                        int loanDuration = Integer.parseInt(parts[3]);

                        double monthlyPayment = calculateMonthlyPayment(loanAmount, interestRate, loanDuration);
                        System.out.printf("****************************************************************************************************%n");
                        System.out.printf("Prospect: %s wants to borrow %.2f € for a period of %d years and pay %.2f € each month%n",
                                customerName, loanAmount, loanDuration, monthlyPayment);
                        System.out.printf("****************************************************************************************************%n");
                    }
                }
                scanner.close();
            } else {
                System.out.println("Prospects file not found.");
            }
        } catch (Exception e) {
            System.out.println("Error reading the prospects file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static double calculateMonthlyPayment(double loanAmount, double interestRate, int loanDuration) {
        if (interestRate == 0) {
            // Handle zero interest rate case
            return loanAmount / (loanDuration * 12);
        } else {
            double monthlyInterestRate = interestRate / 12 / 100;
            int numberOfPayments = loanDuration * 12;

            double denominator = 1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments);
            double monthlyPayment = (loanAmount * monthlyInterestRate) / denominator;

            return monthlyPayment;
        }
    }
}
