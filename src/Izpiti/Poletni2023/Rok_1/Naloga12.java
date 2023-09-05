package Izpiti.Poletni2023.Rok_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Naloga12 {

    public static void urediDatoteko(String vhodnaDatoteka) {
        try (Scanner sc = new Scanner(new File(vhodnaDatoteka)); ) { //ni mi potrebno zapirati datoteko jo sam

            //podatke iz vhodne datoteke preberem v seznam
            ArrayList<String> podatki = new ArrayList<>();
            while(sc.hasNextLine()) { //dokler imam vrstico jo
                podatki.add(sc.nextLine()); // dodajam v seznam... ga polnim
            }

            // podatke lahko uredim kot nize ker se vrstica zacne z datumom oblike DD:MM bodo
            // s tem podatki urejeni po datumu
            Collections.sort(podatki);

            int letos = 0; // stevilo kolesarjev do sedaj

            // Sprehod po podatkih
            for(int i = 0; i < podatki.size(); i++) {
                String vrstica = podatki.get(i); //dobim vrstico
                String[] deli = vrstica.split(":"); // jo razbijem po ":"
                int danes = Integer.parseInt(deli[1]); //vzamem drugi podatek to je št. kolesarjev danes
                letos += danes; //in jo prištejem k letošnjim kolesarjem

                System.out.println(vrstica + "." + letos); //izpis
            }
        } catch (Exception e) {
            System.out.println("Napaka : " + e);
        }
    }
    public static void main(String[] args) {
        urediDatoteko("src/Izpiti/Poletni2023/Rok_1/kolo-danes.txt");
    }
}
