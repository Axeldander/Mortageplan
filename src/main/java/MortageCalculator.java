import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MortageCalculator {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/prospects.txt");
            Scanner scanner = new Scanner(file);

            // Skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine(); // Skip the header line
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
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    public static double calculateMonthlyPayment(double loanAmount, double interestRate, int loanDuration) {
        double monthlyInterestRate = interestRate / 12 / 100;
        int numberOfPayments = loanDuration * 12;

        double monthlyPayment = (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
        return monthlyPayment;
    }
}
