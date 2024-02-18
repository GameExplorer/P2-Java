package kviz4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Racun {
    public static void main(String[] args) {
        preberiRacunInIzpisi("src/kviz4/assets/racun.txt");
    }
    public static void preberiRacunInIzpisi(String imeDatoteke) {
        try {
            Scanner sc = new Scanner(new File(imeDatoteke));
            double skupajBrezDDV = 0;
            double skupajDDV = 0;
            while(sc.hasNextLine()) {
                String[] vrstica = sc.nextLine().split("\t");
                if(vrstica.length == 3) {
                    double DDV = Double.parseDouble(vrstica[1].replace(",", "."));
                    double znesek = Double.parseDouble(vrstica[2].replace(",", "."));
                    skupajDDV += DDV;
                    skupajBrezDDV += znesek - DDV;
                }
            }

            sc.close();
            System.out.printf("Skupaj brez DDV: %6.2f", skupajBrezDDV);
            System.out.println();
            System.out.printf("DDV:             %6.2f", skupajDDV);
            System.out.println();
            System.out.printf("ZNESEK SKUPAJ:   %6.2f", skupajDDV + skupajBrezDDV);
        }
        catch (FileNotFoundException fne) {
            System.out.println("Napaka pri branju datoteke!");
        }
    }
}