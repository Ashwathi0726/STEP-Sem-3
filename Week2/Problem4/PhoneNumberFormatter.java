import java.util.Scanner;

public class PhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {

        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            return "Invalid phone number";
        }

        StringBuilder sb = new StringBuilder("XXXXXX");

        String lastFourDigits = phone.substring(6);
        sb.append(lastFourDigits);

        sb.insert(6, '-');

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println("--- Sample Test Cases ---");

        String sampleInput1 = "9876543210";
        System.out.println("Input:  \"" + sampleInput1 + "\"");
        System.out.println("Output: " + maskPhoneNumber(sampleInput1)); 
        System.out.println();

        String sampleInput2 = "98765";
        System.out.println("Input:  \"" + sampleInput2 + "\"");
        System.out.println("Output: " + maskPhoneNumber(sampleInput2)); 
        System.out.println();

        System.out.println("--- Try Your Own Input ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a phone number to format: ");
        String userInput = scanner.nextLine();
        
        String result = maskPhoneNumber(userInput);
        System.out.println("Result: " + result);
        
        scanner.close();
    }
}
