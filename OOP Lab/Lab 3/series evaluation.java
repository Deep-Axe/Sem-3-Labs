public class SeriesCalculations {
    public static void main(String[] args) {
        double x = 1.0; 
        int terms = 10; 

        double sinX = computeSin(x, terms);
        System.out.printf("sin(%f) = %f%n", x, sinX);

        double sum = computeSum(terms);
        System.out.printf("Sum of the series = %f%n", sum);
    }

    public static double computeSin(double x, int terms) {
        double sinX = 0.0;
        for (int n = 0; n < terms; n++) {
            double term = Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
            if (n % 2 == 0) {
                sinX += term;
            } else {
                sinX -= term;
            }
        }
        return sinX;
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double computeSum(int terms) {
        double sum = 0.0;
        for (int i = 1; i <= terms; i++) {
            sum += 1.0 / Math.pow(i, i);
        }
        return sum;
    }
}
