public class TypingSpeedTest {

    public static void main(String[] args) {
        TypingSpeedTest test = new TypingSpeedTest();

        System.out.println("--- Test Case 1 ---");
        test.checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\n--- Test Case 2 ---");
        test.checkTypingAccuracy("coding", "coding");
    }

    public void checkTypingAccuracy(String original, String typed) {

        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length.");
            return;
        }

        int total = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ';
        char typedChar = ' ';

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else {
               
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1;
                    origChar = original.charAt(i);
                    typedChar = typed.charAt(i);
                }
            }
        }

        double accuracy = ((double) matched / total) * 100.0;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, total, accuracy);
        
        if (firstMismatchPos != -1) {
            System.out.printf(" | First Mismatch at position %d ('%c' vs '%c')%n", 
                              firstMismatchPos, origChar, typedChar);
        } else {
            System.out.println(" | No Mismatches");
        }
    }
}
