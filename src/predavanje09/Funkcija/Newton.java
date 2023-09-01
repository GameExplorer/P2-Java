package predavanje09.Funkcija;

/**
 * Razred definira metodo nicla(), ki s pomočjo znane Newtonove iteracijske metode izračuna
 * približek ničle podane funkcije
 */
public class Newton {

    static double nicla(double x0, Funkcija f, double n) {
        for(int i = 0; i < n; i++) {
            x0 = x0 - f.vrednost(x0) / f.odvod(x0);
        }

        return x0;
    }
}
