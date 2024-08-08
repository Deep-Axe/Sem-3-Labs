import java.util.Scanner;
public class Patterns {
    public static void main(String[] args) {
        int i, j, num;
        Scanner sc = new Scanner(System.in);

        // Pattern is:
        // 1
        // 2 2
        // 3 3 3
        // 4 4 4 4 and so on

        // a. Using Nested for Loops
        System.out.println("Enter the number of lines for pattern: ");
        num = sc.nextInt();

        System.out.println("The Pattern using nested for loops is: ");

        for (i = 1; i <= num; i++){
            for (j = 0; j < i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // b. Using for loop for each 
        int rows;
        System.out.println("Enter the number of rows for pattern: ");
        rows = sc.nextInt();

        System.out.println("The Pattern is for-each is: ");

        for (i = 1; i <= rows; i++) {
            int[] numbers = new int[i];
            for (j = 0; j < i; j++) {
                numbers[j] = i;
            }
            for (int num1 : numbers) {
                System.out.print(num1 + " ");
            }
            System.out.println();
        }
    }
}
