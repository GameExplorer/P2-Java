package predavanje11.Fis;

import java.io.File;
import java.util.*;

public class Drzave {

    static HashMap<String, Drzava> preberiDrzave() throws Exception {
        HashMap<String, Drzava> drzave = new HashMap<String, Drzava>();

        String drzava;
        Scanner sc = new Scanner(new File("src/predavanje11/Fis/drzave.txt"));

        while(sc.hasNext()) {
            drzava = sc.nextLine();
            String[] podatki = drzava.split(":");
            if(podatki.length == 3) {
                Drzava nova = new Drzava(podatki[0], podatki[1], Integer.parseInt(podatki[2]));
                drzave.put(podatki[0], nova);
            }
        }
        sc.close();

        return drzave;
    }

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
    }

    public static void main(String[] args) throws Exception {
        HashMap<String, Drzava> drzave;

        drzave = preberiDrzave();
        izpisDrzavPoVrednost(drzave);
        System.out.println();
        izpisDrzavTipkovnica(drzave);
    }
}
