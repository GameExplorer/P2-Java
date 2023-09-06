package Kvizi.Kvizi4;

import edu.princeton.cs.algs4.In;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Kviz5 {

    public static void izpisi(String vhodnaDatoteka) {
        System.out.printf("V datoteki: %s so naslednje številke: ", vhodnaDatoteka);

        try (FileInputStream vhod = new FileInputStream(new File(vhodnaDatoteka))) {
            int i = 1;
            StringBuilder trenutnaStevilka = new StringBuilder();

            while(vhod.available() > 0) {
                int znak = vhod.read();
                trenutnaStevilka.append(String.format("%8s", Integer.toBinaryString(znak)).replace(  " ", "0"));

                if(i % 3 == 0) {
                    String stevilka = String.valueOf(Integer.parseInt(trenutnaStevilka.toString(), 2));
                    System.out.printf("0%s / %s %s", stevilka.charAt(0), stevilka.substring(1,4), stevilka.substring(4,7));
                    System.out.println();
                    trenutnaStevilka = new StringBuilder();
                }
                i++;
            }

        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }

    public static void preveri(String stevilka, String imeDatoteke) {
        try (FileInputStream vhod = new FileInputStream(new File(imeDatoteke))) {
            int i = 1;
            StringBuilder trenutnaStevilka = new StringBuilder();
            while(vhod.available() > 0) {
                int znak = vhod.read();
                trenutnaStevilka.append(String.format("%8s", Integer.toBinaryString(znak)).replace(" " , "0"));
                if(i % 3 == 0) {
                    String zeljenaStevilka = String.valueOf(Integer.parseInt(trenutnaStevilka.toString(), 2));
                    String formatiranaStevilka = String.format("0%s / %s %s", zeljenaStevilka.charAt(0),
                            zeljenaStevilka.substring(1,4), zeljenaStevilka.substring(4,7));

                    if(stevilka.equalsIgnoreCase(formatiranaStevilka)) {
                        System.out.printf("Številka %s je v datoteki", stevilka);
                        return;
                    }
                    trenutnaStevilka = new StringBuilder();
                }
                i++;
            }
            System.out.printf("Številke %s ni v datoteki", stevilka);

        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
    public static void main(String[] args) {
        args = new String[]{"src/Kvizi/viri/skrito.dat", "07 / 656 770"};
        izpisi(args[0]);
        preveri(args[1], args[0]);
    }
}
