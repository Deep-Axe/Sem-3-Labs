import java.util.Scanner;

public class Result {
    private int[][] marks; 
    private int[] totalMarks; 

    public Result() {
        marks = new int[3][3]; 
        totalMarks = new int[3]; 
    }

    public void storeMarks(Scanner scanner) {
        System.out.println("Enter marks for 3 students in 3 subjects:");

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                marks[i][j] = scanner.nextInt();
            }
        }
        calculateTotalMarks();
    }


    private void calculateTotalMarks() {
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += marks[i][j];
            }
            totalMarks[i] = sum;
        }
    }
    public void findHighestMarksInEachSubject() {
        for (int subject = 0; subject < 3; subject++) {
            int highestMarks = marks[0][subject];
            int rollNumber = 1;

            for (int student = 1; student < 3; student++) {
                if (marks[student][subject] > highestMarks) {
                    highestMarks = marks[student][subject];
                    rollNumber = student + 1; 
                }
            }
            System.out.println("Subject " + (subject + 1) + ": Highest Marks = " + highestMarks +
                    ", Roll Number = " + rollNumber);
        }
    }
    public void findTopStudent() {
        int highestTotalMarks = totalMarks[0];
        int rollNumber = 1;

        for (int i = 1; i < 3; i++) {
            if (totalMarks[i] > highestTotalMarks) {
                highestTotalMarks = totalMarks[i];
                rollNumber = i + 1; 
            }
        }
        System.out.println("Student with Highest Total Marks: Roll Number = " + rollNumber +
                ", Total Marks = " + highestTotalMarks);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Result result = new Result();
        result.storeMarks(scanner);
        result.findHighestMarksInEachSubject();
        result.findTopStudent();
        scanner.close();
    }
}
