package predavanje11;

import java.util.*;
public class SeznamImen {
    public static void main(String[] args) {
        ArrayList<String> imena = new ArrayList<>();

        imena.add("Cilka");
        imena.add("Ana");
        imena.add("Berti");
        imena.add("Cvetka");
        imena.add("Žiga");
        imena.add("Zala");

        Collections.sort(imena);
        System.out.println();

        //klasična for zanka
        for(int i = 0; i < imena.size(); i++) {
            System.out.println(imena.get(i));
        }
        System.out.println();
        imena.remove("Vida"); // ne moremo odstraniti elemnta, ki ga ni

        //for each zanka
        for(String ime : imena) {
            System.out.println(ime);
        }

        System.out.println();
        System.out.println(imena.contains("Ana")); //vrne true, ker je v zbirki
        System.out.println(imena.contains("Anica")); //vne false, ker ni v zbirki

        System.out.println(imena.remove("Zala")); //vrne true, ker je v zbirki in ga lahko odstrani
    }
}
