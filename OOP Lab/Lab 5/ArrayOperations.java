import java.util.Arrays;
import java.util.Scanner;
public class ArrayOperations {
    private int[] numbers;
    public ArrayOperations() {
        numbers = new int[10];
    }
    public void inputValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 10 integer values:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
    }
    public void displayValues() {
        System.out.println("Array values:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public void displayLargestValue() {
        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Largest value: " + max);
    }
    public void displayAverage() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;
        System.out.println("Average value: " + average);
    }

    public void sortArray() {
        Arrays.sort(numbers);
        System.out.println("Array sorted in ascending order:");
        displayValues();
    }

    public static void main(String[] args) {
        ArrayOperations arrayOps = new ArrayOperations();
        
        arrayOps.inputValues(); 
        arrayOps.displayValues();
        arrayOps.displayLargestValue();
        arrayOps.displayAverage(); 
        arrayOps.sortArray();
    }
}
