import java.util.Scanner;
/* Write a menu driven program to do the following:
 * 1. To compare two strings and if not identical print the position of the first mismatch and print how many characters match before the mismatch.
 * 2. convert the uppercase vowel character to lower
 */
public class EvaluationQues {

    public static int compareStrings(String s1, String s2) {
        return s1.compareTo(s2);
    }

    public static String toggleCase(String s) {
        StringBuilder toggled = new StringBuilder();
        String vowels = "AEIOUaeiou";
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c) && (vowels.indexOf(c) != -1)) {
                toggled.append(Character.toLowerCase(c));
            }
            else{
                toggled.append(c);
            }
        }
        return toggled.toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Compare two strings");
            System.out.println("2. Toggle uppercase vowel");
            System.out.println("3. Exit");

            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();;

            if (choice == 3) {
                System.out.println("Exiting the program.");
                break;
            }

        
            switch (choice) {
                case 1:
                    //the implementation is not neat but it works, and I got full marks soo
                    System.out.print("Enter the first string: ");
                    String firstString = scanner.nextLine();
                    System.out.print("Enter the second string: ");
                    String secondString = scanner.nextLine();
                    int comparisonResult = compareStrings(firstString, secondString);
                    if (comparisonResult == 0) {
                        System.out.println("The strings are equal.");
                    } else if (comparisonResult < 0) {
                        int i,length;
                        if (firstString.length() > secondString.length()){
                            length = secondString.length();
                        }
                        else{
                            length=firstString.length();
                        }
                        System.out.println("The first string is less than the second string.");
                        for (i = 0; i<length;i++) {
                            if (firstString.toCharArray()[i] != secondString.toCharArray()[i]){
                                
                                
                                break;
                            }
                        }
                        System.out.println("Index of string at which position doesn't match");
                        System.out.println(firstString.toCharArray()[i]);
                        System.out.println( secondString.toCharArray()[i]);
                        System.out.println("Index at which mismatch "+ i);
                        
                    } else {
                        System.out.println("The first string is greater than the second string.");
                        int i,length;
                        if (firstString.length() > secondString.length()){
                            length = secondString.length();
                        }
                        else{
                            length=firstString.length();
                        }
                        for (i = 0; i<length;i++) {
                            if (firstString.toCharArray()[i] != secondString.toCharArray()[i]){
                                break;
                            }
                        }
                        System.out.println("Index of string at which position doesn't match");
                        System.out.println(firstString.toCharArray()[i]);
                        System.out.println( secondString.toCharArray()[i]);
                        System.out.println("Index at which mismatch "+ i);
                    }
                    break;

                case 2:
                    //this one was half decent
                    System.out.print("Enter the first string: ");
                    String firstString1 = scanner.nextLine();
                    String toggledString1 = toggleCase(firstString1);
                    System.out.println("Toggled first string: " + toggledString1);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }
}
