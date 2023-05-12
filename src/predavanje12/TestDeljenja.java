package predavanje12;

/**
 * Uporaba lastnega razreda za izjeme (DeljenjeZNic)
 * Metoda (deli) preveri ali je deljenje možno - če je, deli in vrne rezultat, sicer
 * ustvari in vrže novo izjemo tipa DeljenjeZNic
 */
public class TestDeljenja {

    static double deli(double a, double b) throws DeljenjeZNic {
        if(b == 0) throw new DeljenjeZNic();
        return a/b;
    }
    public static void main(String[] args) {
        try {
            //deli(5, 0);
            System.out.println("Rezultat je: " + deli(5,0));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}