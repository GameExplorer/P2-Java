package predavanje12;

public class Oseba implements Comparable<Oseba> {
    String ime;   // ime osebe
    int starost;  // starost osebe
    double ocena; // povprecna ocena na FRI

    public Oseba(String ime, int starost, double ocena) {
        this.ime     = ime;
        this.starost = starost;
        this.ocena   = ocena;
    }

    @Override
    public String toString() {
        return String.format("%s (s: %d, o: %.2f)", ime, starost, ocena);
    }

    public double getOcena() {return ocena;}

    @Override
    public int compareTo(Oseba o) {
        return this.starost - o.starost; // primerjava po starosti
    }
}
