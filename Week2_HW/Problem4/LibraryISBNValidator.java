public class LibraryISBNValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "non-letter publisher code";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "non-digit body";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[")
          .append(pubCode)
          .append("] YEAR: ")
          .append(year)
          .append(" | CATALOG: ")
          .append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
 
        String testCase1 = " pen2026004251 ";
        String testCase2 = "abc202312345";     
        String testCase3 = "p1n2026004251";    
        String testCase4 = "pen202a004251";    

        System.out.println("--- Test Case 1 (Valid Case) ---");
        String norm1 = normalizeCode(testCase1);
        System.out.println("Result: " + validateAndFormat(norm1));

        System.out.println("\n--- Test Case 2 (Wrong Length) ---");
        String norm2 = normalizeCode(testCase2);
        System.out.println("Result: " + validateAndFormat(norm2));

        System.out.println("\n--- Test Case 3 (Non-letter Publisher) ---");
        String norm3 = normalizeCode(testCase3);
        System.out.println("Result: " + validateAndFormat(norm3));

        System.out.println("\n--- Test Case 4 (Non-digit Body) ---");
        String norm4 = normalizeCode(testCase4);
        System.out.println("Result: " + validateAndFormat(norm4));
    }
}
