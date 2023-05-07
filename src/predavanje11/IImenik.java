package predavanje11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Če želim elemente razreda Oseba med seboj primerjati po dodatnem kriteriju
 * torej ne po tistem v Oseba (compare to)
 * lahko utvarim nov razred-Primerjalnik, ta razred implementira
 * vmesnik Comparator in metodo compare()
 */
class MojPrimerjalnik implements Comparator<Oseba> {
    public int compare(Oseba o1, Oseba o2) {
        //osebe primerjam po starosti enako stare osebe pa še dodatno po imenu
        if(o1.starost == o2.starost) {
            return o1.ime.compareTo(o2.ime);
        }
        else return o1.starost - o2.starost;
    }
}

/**
 * Najprej ustvarim seznam (ArrayList) oseb, nato elemente uredim po različnih kriterijih
 * in izpišem na zaslon
 */
public class IImenik{
    public static void main(String[] args) {
        ArrayList<Oseba> osebe = new ArrayList<>();

        osebe.add(new Oseba("Cilka", 25));
        osebe.add(new Oseba("Berta", 50));
        osebe.add(new Oseba("Ana", 21));
        osebe.add(new Oseba("Vesna", 21));
        osebe.add(new Oseba("Maja", 21));
        osebe.add(new Oseba("Petra", 25));
        osebe.add(new Oseba("Anastasija", 25));

        //izpis neurejenih oseb (tako kot smo jih dodali)
        System.out.println(osebe);

        // urejanje s privzetim primerjalnikom (metoda compareTo razreda Oseba.. primerja starosti in če so enake
        // izpiše prvo, ki je napisana
        Collections.sort(osebe);
        System.out.println(osebe);

        //urejanje z dodatnik primerjalnikom (razred MojPrimerjalnik, metoda compare)
        osebe.sort(new MojPrimerjalnik());
        System.out.println(osebe);
    }
}
