package predavanje11;

import java.util.Comparator;

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

    public int compareTo(Oseba o) {
        //v tje memtodi primerjam  s this
        //vrnim -1 če sem jaz manjši od o, 1 če sem jaz večji od o in 0 če sva enaka

        return this.starost - o.starost;
    }
}
