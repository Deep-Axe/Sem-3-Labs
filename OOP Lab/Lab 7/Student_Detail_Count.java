import java.util.Scanner;

public class Student_Detail_Count {
    private String name;
    private int id;
    final private String college_name = "MIT";

    private static int objectCount = 0;

    public Student_Detail_Count(String name, int id) {
        this.name = name;
        this.id = id;
        objectCount++;
    }
    public void display_details() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("College Name: " + college_name);
    }

    public static int getObjectCount() {
        return objectCount;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        Student_Detail_Count[] students = new Student_Detail_Count[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student:");
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student's ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            students[i] = new Student_Detail_Count(name, id);
        }

        System.out.println("\nStudent Details:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            students[i].display_details();
            System.out.println();
        }

        System.out.println("Total number of Student objects created: " + Student_Detail_Count.getObjectCount());

        scanner.close();
    }
}
