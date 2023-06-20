import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HuffmanTestDataGeneration {
    public static void main(String[] args) {
        generateTestDataFile("testdata.txt", 500);
    }

    public static void generateTestDataFile(String fileName, int numSets) {
        try {
            FileWriter writer = new FileWriter(fileName);

            for (int i = 0; i < numSets; i++) {
                int numCharacters = i + 1;
                Map<Character, Integer> counts = generateCharacterCounts(numCharacters);
                String testData = generateTestData(counts);

                writer.write(testData);
                writer.write(System.lineSeparator());
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Character, Integer> generateCharacterCounts(int numCharacters) {
        Map<Character, Integer> counts = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < numCharacters; i++) {
            char character = (char) ('A' + i);
            int frequency = random.nextInt(100) + 1;
            counts.put(character, frequency);
        }

        return counts;
    }

    public static String generateTestData(Map<Character, Integer> counts) {
        StringBuilder testData = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            char character = entry.getKey();
            int frequency = entry.getValue();

            testData.append("'").append(character).append("': ").append(frequency).append("    ");
        }

        return testData.toString();
    }
}
