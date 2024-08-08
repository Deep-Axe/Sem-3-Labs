import java.util.Scanner;

public class ArraySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 2, 1, 5, 6, 7};
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter the value to be searched: ");
        int searchValue = scanner.nextInt();
        boolean found = false;
        int index = 0;

        System.out.print("The value is found at locations: ");
        for (int value : a) {
            if (value == searchValue) {
                System.out.print("a[" + index + "] ");
                found = true;
            }
            index++; 
        }        
        
        if (!found) {
            System.out.println("Value not found in the array.");
        }
        scanner.close();
    }
}
