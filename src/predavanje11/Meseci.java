package predavanje11;

import java.util.*;

public class Meseci {
    public static void main(String[] args) {

        //SLovar mesecev, kljuc je ime meseca, vrednost pa št. dni. Lahko uporabimo HashMap ali pa TreeMap. TreeMap jih
        // uredi po avecednem vrstnem redu
        TreeMap<String, Integer> meseci = new TreeMap<>();

        meseci.put("Januar", 31);
        meseci.put("Februar", 28);
        meseci.put("Marec", 31);
        meseci.put("April", 30);
        meseci.put("Maj", 31);
        meseci.put("Junij", 30);
        meseci.put("Julij", 31);
        meseci.put("Avgust", 31);
        meseci.put("September", 30);
        meseci.put("Oktober", 31);
        meseci.put("November", 30);
        meseci.put("December", 31);

        System.out.println(meseci.values()); //izpis št. dni za vsak mesec
        System.out.println(meseci.keySet()); //izpiše ključe -> mesece

        System.out.println("Januar je mesec v letu: " + meseci.containsKey("Januar")); //true
        System.out.println("Napoleon je mesec v letu: " + meseci.containsKey("Napoelon")); //false

        System.out.println();
        for(String mesec : meseci.keySet()) { //sprehod po meseci
            System.out.println(mesec + "-" + meseci.get(mesec)); //izpis imena meseca in št. dni ... get vrne vrednost
        }

        System.out.println();
        for (Integer d : meseci.values()) {
            System.out.println(d);
        }
    }
}