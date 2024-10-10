import java.util.Scanner;
public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        String input = sc.nextLine();
        try {
            int number = Integer.parseInt(input);
            System.out.println("You entered the number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } finally {
            sc.close();
        }
    }
}
