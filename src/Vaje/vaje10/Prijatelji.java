package vaje10;

import java.util.*;

/**
 * Unikatna številka se sama povečuje. Id se samodejno povečuje Hranimo tudi kdo komu dolguje denar.
 */
public class Prijatelji implements Comparable<Prijatelji> {
    private static final int naslednjiID = 1;
    private final int id;
    private final String ime;
    private TreeMap<Prijatelji, Double> dolguje; //pari (prijatelj, znesek dolga)


    public Prijatelji(String ime) {
        this.ime = ime;
        this.id = naslednjiID;
        this.dolguje = new TreeMap<>();
    }

    public String getIme() {
        return ime;
    }

    public String toString() {
        return String.format("[%03d] %s", this.id, this.ime);
    }

    /**
     * Doda dolg prijatelju
     * @param p - prijatelj
     * @param znesek - znesek ki se doda dolgu
     */
    public void dodajDolg(Prijatelji p, double znesek) {
        double dolg = znesek;
        if(this.dolguje.containsKey(p)) {
            dolg += this.dolguje.get(p);
        }
        this.dolguje.put(p, dolg);
    }

    /**
     * Skupni znesek dolga
     * @return  - vrne skupni znesek dolga
     */
    public double vrniSkupniZnesekDolga() {
        double dolg = 0;
        for(double d : dolguje.values()) {
            dolg += d;
        }
        return dolg;
    }

    /**
     * Pogleda, če ima prijatelj dolg
     * @return - vrne true, če ima dolg
     */
    public boolean imaDolg() {
        return !this.dolguje.isEmpty();
    }

    /**
     * Poleg številke in imena prijatelja v niz doda tudi vse
     * prijatelje ki jim ta prijatelj dolguje
     * @return
     */
    public String vrniOpisZDolgovi() {
        StringBuilder tmp = new StringBuilder();

        if(this.dolguje.isEmpty()) {
            tmp.append("Nima dolgov");
        }
        else {
            tmp.append(" ima dolgove do naslednjih prijateljev:\n");

            for(Prijatelji p: this.dolguje.keySet()) {
                tmp.append("   --->");
                tmp.append(p.toString());
                tmp.append(String.format(" (%.2f EUR)", this.dolguje.get(p)));
                tmp.append("\n");
            }
        }
        return tmp.toString();
    }

    public int compareTo(Prijatelji p) {
        return this.ime.compareTo(p.ime);
    }

}