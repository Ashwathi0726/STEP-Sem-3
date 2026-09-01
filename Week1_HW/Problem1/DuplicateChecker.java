public class DuplicateChecker {

    public void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        DuplicateChecker checker = new DuplicateChecker();

        System.out.println("--- Testing with Duplicates ---");
        int[] testSeats1 = {12, 25, 34, 25, 45, 12};
        checker.checkDuplicateSeats(testSeats1);

        System.out.println("\n--- Testing without Duplicates ---");
        int[] testSeats2 = {1, 2, 3, 4, 5};
        checker.checkDuplicateSeats(testSeats2);
    }
}
