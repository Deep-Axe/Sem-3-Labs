import java.util.Scanner;
class NegativeRootException extends Exception {
    public NegativeRootException(String message) {
        super(message);
    }
}
public class NegativeRootCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its square root: ");
        double number = scanner.nextDouble();
        try {
            if (number < 0) {
                throw new NegativeRootException("Cannot calculate square root of a negative number.");
            }
            double squareRoot = Math.sqrt(number);
            System.out.printf("The square root of %.2f is %.2f\n", number, squareRoot);
        } catch (NegativeRootException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
