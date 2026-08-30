import java.util.Scanner;

public class CustomerVerification {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }
        
        char[] originalArray = customerName.toCharArray();
        char[] reversedArray = new char[originalArray.length];
        
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }
        
        return new String(reversedArray);
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter customer name: ");
        String originalName = scanner.nextLine(); 

        String reversedName = reverseCustomerName(originalName);

        System.out.println("Original Name: " + originalName);
        System.out.println("Reversed Name: " + reversedName);
        
        scanner.close();
    }
}
