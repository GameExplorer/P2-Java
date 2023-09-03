package predavanje12;

import java.io.*;
import java.util.Scanner;

public class TryWithResources implements Closeable {
    public static void main(String[] args) throws FileNotFoundException {
        // try-with-resources: če datotkeke odprem v () delu try bloka jih bo java sama zaprla
        // klicala bo njihove close() metode
        try (
                Scanner vhod = new Scanner(new File("src/predavanje11/Fis/drzave.txt"));
                PrintWriter izhod = new PrintWriter("b.txt");
                TryWithResources twr = new TryWithResources();
        ) {
        } catch (IOException e) {
            System.out.println("Datoteka ne obstaja");
        }

        Scanner sc = null;
        try {
            //vse datoteke, ki jih odprem v try bloku
            sc = new Scanner(new File("src/predavanje11/Fis/drzave.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka ne obstaja");
        } finally {
            try {
                //moram v finally bloku obvezno zapreti datoteko!!
                if(sc != null) sc.close();
            } catch (Exception e) {}
        }
    }
    @Override
    public void close() throws IOException {
        System.out.println("izpis iz close() metode");
    }
}