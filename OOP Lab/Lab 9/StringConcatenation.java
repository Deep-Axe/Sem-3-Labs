import java.util.Scanner;

public class StringConcatenation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = new String[5];

        for (int i = 0; i < strings.length; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        StringBuilder concatenatedString = new StringBuilder();
        for (String str : strings) {
            concatenatedString.append(str);
        }
        System.out.println("Concatenated String: " + concatenatedString.toString());

        scanner.close();
    }
}
