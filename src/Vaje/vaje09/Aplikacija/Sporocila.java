package vaje09.Aplikacija;

import vaje11.Izjeme.IzjemaDatoteka;
import vaje09.Kodirniki.*;
import vaje11.Kodiranje;

public class Sporocila {
    public static String sporocilo = "Welcome to Monza";
    public static void main(String[] args) {
        Kodirniki cezar = new CezarjevAlgoritem(5); //cezarjev kodirnik
        Kodirniki xor = new XOR("programiranje"); //xor kodirnik

        Kodirniki kombinacija = new KombiniraniKodirnik(new Kodirniki[]{xor, cezar}, 123456789); //kombinacija xor in cezar kodirnika

        //naključna kombinacija štirih cezarjevih in enega XOR kodirnika, kodirnike gnezdimo
        int[] zamiki = new int[]{-2,-1,1,1};
        Kodirniki[] cezarjeviKodirniki = new Kodirniki[zamiki.length];
        for(int i = 0; i < zamiki.length; i++) {
            cezarjeviKodirniki[i] = new CezarjevAlgoritem(zamiki[i]);
        }

        Kodirniki cezarjevKombiniran = new KombiniraniKodirnik(cezarjeviKodirniki, 987654321); //naključno eden od 4 cezarjevih kodirnikov
        Kodirniki k = new KombiniraniKodirnik(new Kodirniki[]{xor, cezarjevKombiniran},123456789); //50% xor,, 50% cezarjev

        Kodiranje kodiranje = new Kodiranje(k);

        /**
         * Kodiranje besedila
         */
        String zakodirano = kodiranje.zakodiranjeBesedila(sporocilo);
        System.out.print("Zakodirano besedilo: " + zakodirano);

        System.out.println();

        String odkodirano = kodiranje.odkodiranjeBesedila(zakodirano);
        System.out.print("Odkodirano besedilo: " + odkodirano);

        /**
         * Kodiranje tekstovne datoteke
         */

        try {
            kodiranje.zakodirajTekstovneDatoteke("src/Vaje11/original.txt", "src/Vaje11/zakodirano.txt");
            kodiranje.odkodiranjeTekstovnihDatotek("src/Vaje11/original.txt", "src/Vaje11/zakodirano.txt");
        } catch (IzjemaDatoteka e) {
            System.out.println(e.getMessage());
        }

        /**
         * Kodiranje binarne datoteke (slike)
         */
        try {
            kodiranje.zakodiranjeBinarneDatoteke("src/Vaje11/slika.png", "src/Vaje11/zakodirana.png");
            kodiranje.odkodiranjeBinarneDatoteke("src/Vaje11/zakodirana.png", "src/Vaje11/odkodirana.png");
        } catch (IzjemaDatoteka e) {
            System.out.println(e.getMessage());
        }

        /**
         * Kodiranje tekstovne datoteke na binarni način
         */
        try {
            kodiranje.zakodiranjeBinarneDatoteke("src/Vaje11/original.txt", "src/Vaje11/zakodirano_b.txt");
            kodiranje.odkodiranjeBinarneDatoteke("src/Vaje11/zakodirano_b.txt", "src/Vaje11/odkodirano_b.txt");
        } catch (IzjemaDatoteka e) {
            System.out.println(e);
        }

        /**
         * Kodiranje tekstovne datoteke po znakih
         */
        try {
            kodiranje.zakodirajPodatkovneDatoteke("src/Vaje11/original.txt", "src/Vaje11/zakodirano1.txt");
            kodiranje.odkodiranjePodatkovneDatoteke("src/Vaje11/zakodirano1.txt", "src/Vaje11/odkodirano1.txt");
        } catch (IzjemaDatoteka e) {
            System.out.println(e);
        }

        /*
        //Šifriranje
        String zakodiraj = kodiranje.zakodiranjeBesedila("Ta suhi škafec pušča, 2023");
        System.out.println("Zakodirano besedilo: " + zakodiraj);
        //Dešifriranje
        String odkodiraj = kodiranje.odkodiranjeBesedila(zakodiraj);
        System.out.println("Odkodirano besedilo: " + odkodiraj);
        */

    }
}