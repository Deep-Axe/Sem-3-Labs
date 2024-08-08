import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("CALCULATOR");

        double a, b, sol = 0;
        char oper, next = 0;

        do {
            System.out.println("Enter first number: ");
            a = sc.nextDouble();
            System.out.println("Enter second number: ");
            b = sc.nextDouble();

            System.out.println("Enter the operation to be performed (+, -, *, /): ");
            oper = sc.next().charAt(0);

            switch(oper) {
                case '+': 
                    sol = a + b; 
                    break;
                case '-': 
                    sol = a - b; 
                    break;
                case '*': 
                    sol = a * b; 
                    break;
                case '/': 
                    if (b != 0) {
                        sol = a / b;
                    } else {
                        System.out.println("ERROR: Division by zero is not allowed.");
                        continue; 
                    }
                    break;
                default: 
                    System.out.println("INVALID OPERATION");
                    continue; 
            }

            System.out.println("The solution is: " + sol);
            System.out.println("Do you want to perform another calculation? (y/n): ");
            next = sc.next().charAt(0);

        } while(next == 'y' || next == 'Y'); 
        sc.close();
    }
}
