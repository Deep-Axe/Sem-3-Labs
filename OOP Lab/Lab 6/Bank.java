import java.util.Scanner;

public class Bank {
    public double getRateOfInterest() {
        return 0.0;
    }

    public double calculateInterest(double principal, int years) {
        return (principal * getRateOfInterest() * years) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter principal amount:");
        double principal = sc.nextDouble();
        System.out.println("Enter number of years:");
        int years = sc.nextInt();

        System.out.println("Select a bank:");
        System.out.println("1. SBI");
        System.out.println("2. ICICI");
        System.out.println("3. AXIS");
        int choice = sc.nextInt();
        Bank bank;
        switch (choice) {
            case 1:
                bank = new SBI();
                System.out.println("You selected SBI.");
                break;
            case 2:
                bank = new ICICI();
                System.out.println("You selected ICICI.");
                break;
            case 3:
                bank = new AXIS();
                System.out.println("You selected AXIS.");
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                sc.close();
                return;
        }
        double interest = bank.calculateInterest(principal, years);
        System.out.println("Interest for the selected bank: " + interest);

        sc.close();
    }
}
class SBI extends Bank {
    public double getRateOfInterest() {
        return 8.0; 
    }
}
class ICICI extends Bank {
    public double getRateOfInterest() {
        return 7.0; 
    }
}
class AXIS extends Bank {
    public double getRateOfInterest() {
        return 9.0;
    }
}
