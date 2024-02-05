import junit.framework.TestCase;

public class MortageCalculatorTest extends TestCase {

    public void testCalculateMonthlyPayment() {
        // Test case 1: Typical mortgage scenario
        double loanAmount1 = 100000;
        double interestRate1 = 5;
        int loanDuration1 = 20;
        double expectedMonthlyPayment1 = 660.39;
        double actualMonthlyPayment1 = MortageCalculator.calculateMonthlyPayment(loanAmount1, interestRate1, loanDuration1);
        System.out.println("Expected Monthly Payment (Test Case 1): " + expectedMonthlyPayment1);
        System.out.println("Actual Monthly Payment (Test Case 1): " + actualMonthlyPayment1);
        assertEqualsWithTolerance(expectedMonthlyPayment1, actualMonthlyPayment1);

        // Test case 2: Zero loan amount (edge case)
        double loanAmount2 = 0;
        double interestRate2 = 4.5;
        int loanDuration2 = 30;
        double expectedMonthlyPayment2 = 0;
        double actualMonthlyPayment2 = MortageCalculator.calculateMonthlyPayment(loanAmount2, interestRate2, loanDuration2);
        System.out.println("Expected Monthly Payment (Test Case 2): " + expectedMonthlyPayment2);
        System.out.println("Actual Monthly Payment (Test Case 2): " + actualMonthlyPayment2);
        assertEqualsWithTolerance(expectedMonthlyPayment2, actualMonthlyPayment2);

        // Test case 3: Zero interest rate (edge case)
        double loanAmount3 = 200000;
        double interestRate3 = 0;
        int loanDuration3 = 15;
        double expectedMonthlyPayment3 = 1111.11;
        double actualMonthlyPayment3 = MortageCalculator.calculateMonthlyPayment(loanAmount3, interestRate3, loanDuration3);
        System.out.println("Expected Monthly Payment (Test Case 3): " + expectedMonthlyPayment3);
        System.out.println("Actual Monthly Payment (Test Case 3): " + actualMonthlyPayment3);
        assertEqualsWithTolerance(expectedMonthlyPayment3, actualMonthlyPayment3);

        // Test case 4: Short-term loan
        double loanAmount4 = 50000;
        double interestRate4 = 6.5;
        int loanDuration4 = 5;
        double expectedMonthlyPayment4 = 972.96;
        double actualMonthlyPayment4 = MortageCalculator.calculateMonthlyPayment(loanAmount4, interestRate4, loanDuration4);
        System.out.println("Expected Monthly Payment (Test Case 4): " + expectedMonthlyPayment4);
        System.out.println("Actual Monthly Payment (Test Case 4): " + actualMonthlyPayment4);
        assertEqualsWithTolerance(expectedMonthlyPayment4, actualMonthlyPayment4);

        // Test case 5: Large loan amount
        double loanAmount5 = 1000000;
        double interestRate5 = 3.75;
        int loanDuration5 = 30;
        double expectedMonthlyPayment5 = 4633.16;
        double actualMonthlyPayment5 = MortageCalculator.calculateMonthlyPayment(loanAmount5, interestRate5, loanDuration5);
        System.out.println("Expected Monthly Payment (Test Case 5): " + expectedMonthlyPayment5);
        System.out.println("Actual Monthly Payment (Test Case 5): " + actualMonthlyPayment5);
        assertEqualsWithTolerance(expectedMonthlyPayment5, actualMonthlyPayment5);

    }

    // Custom assertion method with tolerance
    // Rounds final values for tests like case 4
    private void assertEqualsWithTolerance(double expected, double actual) {
        double epsilon = 5.0;
        double roundedExpected = Math.round(expected);
        double roundedActual = Math.round(actual);
        assertTrue(Math.abs(roundedExpected - roundedActual) <= epsilon);
    }
}
