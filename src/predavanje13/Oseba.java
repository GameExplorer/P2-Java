package predavanje13;

import java.io.Serializable;

/**
 * Razred bomo uporabili za shranjevanje podatkov o osebah (ime in starost)
 * Ker bomo objekte tega razreda pisali v datoteko, moramo v glavi razreda
 * dodati zapis "implements Seializable" na ta način objekti tega razreda
 * postanejo tako, da se jih da spremeniti v tok bajtov (ki jih zapišemo v datoteko)
 * in da se da tok bajtov (ki ga preberemo iz datoteke) spremeniti nazaj v objekt
 */

class Oseba implements Serializable {
    String ime;
    int starost;

    public Oseba(String ime, int starost) {
        this.ime = ime;
        this.starost = starost;
    }

    public String toString() {
        return this.ime + " " + this.starost;
    }
}
