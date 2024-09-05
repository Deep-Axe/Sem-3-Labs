public class SquareCalculator {

    public static int square(int number) {
        return number * number;
    }

    public static double square(double number) {
        return number * number;
    }
    public static void main(String[] args) {
        int intResult = square(3);
        double doubleResult = square(0.2);
        System.out.println("The square of 3 is: " + intResult);
        System.out.println("The square of 0.2 is: " + doubleResult);
    }
}
