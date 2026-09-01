import java.util.Scanner;

public class TextStatsApp {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        
        String lowerText = text.toLowerCase();
        
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {

        String sampleInput = "Java Programming";
        System.out.println("Input: \"" + sampleInput + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(sampleInput);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your own text to test: ");
        String userInput = scanner.nextLine();
        System.out.print("Output: ");
        countVowelsAndConsonants(userInput);
        
        scanner.close();
    }
}
