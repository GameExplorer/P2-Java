package predavanje04;

import java.io.File;
import java.util.Scanner;

public class Tecaj {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/predavanje04/CHF2022.txt"));

        double minTecaj, maxTecaj;

        String minTecajDatum, maxTecajDatum;

        String datum = sc.next();
        double tecaj = sc.nextDouble();

        minTecaj = tecaj; minTecajDatum = datum;
        maxTecaj = tecaj; maxTecajDatum = datum;

        while(sc.hasNext()) {
            datum = sc.next();
            tecaj = sc.nextDouble();

            if(tecaj < minTecaj) {
                minTecaj = tecaj;
                minTecajDatum = datum;
            }

            if(tecaj > maxTecaj) {
                maxTecaj = tecaj;
                maxTecajDatum = datum;
            }
        }
        sc.close();

        System.out.printf("MIN tecaj: %.4f (datum: %s) %n", minTecaj, minTecajDatum);
        System.out.printf("MAX tecaj: %.4f (datum: %s) %n", maxTecaj, maxTecajDatum);
    }
}
