import java.util.Arrays;
import java.util.Scanner;

public class ExchangePositions {
    public static <T> void exchange(T[] array, int pos1, int pos2) {
        if (pos1 < 0 || pos1 >= array.length || pos2 < 0 || pos2 >= array.length) {
            throw new IndexOutOfBoundsException("Positions are out of bounds");
        }
        T temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        scanner.nextLine(); 
        String[] array = new String[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextLine();
        }

        System.out.println("Original array: " + Arrays.toString(array));

        System.out.print("Enter the first position to swap (0 to " + (size - 1) + "): ");
        int pos1 = scanner.nextInt();
        System.out.print("Enter the second position to swap (0 to " + (size - 1) + "): ");
        int pos2 = scanner.nextInt();

        try {
            exchange(array, pos1, pos2);
            System.out.println("Array after exchange: " + Arrays.toString(array));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
