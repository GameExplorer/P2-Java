package Predavanja.predavanje11;

import java.util.*;

/**
 * Primer uporabe ArrayList-a
 */
public class SeznamImen_List {
    public static void main(String[] args) {
        ArrayList<String> imena = new ArrayList<>();

        imena.add("Cilka");
        imena.add("Ana");
        imena.add("Berti");
        imena.add("Cvetka");
        imena.add("Žiga");
        imena.add("Zala");

        System.out.println("Imena tako kot smo jih vnesli: " + imena);
        Collections.sort(imena);
        System.out.println("Urejena imena: "  + imena);

        System.out.println();
        //klasična for zanka za sprehod čez elemente
        System.out.print("Imena: ");
        for(int i = 0; i < imena.size(); i++) {
            System.out.print(imena.get(i) + " ");
        }

        System.out.println();

        imena.remove("Vida"); // ne moremo odstraniti elemnta, ki ga ni

        System.out.println();
        //for each zanka
        System.out.print("Izpis s for each: ");
        for(String ime : imena) {
            System.out.print(ime + " ");
        }

        System.out.println();
        System.out.println(imena.contains("Ana")); //vrne true, ker je v zbirki
        System.out.println(imena.contains("Anica")); //vne false, ker ni v zbirki

        System.out.println(imena.remove("Zala")); //vrne true, ker je v zbirki in ga lahko odstrani
    }
}
