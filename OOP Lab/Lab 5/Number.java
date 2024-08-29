import java.util.Scanner;
public class Number {

    private double value;

    public Number(double value) {
        this.value = value;
    }

    public boolean isZero() {
        return value == 0;
    }
    public boolean isPositive() {
        return value > 0;
    }

    public boolean isNegative() {
        return value < 0;
    }

    public boolean isOdd() {
        if (value % 1 != 0) {
            throw new UnsupportedOperationException("Cannot determine odd/even status for non-integer values.");
        }
        return (int) value % 2 != 0;
    }

    public boolean isEven() {
        if (value % 1 != 0) {
            throw new UnsupportedOperationException("Cannot determine odd/even status for non-integer values.");
        }
        return (int) value % 2 == 0;
    }

    public boolean isPrime() {
        if (value % 1 != 0 || value < 2) {
            return false;
        }
        int intValue = (int) value;
        for (int i = 2; i <= Math.sqrt(intValue); i++) {
            if (intValue % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isArmstrong() {
        if (value % 1 != 0) {
            throw new UnsupportedOperationException("Cannot determine Armstrong status for non-integer values.");
            //do System.out.println instead for Lab Evaluation
        }
        int intValue = (int) value;
        int originalNumber = intValue;
        int sum = 0;
        int numDigits = String.valueOf(intValue).length();

        while (intValue > 0) {
            int digit = intValue % 10;
            sum += Math.pow(digit, numDigits);
            intValue /= 10;
        }

        return sum == originalNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        double value = sc.nextDouble();
        Number number = new Number(value);

        System.out.println("Is zero: " + number.isZero());
        System.out.println("Is positive: " + number.isPositive());
        System.out.println("Is negative: " + number.isNegative());
        System.out.println("Is odd: " + number.isOdd());
        System.out.println("Is even: " + number.isEven());
        System.out.println("Is prime: " + number.isPrime());
        System.out.println("Is Armstrong: " + number.isArmstrong());
        sc.close();
    }
}
