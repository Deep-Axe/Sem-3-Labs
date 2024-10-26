import java.util.Scanner;

class Account {
    String name;
    int accNo;
    double balance;

    public Account(String name, int accNo, String accountType, double initialBalance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = initialBalance;
    }

    public void computeInterest(){}
    protected void checkMinimumBalance(){}

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            checkMinimumBalance(); 
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}

class Current extends Account {
    private static final double MINIMUM_BALANCE = 1000.0;
    private static final double PENALTY = 50.0;

    public Current(String name, int accNo, double initialBalance) {
        super(name, accNo, "Current", initialBalance);
    }


    public void computeInterest() {
        System.out.println("Interest computation is not available for Current accounts.");
    }

    protected void checkMinimumBalance() {
        if (balance < MINIMUM_BALANCE) {
            balance -= PENALTY;
            System.out.println("Penalty applied: $" + PENALTY);
        }
    }
}

class Savings extends Account {
    private static final double INTEREST_RATE = 0.04; 

    public Savings(String name, int accNo, double initialBalance) {
        super(name, accNo, "Savings", initialBalance);
    }

    public void computeInterest() {
        double interest = balance * INTEREST_RATE;
        deposit(interest);
        System.out.println("Interest deposited: $" + interest);
    }

    protected void checkMinimumBalance() {
    }
}

public class Banking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account type (Current/Savings):");
        String type = scanner.nextLine();
        System.out.println("Enter account holder's name:");
        String name = scanner.nextLine();
        System.out.println("Enter account number:");
        int accNo = scanner.nextInt();
        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); 

        Account account;

        if (type.equalsIgnoreCase("Current")) {
            account = new Current(name, accNo, initialBalance);
        } else if (type.equalsIgnoreCase("Savings")) {
            account = new Savings(name, accNo, initialBalance);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        while (true) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Compute Interest (Savings only)");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); 
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    account.computeInterest();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    System.exit(0);
            }
        }
           
    }
}
