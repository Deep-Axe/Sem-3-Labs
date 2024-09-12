import java.util.Scanner;

public class Student_Detail {
    private String name;
    private int id;
    final private String college_name = "MIT";

    public Student_Detail(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void display_details() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("College Name: " + college_name);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        Student_Detail[] students = new Student_Detail[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student's ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            students[i] = new Student_Detail(name, id);
        }
        System.out.println("\nStudent Details:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            students[i].display_details();
            System.out.println();
        }
        scanner.close();
    }
}
