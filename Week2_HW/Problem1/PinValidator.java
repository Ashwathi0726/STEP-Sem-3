import java.util.Scanner;

public class PinValidator {

    public static void main(String[] args) {
        PinValidator validator = new PinValidator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your ATM PIN: ");
        String userInput = scanner.nextLine();

        validator.checkPinLength(userInput);

        scanner.close();
    }

    public void checkPinLength(String pin) {
        int pinLength = pin.length();

        if (pinLength != 4) {
            System.out.println("Invalid PIN: Must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
}
