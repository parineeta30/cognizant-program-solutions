import java.util.Scanner;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double predictFutureValue(int years, double amount, double rate) {
        if (years == 0) {
            return amount; // Base case
        }
        return predictFutureValue(years - 1, amount, rate) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the initial amount in rupees : ");
        double amount = sc.nextDouble();

        System.out.print("Enter the annual growth rate in decimal figure : ");
        double rate = sc.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = sc.nextInt();

        double futureValue = predictFutureValue(years, amount, rate);

        System.out.printf("Predicted future value after %d years: Rs.%f \n", years, futureValue);

        sc.close();
    }
}
