import java.util.Scanner;

public class NegativeArraySize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        
        try {
            int size = scanner.nextInt();

            if (size < 0) {
                throw new NegativeArraySizeException("Array size cannot be negative: " + size);
            }

            int[] array = new int[size];
            System.out.println("Array of size " + size + " created successfully.");
            for(int i = 0;i<size;i++){
                System.out.println(array[i]);
            }
            
        } catch (NegativeArraySizeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } finally {
            scanner.close();
        }
    }
}
