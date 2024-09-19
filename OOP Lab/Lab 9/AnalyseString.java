import java.util.Scanner;

public class AnalyseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        
        int characterCount = input.length();
        int wordCount = countWords(input);
        int lineCount = countLines(input);
        int vowelCount = countVowels(input);
        
        System.out.println("Number of characters: " + characterCount);
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of lines: " + lineCount);
        System.out.println("Number of vowels: " + vowelCount);
        
        scanner.close();
    }
    
    private static int countWords(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        String[] words = str.trim().split("\\s+");
        return words.length;
    }
    
    private static int countLines(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        String[] lines = str.split("\\r?\\n");
        return lines.length;
    }
    
    private static int countVowels(String str) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
