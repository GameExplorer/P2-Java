package Predavanja.predavanje09.Funkcija;

/**
 * Razširitev razreda Funkcija - definiramo metodi vrednost in odvnod tako, da funkcija
 * ustreza realni funkciji sinus
 */
class Sinus extends Funkcija {
    public double vrednost(double x) {
        return Math.sin(x);
    }
    double odvod(double x) {
        return Math.cos(x);
    }
}
public class TestNewton {
    public static void main(String[] args) {
        Funkcija f = new Sinus(); //Sinus je funkcija .. primerek razširjenega razreda
        double x = Newton.nicla(3,f,3);
        System.out.println(x);
        System.out.println(Math.PI);
    }
}
