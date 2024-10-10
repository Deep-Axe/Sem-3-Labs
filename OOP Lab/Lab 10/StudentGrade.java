import java.util.Scanner;

public class StudentGrade {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Student's Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.next();
        scanner.nextLine();
        
        System.out.print("Enter number of subjects for calculation: ");
        int cnt = scanner.nextInt();
        double[] marks = new double[cnt];
        
        for (int i = 0; i < cnt; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                    double a = Double.parseDouble(scanner.nextLine());
                    marks[i] = a;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter numeric values for marks.");
                }
            }
        }
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }

        double percentage = (totalMarks / (cnt * 100)) * 100;

        String grade;
        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\nStudent Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.printf("Total Marks: %.2f out of %d\n", totalMarks, cnt * 100);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
