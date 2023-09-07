package Predavanja.predavanje11;

import java.util.Set;
import java.util.TreeSet;


/**
 * TUkaj smo uprabili ArrayList in TreeSet
 *
 * Izpis vseh deliteljev, ki
 * a) delijo bodisi a bodisi b (unija deliteljev)
 * b) delijo a in hkrati b (presek deliteljev)
 */
public class Delitelji {
    public static /*ArrayList<Integer>*/ Set<Integer> seznamDeliteljev(int n) {
        //ArrayList<Integer> delitelji = new ArrayList<Integer>();
        Set<Integer> delitelji = new TreeSet<>();

        //Sprehod čez vse možne kandidate

        for(int i = 1; i <= n/2; i++) {
            if(n % i == 0) delitelji.add(i); //Če i deli n ga dodam v seznam
        }
        delitelji.add(n);

        return delitelji;
    }
    public static void main(String[] args) {
        int a = 42; int b = 570;

        Set<Integer> d1 = seznamDeliteljev(a);
        System.out.printf("Delitelji števila %d: %s%n", a, d1);

        Set<Integer> d2 = seznamDeliteljev(b);
        System.out.printf("Delitelji števila %d: %s%n", b, d2);


        Set<Integer> unija = new TreeSet<>(d1); // unija vsebuje vse elemente d1
        unija.addAll(d2);                       // dodam še d2
        System.out.println("Unija: " + unija);

        Set<Integer> presek = new TreeSet<>(d1); //vsi elementi d1
        presek.retainAll(d2);                    //in d2 ... retain obdrži elemente, ki so v preseku
        System.out.println("Presek: " + presek);
    }
}
