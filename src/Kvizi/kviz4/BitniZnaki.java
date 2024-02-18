package kviz4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BitniZnaki {
    public static void main(String[] args) {
        int[] znak = {129, 129, 129, 255, 129, 129, 129, 129};
        izpisi(znak);
    }

    public static void izpisi(int[] znak) {
        int vrstice = znak.length;
        int stolpci = 8;

        for (int i = 0; i < vrstice; i++) {
            for (int j = 0; j < stolpci; j++) {
                int bit = (znak[i] >> (7 - j)) & 1; // Preveri vrednost j-tega bita

                if (bit == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
