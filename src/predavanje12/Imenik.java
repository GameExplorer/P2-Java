package predavanje12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class PrimerjajPoImenu implements Comparator<Oseba> {
    public int compare(Oseba o1, Oseba o2) {
        return o1.ime.compareTo(o2.ime);   // primerjava po imenu
    }
}

public class Imenik {

    public static void main(String[] args) {
        ArrayList<Oseba> osebe = new ArrayList();

        osebe.add(new Oseba("C",  25,  7.5));
        osebe.add(new Oseba("B",  50,  8.6));
        osebe.add(new Oseba("Dx", 75,  9.9));
        osebe.add(new Oseba("Da", 18,  6.5));
        osebe.add(new Oseba("Z",  18,  7.8));
        osebe.add(new Oseba("A",  18,  8.2));

        // izpis neurejenih (urejeni po vrstnem redu, kot smo dodajali)
        System.out.println("Neurejeno\n -----------------------------");
        System.out.println(osebe);
        System.out.println();

        // urejanje s privzetim primerjalnikom (metoda compareTo razreda Oseba)
        System.out.println("Urejeno po starosti (privzet primerjalnik)\n -----------------------------");
        Collections.sort(osebe);
        System.out.println(osebe);
        System.out.println();

        // urejanje z dodatnim primerjalnikom (razred MojPrimerjalnik, metoda compare)
        System.out.println("Urejeno po imenu (razred PrimerjajPoImenu)\n -----------------------------");
        Collections.sort(osebe, new PrimerjajPoImenu());
        System.out.println(osebe);
        System.out.println();

        System.out.println("Urejeno po oceni (anonimni notranji razred)\n -----------------------------");
        Collections.sort(osebe, new Comparator<Oseba>() {
            public int compare(Oseba o1, Oseba o2) {
                return Double.compare(o1.ocena, o2.ocena);
            }
        });
        System.out.println(osebe);
        System.out.println();

        System.out.println("Urejeno po oceni (lambda)\n -----------------------------");
        Collections.sort(osebe, (o1,o2) -> {return Double.compare(o1.ocena, o2.ocena);});
        System.out.println(osebe);
        System.out.println();


    }

}
