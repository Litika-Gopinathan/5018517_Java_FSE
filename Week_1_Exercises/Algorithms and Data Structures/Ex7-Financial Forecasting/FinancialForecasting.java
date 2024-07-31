
public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue; // Base case: present value when 0 years in the future
        } else {
            return (1 + growthRate) * calculateFutureValue(presentValue, growthRate, years - 1); // Recursive case
        }
    }

    public static void main(String[] args) {
        double presentValue = 10000.0; // Example present value
        double growthRate = 0.5; // Example growth rate (5%)
        int years = 5; // Example number of years into the future

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}

