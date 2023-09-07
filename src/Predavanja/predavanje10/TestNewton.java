package Predavanja.predavanje10;

/**
 * Razred Polinom je razširitev abstraktnega razreda Funkcija
 * Polinom je opisan s tabelo koeficinetov (ti se podajo ob klicu konstruktorja)
 * vrednost polinoma in vrednost odvoda pa definirata istoimenski metodi vrednost in odvod
 * Ker razred uporabljamo samo v razredu TestNewton smo kodo razreda
 * pisali kar v dat. TestNewton.java. Druga možnost: kodo bi pisali v svoji datoteki, razred pa
 * bi proglasili za public, potem bi razred Polinom lahko uporabljali v poljubnem drugem razredu.
 */
class Polinom implements Funkcija {

    double[] koef;

    Polinom(double[] koef) {
        this.koef = koef;
    }

    public double vrednost(double x) {
        double vrednost = 0;
        double xx = 1;

        for (double v : koef) {
            vrednost += v * xx;
            xx = xx * x;
        }
        return vrednost;
    }

    public double odvod(double x) {
        double vrednost = 0;
        double xx = 1;

        for(int i = 1; i < koef.length; i++) {
            vrednost += i * koef[i] * xx;
            xx = xx * x;
        }
        return vrednost;
    }
}

public class TestNewton {
    public static void main(String[] args) {
        double nicla = Newton.nicla(0, new Predavanja.predavanje10.Funkcija() {
            public double vrednost(double x) {
                return Math.cos(x);
            }
            public double odvod(double x) {
                return -Math.sin(x);
            }
        }, 10);

    }
}
