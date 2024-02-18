package kviz4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Igralci {
    public static void main(String[] args) {
        dvojnaNagrada("src/kviz4/assets/igralke1.csv", "src/kviz4/assets/igralci1.csv");
    }

    public static void dvojnaNagrada(String igralkeFileName, String igralciFileName) {
        try {
            //ustvarim tabelo igralk in igralcev
            ArrayList<String[]> igralke = new ArrayList<>();
            ArrayList<String[]> igralci = new ArrayList<>();

            Scanner sc = new Scanner(new File(igralkeFileName));

            //berem iz datoteke
            while(sc.hasNextLine()) {
                String[] vrstica = sc.nextLine().split(","); //ločuj po vejici
                for(int i = 0; i < vrstica.length; i++) {
                    vrstica[i] = vrstica[i].trim();
                }
                igralke.add(vrstica);
            }

            sc = new Scanner(new File(igralciFileName));

            //berem podatke
            while(sc.hasNextLine()) {
                String[] vrstica = sc.nextLine().split(","); //ločuj po vejici
                for(int i = 0; i < vrstica.length; i++) { //sprehodimo se po vrstici
                    vrstica[i] = vrstica[i].trim(); //odstranimo presledke
                }
                igralci.add(vrstica); //vsako vrstico dodamo v zbirko igralci
            }

            //obvezno zaprem scanner
            sc.close();

            ArrayList<String> x = new ArrayList<>();

            //Pregledamo ujemanje, kjer sta za isti film prejela oba igralca nagrado
            for(String[] igralka : igralke ) {
                for(String[] igralec : igralci) {
                    if(igralka[4].equals(igralec[4]) && igralec[1].equals(igralka[1])) {
                        x.add(String.format("Film: %s, Leto: %s, Igralka: %s, Igralec: %s", igralka[4], igralka[1], igralka[3], igralec[3]));
                    }
                }
            }

            Collections.sort(x);
            for(String nagrada : x) {
                System.out.println(nagrada);
            }
        }
        catch (Exception fne) {
            System.out.println(fne);
        }
    }
}