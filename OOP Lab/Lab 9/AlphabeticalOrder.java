import java.util.Arrays;
import java.util.Scanner;

public class AlphabeticalOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] strings = new String[n];

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        // Sort the array in alphabetical order
        Arrays.sort(strings);

        System.out.println("Strings in alphabetical order:");
        for (String str : strings) {
            System.out.println(str);
        }

        scanner.close();
    }
}

/* 
import java.util.Scanner;

public class AlphabeticalOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] strings = new String[n];

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        // Sort the array in alphabetical order using Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (strings[j].compareTo(strings[j + 1]) > 0) {
                    // Swap strings[j] and strings[j + 1]
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }

        System.out.println("Strings in alphabetical order:");
        for (String str : strings) {
            System.out.println(str);
        }

        scanner.close();
    }
}
*/
