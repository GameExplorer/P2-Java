package kviz3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountLines {
    public static void main(String[] args) {
        countLines("besedilo.txt");
    }
    public static int countLines(String fileName) {
        int lineCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                // Povečaj števec vrstic
                lineCount++;
            }
        } catch (IOException e) {
            // Če datoteka ne obstaja, vrnemo -1
            return -1;
        }
        // Ignoriramo izjemo pri zapiranju BufferedReader-ja
        return lineCount;
    }
}