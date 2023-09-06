package Kvizi.Kvizi4;

import java.io.File;
import java.util.Scanner;

public class Kviz4 {
    public static void preberiRacunInIzpisi(String imeDatoteke) {
        try (Scanner vhod = new Scanner(new File(imeDatoteke))) {
            double skupajBrezDDV = 0;
            double skupajDDV = 0;

            while(vhod.hasNextLine()) {
                String[] vrstica = vhod.nextLine().split("\t");
                if(vrstica.length == 3) {
                    double DDV = Double.parseDouble(vrstica[1].replace(",", "."));
                    double znesek = Double.parseDouble(vrstica[2].replace(",", "."));
                    skupajDDV += DDV;
                    skupajBrezDDV += znesek - DDV;
                }
            }

            System.out.printf("Skupaj brez DDV: %6.2f", skupajBrezDDV);
            System.out.println();
            System.out.printf("DDV:             %6.2f", skupajDDV);
            System.out.println();
            System.out.printf("ZNESEK SKUPAJ:   %6.2f", skupajBrezDDV + skupajDDV);

        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
    public static void main(String[] args) {
        preberiRacunInIzpisi("src/Kvizi/viri/racun.txt");
    }
}
