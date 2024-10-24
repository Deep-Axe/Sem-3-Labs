import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String regNumber;
    private String firstName;
    private String lastName;
    private String degree;

    public Student(String regNumber, String firstName, String lastName, String degree) {
        this.regNumber = regNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Registration Number: " + regNumber + ", Name: " + firstName + " " + lastName + ", Degree: " + degree;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

public class StudentSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Registration Number: ");
            String regNumber = scanner.nextLine();
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Degree: ");
            String degree = scanner.nextLine();
            students[i] = new Student(regNumber, firstName, lastName, degree);
        }

        System.out.print("Enter the first name or last name of the student to search: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        List<Student> results = searchStudent(students, searchTerm);

        if (!results.isEmpty()) {
            System.out.println("Search Results:");
            for (Student student : results) {
                System.out.println(student);
            }
        } else {
            System.out.println("No student found with that name.");
        }

        scanner.close();
    }

    public static List<Student> searchStudent(Student[] students, String searchTerm) {
        List<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.getFirstName().toLowerCase().contains(searchTerm) ||
                student.getLastName().toLowerCase().contains(searchTerm)) {
                results.add(student);
            }
        }
        return results;
    }
}
