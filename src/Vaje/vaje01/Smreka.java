package vaje01;

import static vaje01.Pravokotnik.pravokotnik;
import static vaje01.Trikotnik.trikotnik;

public class Smreka {
    public static void main(String[] args) {
        smreka(3);
    }

    private static void smreka(int velikost) {
        for(int i = 1; i <= velikost; i++) {
            trikotnik(2 * (velikost - i), i * 2);
        }

        int sirina = velikost;
        if(velikost % 2 == 0) {
            sirina += 1;
        }
        pravokotnik((4 * velikost - 1 - sirina) / 2, sirina, 2* velikost);
    }
}
