package predavanje11;

import java.util.*;

public class Mnozice {
    public static void main(String[] args) {
        //HashSet<String> dnevi = new HashSet<>();
        TreeSet<String> dnevi = new TreeSet<>();

        dnevi.add("PON");
        dnevi.add("TOR"); // elemente lahko dodam le enkrat,
        dnevi.add("TOR"); // če ga dodam večkrat se podatkovna struktura ne spremeni
        dnevi.add("SRE");
        dnevi.add("ČET");
        dnevi.add("PET");
        dnevi.add("SOB");

        System.out.println("Velikost: " + dnevi.size()); // velikost zbirke 7
        System.out.println(dnevi.contains("TOR")); //vne true če obstaja
        System.out.println(dnevi.add("SRE")); // vrne false če obstaja, ne moremo dodati ker obstaja
        System.out.println(dnevi.add("NED")); //dodamo NED v dnevi
        System.out.println("Velikost: " + dnevi.size()); // 6

        System.out.println(dnevi.remove("TOR")); //odstrani TOR

        System.out.println();

        // Iterator
        Iterator<String> it = dnevi.iterator();
        while (it.hasNext()) { //izpis po abecdnem reud
            String dan = it.next();
            if (dan.equals("PON")) {
                it.remove();
            }
            System.out.println(dan);
        }
        System.out.println(dnevi); //dnevi brez PON
        System.out.println("VELIKOST: " + dnevi.size());
        System.out.println();

        // FOR EACH
        for(String dan : dnevi) {
            System.out.println(dan);
            if(dan.equals("PON")) {
                dnevi.remove(dan);
            }
        }

        dnevi.clear(); //sprazni zbirko
        System.out.println(dnevi); //prazna zbirka

    }

}