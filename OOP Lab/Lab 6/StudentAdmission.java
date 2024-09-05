import java.util.Scanner;

class Student {
    private int registrationNumber;
    private String name;
    private int age;

    public Student(int registrationNumber, String name, int age) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class UGStudent extends Student {
    private int semester;
    private double fees;

    public UGStudent(int registrationNumber, String name, int age, int semester, double fees) {
        super(registrationNumber, name, age);
        this.semester = semester;
        this.fees = fees;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Semester: " + semester);
        System.out.println("Fees: " + fees);
    }
}

class PGStudent extends Student {
    private int semester;
    private double fees;

    public PGStudent(int registrationNumber, String name, int age, int semester, double fees) {
        super(registrationNumber, name, age);
        this.semester = semester;
        this.fees = fees;
    }


    public void displayDetails() {
        super.displayDetails();
        System.out.println("Semester: " + semester);
        System.out.println("Fees: " + fees);
    }
}

public class StudentAdmission {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of UG students:");
        int numUG = scanner.nextInt();
        UGStudent[] ugStudents = new UGStudent[numUG];
        scanner.nextLine(); 

        int ugCount = 0;

        for (int i = 0; i < numUG; i++) {
            System.out.println("Enter details for UG student " + (i + 1) + ":");
            System.out.print("Registration Number: ");
            int regNumber = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Semester: ");
            int semester = scanner.nextInt();
            System.out.print("Fees: ");
            double fees = scanner.nextDouble();
            ugStudents[ugCount++] = new UGStudent(regNumber, name, age, semester, fees);
        }

        System.out.println("Enter the number of PG students:");
        int numPG = scanner.nextInt();
        PGStudent[] pgStudents = new PGStudent[numPG];
        scanner.nextLine();

        int pgCount = 0;

        for (int i = 0; i < numPG; i++) {
            System.out.println("Enter details for PG student " + (i + 1) + ":");
            System.out.print("Registration Number: ");
            int regNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            System.out.print("Semester: ");
            int semester = scanner.nextInt();
            System.out.print("Fees: ");
            double fees = scanner.nextDouble();
            pgStudents[pgCount++] = new PGStudent(regNumber, name, age, semester, fees);
        }

        System.out.println("\nUG Students:");
        for (int i = 0; i < ugCount; i++) {
            ugStudents[i].displayDetails();
            System.out.println();
        }

        System.out.println("PG Students:");
        for (int i = 0; i < pgCount; i++) {
            pgStudents[i].displayDetails();
            System.out.println();
        }
        System.out.println("Total number of UG admissions: " + ugCount);
        System.out.println("Total number of PG admissions: " + pgCount);

        scanner.close();
    }
}
