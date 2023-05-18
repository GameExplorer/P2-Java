package predavanje13;

import java.io.Serializable;

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
