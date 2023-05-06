package predavanje11;

import java.util.Comparator;

/**
 * Razred z dvema atributoma (ime in starost)
 * Razeed implementira Comparable (ima napisano metodo compareTo)
 * zato lahko zbirke objektov tega razreda urejamo v vgrajenimi javanskimi metodami sort()
 */

public class Oseba implements Comparable<Oseba> {

    String ime;
    int starost;

    public Oseba(String ime, int starost) {
        this.ime = ime;
        this.starost = starost;
    }

    public String toString() {
        return String.format("Ime: %s ",ime, " starost: %d", starost);
    }

    /*
    Metoda compareTo primerja dva objekta (this in o) in vrne:
    <0 (npr. -1) če je this manjši od o
    >0 (npr. 1) če je this večji od o
    0 je this enak o
     */
    public int compareTo(Oseba o) {
        //v tje memtodi primerjam  s this
        //vrnim -1 če sem jaz manjši od o, 1 če sem jaz večji od o in 0 če sva enaka

        return this.starost - o.starost;
    }
}
