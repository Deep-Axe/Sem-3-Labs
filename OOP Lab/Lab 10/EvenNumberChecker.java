import java.util.Scanner;

class EvenNumberException extends Exception {
    public EvenNumberException(String message) {
        super(message);
    }
}

public class EvenNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        
        try {
            int number = scanner.nextInt();
            checkEvenNumber(number); 
        } catch (EvenNumberException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }

    public static void checkEvenNumber(int number) throws EvenNumberException {
        if (number % 2 == 0) {
            throw new EvenNumberException("Even numbers are not allowed: " + number);
        } else {
            System.out.println("The number " + number + " is accepted.");
        }
    }
}
