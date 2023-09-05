package Izpiti.Poletni2023.Rok_2;

import java.io.FileInputStream;

public class Naloga23 {

    public static void hexDump(String vhodnaDatoteka) {
        try(FileInputStream vhod = new FileInputStream(vhodnaDatoteka)) {  //odprem datoteko

            int s = 0;
            String znaki = "";

            // dokler ima datoteka še vsebino ...
            while(vhod.available() > 0) {
                // berem znak po znaku
                int z = vhod.read();
                s++;

                // znak se mora nahajati med 32 in 127, drugače izpišemo piko
                znaki += (z >= 32 && z <= 127) ? (char) z : ".";

                //izpis hex znakov
                System.out.printf("%02X ", z);

                //pridem do konca vrstice in izpišem na desni besedilo
                if(s % 16 == 0) {
                    System.out.println("   |" + znaki + "|");
                    znaki="";
                }
            }

            // preostanek zadnje vrstice izpišem
            if(s % 16 != 0) {
                while(s % 16 != 0) {
                    System.out.print("   ");
                    znaki += " ";
                    s++;
                }

                System.out.println("   |" + znaki + "|");
            }
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
    public static void main(String[] args) {
        args = new String[]{"src/Izpiti/Poletni2023/Rok_2/a.txt"};
        hexDump(args[0]);
    }
}