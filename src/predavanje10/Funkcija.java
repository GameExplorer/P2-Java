package predavanje10;

/**
 * Vmesnik Funkcija
 * V vmesniku sta definirani dve metodi - vrednost in odvod
 * Vsak razred, ki sam o sebi pravi, da je Funkcija (implements Funkcija),
 * mora omenjeni metodi dejansko implementirati
 */
public interface Funkcija {
    double vrednost(double x);
    double odvod(double x);
}
