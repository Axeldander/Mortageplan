import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MortageCalculator {

    public static void main(String[] args) {
        try {
            // Load the prospects.txt file using the class loader
            InputStream inputStream = MortageCalculator.class.getClassLoader().getResourceAsStream("prospects.txt");

            // Check if the input stream is not null
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                // Skip the header line
                String headerLine = reader.readLine();
                if (headerLine != null) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = parseCSVLine(line);

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
                }
            } else {
                System.out.println("Prospects file not found.");
            }
        } catch (Exception e) {
            System.out.println("Error reading the prospects file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to parse CSV lines correctly considering quoted fields
    private static String[] parseCSVLine(String line) {
        List<String> parts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                parts.add(sb.toString());
                sb.setLength(0); // Clear the StringBuilder
            } else {
                sb.append(c);
            }
        }

        // Add the last part
        parts.add(sb.toString());

        return parts.toArray(new String[0]);
    }

    // Your existing method to calculate monthly payments
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
