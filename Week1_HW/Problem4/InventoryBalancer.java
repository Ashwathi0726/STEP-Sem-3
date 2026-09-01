public class InventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0;
        int sumB = 0;
        
        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
 
            sumA += sectionA[i];
            sumB += sectionB[i];

            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }

            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n",
                sumA, sumB, status, maxQuantity, maxSection, maxIndex + 1);
    }

    public static void main(String[] args) {

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
