import java.util.Scanner;
public class Number_lab5 {
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
            System.out.println("\nCannot check for non-integer value");
            System.out.println("Truncating and checking");
            return (int) value % 2 != 0;
        }
        else {
            return value % 2 != 0;
        }
    }

    public boolean isEven() {
        if (value % 1 != 0) {
            System.out.println("\nCannot check for non-integer value");
            System.out.println("Truncating and checking");
            return ((int) value) % 2 == 0;
        }
        return value % 2 == 0;
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
            System.out.println("\nCannot check for non-integer value");
            return 0 == 1;
        }
        else{
            int originalNumber = (int) value;
            int sum = 0;
            int numDigits = String.valueOf(value).length();

            while (value > 0) {
                int digit = (int) value % 10;
                sum += Math.pow(digit, numDigits);
                value /= 10;
            }

        return sum == originalNumber;
        }   
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        double value = sc.nextDouble();
        Number number = new Number(value);

        System.out.println("Is zero: " + number.isZero());
        System.out.println("Is positive: " + number.isPositive());
        System.out.println("Is negative: " + number.isNegative());
        System.out.print("Is odd: " );
        System.out.println(number.isOdd());
        System.out.print("Is even: " );
        System.out.println(number.isEven());
        System.out.println("Is prime: " + number.isPrime());
        System.out.print("Is Armstrong: ");
        System.out.println(number.isArmstrong());
        sc.close();
    }
}
