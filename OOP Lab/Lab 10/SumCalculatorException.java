import java.util.Scanner;

class Input_Exception extends Exception {
    public Input_Exception(String message) {
        super(message);
    }
}


public class SumCalculatorException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.print("Enter an integer (-1 to stop): ");
            String input = scanner.nextLine();

            try {
                validateInput(input); 
                int number = Integer.parseInt(input);

                if (number == -1) {
                    break; 
                }

                sum += number; 
            } catch (Input_Exception e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        System.out.println("Total sum: " + sum);
        scanner.close();
    }

    public static void validateInput(String input) throws Input_Exception {
        if (input.matches("^-?\\d+$")) {
            return;
        } else {
            throw new Input_Exception("Floating point numbers are not allowed. Please enter an integer.");
        }
    }
}
