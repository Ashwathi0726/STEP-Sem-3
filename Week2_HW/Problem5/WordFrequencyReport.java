import java.util.*;

public class WordFrequencyReport {

    public static void main(String[] args) {
        WordFrequencyReport report = new WordFrequencyReport();
        
        String sampleInput = "The mentor was great, the session was great and clear.";
        
        System.out.println("--- Word Frequency Report ---");
        report.printFilteredWordFrequency(sampleInput);
    }

    public void printFilteredWordFrequency(String feedback) {

        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
   
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");

        String[] words = cleaned.split("\\s+");
        
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {

            if (!word.isEmpty() && !stopWords.contains(word)) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(freqMap.entrySet());

        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
