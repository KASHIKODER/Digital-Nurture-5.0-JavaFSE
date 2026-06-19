public class Main {

    // Recursive method to calculate future value
    public static double futureValue(double presentValue, double growthRate, int years) {
        // Base case
        if (years == 0) {
            return presentValue;
        }
        // Recursive case
        return futureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {

        double presentValue = 1000.0;  // Initial amount
        double growthRate = 0.10;      // 10% growth rate
        int years = 5;                 // 5 years

        System.out.println("=== Financial Forecasting ===");
        System.out.println("Present Value: Rs." + presentValue);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Years: " + years);

        double result = futureValue(presentValue, growthRate, years);
        System.out.printf("Future Value after %d years: Rs.%.2f%n", years, result);

        System.out.println("\n=== Year by Year Breakdown ===");
        for (int i = 1; i <= years; i++) {
            System.out.printf("Year %d: Rs.%.2f%n", i, futureValue(presentValue, growthRate, i));
        }

        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Time Complexity: O(n) - n recursive calls");
        System.out.println("Space Complexity: O(n) - n call stack frames");
        System.out.println("Optimization: Memoization can avoid redundant calls");
    }
}