import junit.framework.TestCase;

public class MortageCalculatorTest extends TestCase {

    public void testCalculateMonthlyPayment() {
        // Test case 1: Typical mortgage scenario
        double loanAmount1 = 100000;
        double interestRate1 = 5;
        int loanDuration1 = 20;
        double expectedMonthlyPayment1 = 660.39;
        double actualMonthlyPayment1 = MortageCalculator.calculateMonthlyPayment(loanAmount1, interestRate1, loanDuration1);
        assertEqualsWithTolerance(expectedMonthlyPayment1, actualMonthlyPayment1);

        // Test case 2: Zero loan amount (edge case)
        double loanAmount2 = 0;
        double interestRate2 = 4.5;
        int loanDuration2 = 30;
        double expectedMonthlyPayment2 = 0;
        double actualMonthlyPayment2 = MortageCalculator.calculateMonthlyPayment(loanAmount2, interestRate2, loanDuration2);
        assertEqualsWithTolerance(expectedMonthlyPayment2, actualMonthlyPayment2);

        // Test case 3: Zero interest rate (edge case)
        double loanAmount3 = 200000;
        double interestRate3 = 0;
        int loanDuration3 = 15;
        double expectedMonthlyPayment3 = 1111.11;
        double actualMonthlyPayment3 = MortageCalculator.calculateMonthlyPayment(loanAmount3, interestRate3, loanDuration3);
        assertEqualsWithTolerance(expectedMonthlyPayment3, actualMonthlyPayment3);

        // Test case 4: Short-term loan
        double loanAmount4 = 50000;
        double interestRate4 = 6.5;
        int loanDuration4 = 5;
        double expectedMonthlyPayment4 = 972.96;
        double actualMonthlyPayment4 = MortageCalculator.calculateMonthlyPayment(loanAmount4, interestRate4, loanDuration4);
        assertEqualsWithTolerance(expectedMonthlyPayment4, actualMonthlyPayment4);

        // Test case 5: Large loan amount
        double loanAmount5 = 1000000;
        double interestRate5 = 3.75;
        int loanDuration5 = 30;
        double expectedMonthlyPayment5 = 4633.16;
        double actualMonthlyPayment5 = MortageCalculator.calculateMonthlyPayment(loanAmount5, interestRate5, loanDuration5);
        assertEqualsWithTolerance(expectedMonthlyPayment5, actualMonthlyPayment5);
    }

    // Additional test cases
    public void testCalculateMonthlyPaymentWithDifferentLoanDurations() {
        // Test case 1: 10-year loan
        double loanAmount1 = 150000;
        double interestRate1 = 4.25;
        int loanDuration1 = 10;
        double expectedMonthlyPayment1 = 1536.81;
        double actualMonthlyPayment1 = MortageCalculator.calculateMonthlyPayment(loanAmount1, interestRate1, loanDuration1);
        assertEqualsWithTolerance(expectedMonthlyPayment1, actualMonthlyPayment1);

        // Test case 2: 25-year loan
        double loanAmount2 = 200000;
        double interestRate2 = 3.5;
        int loanDuration2 = 25;
        double expectedMonthlyPayment2 = 989.91;
        double actualMonthlyPayment2 = MortageCalculator.calculateMonthlyPayment(loanAmount2, interestRate2, loanDuration2);
        assertEqualsWithTolerance(expectedMonthlyPayment2, actualMonthlyPayment2);
    }

    public void testCalculateMonthlyPaymentWithDifferentInterestRates() {
        // Test case 1: High interest rate
        double loanAmount1 = 100000;
        double interestRate1 = 7.5;
        int loanDuration1 = 15;
        double expectedMonthlyPayment1 = 929.03;
        double actualMonthlyPayment1 = MortageCalculator.calculateMonthlyPayment(loanAmount1, interestRate1, loanDuration1);
        assertEqualsWithTolerance(expectedMonthlyPayment1, actualMonthlyPayment1);

        // Test case 2: Low interest rate
        double loanAmount2 = 250000;
        double interestRate2 = 2.75;
        int loanDuration2 = 30;
        double expectedMonthlyPayment2 = 1017.98;
        double actualMonthlyPayment2 = MortageCalculator.calculateMonthlyPayment(loanAmount2, interestRate2, loanDuration2);
        assertEqualsWithTolerance(expectedMonthlyPayment2, actualMonthlyPayment2);
    }

    public void testCalculateMonthlyPaymentWithDifferentLoanAmounts() {
        // Test case 1: Small loan amount
        double loanAmount1 = 50000;
        double interestRate1 = 4.0;
        int loanDuration1 = 20;
        double expectedMonthlyPayment1 = 303.87;
        double actualMonthlyPayment1 = MortageCalculator.calculateMonthlyPayment(loanAmount1, interestRate1, loanDuration1);
        assertEqualsWithTolerance(expectedMonthlyPayment1, actualMonthlyPayment1);

        // Test case 2: Large loan amount
        double loanAmount2 = 350000;
        double interestRate2 = 3.25;
        int loanDuration2 = 15;
        double expectedMonthlyPayment2 = 2472.43;
        double actualMonthlyPayment2 = MortageCalculator.calculateMonthlyPayment(loanAmount2, interestRate2, loanDuration2);
        assertEqualsWithTolerance(expectedMonthlyPayment2, actualMonthlyPayment2);
    }

    // Custom assertion method with tolerance
    private void assertEqualsWithTolerance(double expected, double actual) {
        assertEquals(expected, actual, 0.01); // Define a tolerance of 0.01
    }
}
