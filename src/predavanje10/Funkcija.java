package predavanje10;

/**
 * Vmesnik Funkcija
 * V vmesniku sta definirani dve metodi - vrednost in odvod
 * Vsak razred, ki sam o sebi pravi, da je Funkcija (implements Funkcija),
 * mora omenjeni metodi dejansko implementirati
 */
public interface Funkcija {
    public double vrednost(double x);
    public double odvod(double x);
}
