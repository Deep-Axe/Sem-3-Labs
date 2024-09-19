import java.util.Scanner;

public class ReplaceRepeatingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        System.out.println("Enter the word to replace repeating characters:");
        String replacementWord = scanner.nextLine();

        String result = replaceRepeatingCharacters(input, replacementWord);

        System.out.println("Modified string: " + result);

        scanner.close();
    }

    private static String replaceRepeatingCharacters(String input, String replacement) {
        StringBuilder modifiedString = new StringBuilder();
        char lastChar = '\0';

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == lastChar) {

                if (modifiedString.length() == 0 || modifiedString.charAt(modifiedString.length() - 1) != replacement.charAt(0)) {
                    modifiedString.append(replacement);
                }
            } else {

                modifiedString.append(currentChar);
            }
            lastChar = currentChar;
        }

        return modifiedString.toString();
    }
}
