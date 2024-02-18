package kviz3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWords {
    public static void main(String[] args) {
        countWords("besedilo.txt");
    }
    public static int countWords(String fileName) {
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Preštejemo število besed v vrstici
                String[] besede = line.split("\\s+");
                wordCount += besede.length;
            }
        } catch (IOException e) {
            // Če datoteka ne obstaja, vrnemo -1
            return -1;
        }
        // Ignoriramo izjemo pri zapiranju BufferedReader-ja
        return wordCount;
    }
}
