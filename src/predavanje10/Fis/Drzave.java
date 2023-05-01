package predavanje10.Fis;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Drzave {

    static HashMap<String, Drzava> preberiDrzave() throws Exception {
        HashMap<String, Drzava> drzave = new HashMap<String, Drzava>();

        String drzava;
        Scanner sc = new Scanner(new File("src/predavanje10/Fis/drzave.txt"));

        while(sc.hasNext()) {
            drzava = sc.nextLine();
            String[] podatki = drzava.split(":");
            Drzava nova = new Drzava(podatki[0], podatki[1], Integer.parseInt(podatki[2]));
            drzave.put(podatki[0], nova);
        }

        sc.close();

        return drzave;
    }

    static void izpisDrzavPoVrednost(HashMap<String, Drzava> drzave) {
        Iterator<Drzava> it = drzave.values().iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    static void izpisDrzavTipkovnica (HashMap<String, Drzava> drzave) {
        Iterator<String> it = drzave.keySet().iterator();

        while(it.hasNext()) {
            String kljuc = String.valueOf(it.next());
            System.out.println(kljuc + "----" + drzave.get(kljuc));
        }
    }


    public static void main(String[] args) throws Exception {
        HashMap<String, Drzava> drzave;

        drzave = preberiDrzave();
        izpisDrzavPoVrednost(drzave);
        System.out.println();
        izpisDrzavTipkovnica(drzave);
    }

}
