package predavanje09.Funkcija;

/**
 * Abstrakten razred. Preprečimo da bi uporabnik iz tega razreda naredil objekte
 */
abstract public class Funkcija {
    protected abstract double vrednost(double x0);
    abstract double odvod (double x);


}
