import java.util.Objects;
public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        
        String trimmed = raw.trim();
        
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        
        return bankCode + rest;
    }

    public static String validateAndFormat(String reference) {
        String normalized = normalizeReference(reference);
        if (normalized.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = normalized.substring(0, 3);
        String day = normalized.substring(3, 5);
        String month = normalized.substring(5, 7);
        String year = normalized.substring(7, 9);
        String sequence = normalized.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ")
          .append("DATE: ").append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(sequence);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== RUNNING TEST CASES ===\n");

        runTest(" hdf03022600042 ", "[HDF] DATE: 03/02/26 | SEQ: 00042");

        runTest("12F03022600042", "Invalid: bank code must be 3 letters");

        runTest("ABC12345", "Invalid: wrong length");

        runTest("ICICI022600042", "Invalid: non-digit body");
        
        runTest("SBI15122599999", "[SBI] DATE: 15/12/25 | SEQ: 99999");
    }

    private static void runTest(String input, String expected) {
        String result = validateAndFormat(input);
        System.out.println("Input   : \"" + input + "\"");
        System.out.println("Expected: " + expected);
        System.out.println("Actual  : " + result);
        System.out.println("Status  : " + (Objects.equals(result, expected) ? "PASS ✅" : "FAIL ❌"));
        System.out.println("----------------------------------------");
    }
}
