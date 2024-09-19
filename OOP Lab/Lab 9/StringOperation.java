import java.util.Arrays;
import java.util.Scanner;

public class StringOperation {
    
    public static boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    public static String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String concatenateStrings(String original, String reversed) {
        return original + reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String originalString;

        while (true) {

                        
            System.out.print("Enter a string: ");
            originalString = scanner.nextLine();
            
            System.out.println("\nMenu:");
            System.out.println("1. Check if a string is a palindrome");
            System.out.println("2. Sort a string in alphabetical order");
            System.out.println("3. Reverse a string");
            System.out.println("4. Concatenate the original string and the reversed string");
            System.out.println("5. Exit");



            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 


            switch (choice) {
                case 1:
                    if (isPalindrome(originalString)) {
                        System.out.println("The string '" + originalString + "' is a palindrome.");
                    } else {
                        System.out.println("The string '" + originalString + "' is not a palindrome.");
                    }
                    break;
                case 2:
                    String sortedString = sortString(originalString);
                    System.out.println("The string in alphabetical order: '" + sortedString + "'");
                    break;
                case 3:
                    String reversedString = reverseString(originalString);
                    System.out.println("The reversed string: '" + reversedString + "'");
                    break;
                case 4:
                    String concatenatedString = concatenateStrings(originalString, reverseString(originalString));
                    System.out.println("The concatenated string: '" + concatenatedString + "'");
                    break;
                
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
