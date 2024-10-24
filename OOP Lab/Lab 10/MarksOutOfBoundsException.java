import java.util.Scanner;

public class MarksOutOfBoundsException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter the marks obtained (0-100): ");
        try {
            int marks = scanner.nextInt();
            Student student = new Student(name, marks);
            System.out.println("Student: " + student.getName() + ", Marks: " + student.getMarks());
        } catch (MarkOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer for marks.");
        } finally {
            scanner.close();
        }
    }
}

class MarkOutOfBoundsException extends Exception {
    public MarkOutOfBoundsException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) throws MarkOutOfBoundsException {
        this.name = name;
        setMarks(marks);
    }

    public void setMarks(int marks) throws MarkOutOfBoundsException {
        if (marks > 100) {
            throw new MarkOutOfBoundsException("Marks cannot exceed 100: " + marks);
        }
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}
