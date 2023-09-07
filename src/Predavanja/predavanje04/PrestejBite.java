package Predavanja.predavanje04;

/**
 * Kateri biti so prizgani v stevilu x?
 * Stevilo premikam po bitih v desno dokler ne dobim 0;
 * na vsakem koraku pogledam ali je zadnji bit prizgan
 * ce je povecam stevec števila prizganih bitov v stevilu n
 */
public class PrestejBite {
    public static void main(String[] args) {
        int x = 63;

        int stBitov = prestejBite(x);

        System.out.printf("Število prižganih bitov v številu %d je %d%n", x, stBitov);
    }

    private static int prestejBite(int x) {
        int biti = 0; //st prizganih bitov
        while(x != 0) {
            //ali je bit prizgan?
            if((x & 1) == 1) biti++;

            //x po bitih premaknem v desno
            x = x >> 1;
            System.out.println(x);
        }
        return biti;
    }
}