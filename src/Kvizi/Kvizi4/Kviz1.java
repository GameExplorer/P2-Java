package Kvizi.Kvizi4;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 */
public class Kviz1 {

    public static void dvojnaNagrade(String igralkeFileName, String igralciFileName) {
        try (Scanner vhodF = new Scanner(new File(igralkeFileName));
             Scanner vhodM = new Scanner(new File(igralciFileName))) {

            //seznam igralk in igralcev
            ArrayList<String[]> igralke = new ArrayList<>();
            ArrayList<String[]> igralci = new ArrayList<>();

            // Beremo igralke.csv
            while(vhodF.hasNextLine()) {
                String[] vrstica = vhodF.nextLine().split(","); //razbijemo nize po presledku

                for(int i = 0; i < vrstica.length; i++) { //sprehod po vrsticah
                    vrstica[i] = vrstica[i].trim(); //znebimo se presledkov
                }
                igralke.add(vrstica); //v seznam igralk dodamo vrstico
            }

            //Beremo igralci.csv
            while(vhodM.hasNextLine()) {
                String[] vrstica = vhodM.nextLine().split(",");
                for(int i = 0; i <  vrstica.length; i++) {
                    vrstica[i] = vrstica[i].trim();
                }
                igralci.add(vrstica);
            }

            ArrayList<String> obaNagrado = new ArrayList<>();

            for(String[] igralka : igralke) {
                for(String[] igralec : igralci) {
                    // pogledam ali sta oba pri istem filmu dobila oscarja in
                    // ali sta v istem letu prejela nagrado
                    if(igralka[4].equals(igralec[4]) && igralec[1].equals(igralka[1])) {
                        obaNagrado.add(String.format("Film: %s, Leto: %s, Igralka: %s, Igralec: %s",
                                igralka[4], igralka[1], igralka[3], igralec[3])); //ni važno od kje vzamemo podatke
                    }
                }
            }

            Collections.sort(obaNagrado);

            for(String nagrada : obaNagrado) {
                System.out.println(nagrada);
            }

        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
    public static void main(String[] args) {
        dvojnaNagrade("src/Kvizi/viri/igralke1.csv", "src/Kvizi/viri/igralci1.csv");
    }
}



