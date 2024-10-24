import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ThreeLetterCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a five-letter word: ");
        String inputWord = scanner.nextLine();
        
        if (inputWord.length() != 5) {
            System.out.println("Please enter exactly five letters.");
            scanner.close();
            return;
            
        }


        Set<String> threeLetterWords = new HashSet<>();
        // Generate all possible three-letter combinations
        for (int i = 0; i < inputWord.length(); i++) {
            for (int j = 0; j < inputWord.length(); j++) {
                if (i != j) {
                    for (int k = 0; k < inputWord.length(); k++) {
                        if (k != i && k != j) {
                            String threeLetterWord = "" + inputWord.charAt(i) + inputWord.charAt(j) + inputWord.charAt(k);
                            threeLetterWords.add(threeLetterWord);
                        }
                    }
                }
            }
        }


        System.out.println("Three-letter combinations derived from \"" + inputWord + "\":");
        for (String word : threeLetterWords) {
            System.out.println(word);
        }

        scanner.close();
    }
}
