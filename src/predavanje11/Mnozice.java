package predavanje11;

import java.util.*;

public class Mnozice {
    public static void main(String[] args) {
        //HashSet<String> dnevi = new HashSet<>();
        TreeSet<String> dnevi = new TreeSet<>();

        dnevi.add("PON");
        dnevi.add("TOR");
        dnevi.add("TOR");
        dnevi.add("SRE");
        dnevi.add("ČET");
        dnevi.add("PET");
        dnevi.add("SOB");
        dnevi.add("NED");

        System.out.println("Velikost: " + dnevi.size()); // 7
        System.out.println(dnevi.contains("TOR")); //vne true če obstaja
        System.out.println(dnevi.add("SRE")); // vrne false če obstaja, ne moremo dodati ker obstaja
        System.out.println("Velikost: " + dnevi.size()); // 6

        System.out.println();
        // Iterator
        Iterator<String> it = dnevi.iterator();
        while (it.hasNext()) { //izpis po abecdnem reud
            System.out.println(it.next());
            if (it.equals("SRE")) {
                dnevi.remove("SRE");
                System.out.println(dnevi);
            }

        }


    }

}