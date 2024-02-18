package kviz4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TelefonskeStevilke {
    public static void main(String[] args) {
        izpisi("src/kviz4/assets/skrito.dat");

        preveri("03 / 973 081", "src/kviz4/assets/skrito.dat");
    }

    public static void izpisi(String imeDatoteke) {
        System.out.println("V datoteki " + imeDatoteke + " so naslednje številke:");

        try {
            FileInputStream fs = new FileInputStream(imeDatoteke);
            int i = 1;
            StringBuilder sb = new StringBuilder();
            while(fs.available() > 0) {
                int znak = fs.read();
                sb.append(String.format("%8s", Integer.toBinaryString(znak)).replace(" ", "0"));
                if(i % 3 == 0) {
                    System.out.printf("0%s / %s %s", sb.charAt(0), sb.substring(1, 4), sb.substring(4, 7));
                    System.out.println();
                    sb = new StringBuilder();
                }
                i++;
            }
            fs.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void preveri(String stevilka, String imeDatoteke) {
        try {
            FileInputStream fis = new FileInputStream(imeDatoteke);
            int i = 1;
            StringBuilder sb = new StringBuilder();
            while(fis.available() > 0) {
                int znak = fis.read();
                sb.append(String.format("%8s", Integer.toBinaryString(znak)).replace(" ", "0"));
                if(i % 3 == 0) {
                    String zeljenaStevilka = String.valueOf(Integer.parseInt(sb.toString(), 2));
                    String formatiranaStevilka = String.format("0%s / %s %s", zeljenaStevilka.charAt(0),
                            zeljenaStevilka.substring(1,4), zeljenaStevilka.substring(4,7));
                    if(stevilka.equalsIgnoreCase(formatiranaStevilka)) {
                        System.out.println("Številka " + stevilka + " je v datoteki");
                        fis.close();
                        return;
                    }
                    sb = new StringBuilder();
                }
                i++;
            }
            System.out.println("Številke " + stevilka + " ni v datoteki");
            fis.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
