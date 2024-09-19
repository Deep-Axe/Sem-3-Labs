import java.util.Scanner;

public class StringManipulation {
    
    // Method to compare two strings
    public static int compareStrings(String s1, String s2) {
        return s1.compareTo(s2);
    }

    public static String toggleCase(String s) {
        StringBuilder toggled = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                toggled.append(Character.toLowerCase(c));
            } else {
                toggled.append(Character.toUpperCase(c));
            }
        }
        return toggled.toString();
    }

    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2) || s2.contains(s1);
    }

    public static String replaceSubstring(String s1, String s2) {
        if (s1.contains(s2)) {
            return s1.replace(s2, "Hello");
        } else if (s2.contains(s1)) {
            return s2.replace(s1, "Hello");
        }
        return null; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Compare two strings");
            System.out.println("2. Convert uppercase to lowercase and vice-versa");
            System.out.println("3. Check if one string is a substring of the other");
            System.out.println("4. Replace substring with 'Hello'");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();;

            if (choice == 5) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.print("Enter the first string: ");
            String firstString = scanner.nextLine();
            System.out.print("Enter the second string: ");
            String secondString = scanner.nextLine();

            switch (choice) {
                case 1:
                    int comparisonResult = compareStrings(firstString, secondString);
                    if (comparisonResult == 0) {
                        System.out.println("The strings are equal.");
                    } else if (comparisonResult < 0) {
                        System.out.println("The first string is less than the second string.");
                    } else {
                        System.out.println("The first string is greater than the second string.");
                    }
                    break;

                case 2:
                    String toggledString1 = toggleCase(firstString);
                    String toggledString2 = toggleCase(secondString);
                    System.out.println("Toggled first string: " + toggledString1);
                    System.out.println("Toggled second string: " + toggledString2);
                    break;

                case 3:
                    if (isSubstring(firstString, secondString)) {
                        System.out.println("One string is a substring of the other.");
                    } else {
                        System.out.println("No substring relationship found.");
                    }
                    break;

                case 4:
                    String replacedString = replaceSubstring(firstString, secondString);
                    if (replacedString != null) {
                        System.out.println("Replaced string: " + replacedString);
                    } else {
                        System.out.println("No substring found to replace.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
