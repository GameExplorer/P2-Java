package predavanje11.Fis;

import java.io.File;
import java.util.*;

/**
 * Izpišemo vse države, ki sodelujejo na smučarskem tekmovanju
 */
public class Drzave {

    static TreeMap<String, Drzava> preberiDrzave(String imeDatoteke) throws Exception {
        TreeMap<String, Drzava> drzave = new TreeMap<>();

        Scanner sc = new Scanner(new File(imeDatoteke)); //odprem datoteko

        while(sc.hasNext()) {
            //preberem vrstico datoteke in jo razbijem po znaku ":"
            String vrstica = sc.nextLine();
            String[] podatki = vrstica.split(":");
            if(podatki.length == 3) { //če je vrstica prave oblike ustvarim drzavo
                Drzava nova = new Drzava(podatki[0], podatki[1], Integer.parseInt(podatki[2]));
                //vanj dodam objekt
                drzave.put(podatki[0], nova);
            }
        }
        sc.close();

        //vrnem slovar kot rezultat metode
        return drzave;
    }

    /*
    static void izpisDrzavPoVrednost(HashMap<String, Drzava> drzave) {
        for (Drzava drzava : drzave.values()) {
            System.out.println(drzava);
        }
    }

    static void izpisDrzavTipkovnica (HashMap<String, Drzava> drzave) {

        for (String s : drzave.keySet()) {
            String kljuc = String.valueOf(s);
            System.out.println(kljuc + "----" + drzave.get(kljuc));
        }
    }*/

    public static void main(String[] args) throws Exception {
        TreeMap<String, Drzava> drzave = preberiDrzave("src/predavanje11/Fis/drzave.txt");

        //izpis držav s sprehodom po zbirki objektov tipa Drzava (values())
        for(Drzava d: drzave.values()) {
            System.out.println(d);
        }

        //izpis ene države. Državo v slovarju najdem po kljucu
        System.out.println("---------------------------------------------------");
        String drzava = "SLO";
        if(drzave.get(drzava) == null) {
            System.out.println("Drzava " + drzava + " ne obstaja");
        }
        else {
            System.out.println(drzave.get(drzava));
        }

        //izpis vseh držav s pomočjo iteratorja po vrednostih
        System.out.println(" ---------- izpis vseh držav s pomočjo iteratorja po vrednostih ---------");
        Iterator<Drzava> itD = drzave.values().iterator();
        while(itD.hasNext()) System.out.println(itD.next());


        //izpis vseh držav s pomocjo iteratorja po kljucih
        System.out.println("--------- izpis vseh držav s pomocjo iteratorja po kljucih ---------");
        Iterator<String> itK = drzave.keySet().iterator();
        while(itK.hasNext()) {
            String k = itK.next();
            System.out.printf("%s - %s %n", k, drzave.get(k));

        }

        /*drzave = preberiDrzave();
        izpisDrzavPoVrednost(drzave);
        System.out.println();
        izpisDrzavTipkovnica(drzave);*/
    }
}
