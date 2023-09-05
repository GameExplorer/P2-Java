package Izpiti.Poletni2022.Rok_2;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Arrays;

/**
 * Preberemo datoteko P2.bin in na izhod izpišemo vse mobilne številke ki so zapisane v njej
 */
public class Naloga22 {

    /**
     * Rešitev z branjem datoteke po bajtih
     */

    public static void preberi(String vhodnaDatoteka) {
        byte[] podpis = {0x50, 0x32}; //P2 ime datoteke je na začetku hex dumpa

        try(FileInputStream vhod = new FileInputStream(vhodnaDatoteka)) { //odprem datoteko

            byte[] glava = new byte[2]; //v glavi hranim prva dva bajta... P2
            if(vhod.read(glava) == 2 && Arrays.equals(glava, podpis)) { //preveri ali gre za pravi format datoteke in ime
                byte[] stevilka = new byte[4];

                while(vhod.available() > 3) { //se izvede če v datoteki obstajajo vsaj 4 bajti
                    vhod.read(stevilka); //preberemo naslednje 4 bajte
                    StringBuilder sb = new StringBuilder("0");

                    for(int i = 0; i < stevilka.length; i++) { //sprehod po stevilkah
                        sb.append(String.format("%02x", stevilka[i])); //hex izpis
                    }
                    sb.insert(3, " "); //presledek na tretjem in sedmnem mestu
                    sb.insert(7, " ");
                    System.out.println(sb);
                }
            }
            else {
                System.out.println("Datoteka ni pravega formata");
            }

        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }

    /**
     * Rešitev z uporabo DataInputStream
     */
    public static void preberi1(String vhodnaDatoteka) {
        byte[] podpis = {0x50, 0x32}; // P2

        try (DataInputStream vhod = new DataInputStream(new FileInputStream(vhodnaDatoteka))) { //odpremo datoteko
            byte[] glava = new byte[2]; //beremo prva dva bajta ... P2
            if(vhod.read(glava) == 2 && Arrays.equals(glava, podpis)) { //preverimo ali je datoteka pravega formata
                while(vhod.available() > 3) { //se izvede, če obstajajo 4 bajti v datoteki
                    int stevilka = vhod.readInt(); //preberemo naslednje 4 bajte
                    StringBuilder sb = new StringBuilder(String.format("0%x", stevilka)); //hex številko vstavimo
                    sb.insert(3, " "); //na 3 in na 7 mestu naredu preslede
                    sb.insert(7, " ");
                    System.out.println(sb);
                }
            }
            else {
                System.out.println("Datoteka ni pravega formata");
            }
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
    public static void main(String[] args) {
        preberi("src/Izpiti/Poletni2022/Rok_2/P2.bin");
        System.out.println();
        preberi1("src/Izpiti/Poletni2022/Rok_2/P2.bin");
    }
}
