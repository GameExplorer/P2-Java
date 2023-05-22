package predavanje13;

import java.net.URL;
import java.util.Scanner;

/**
 * Izpiše trenutno vrednost izbrane kriptovalute
 */
public class BTCPretvornik {

    public static void main(String[] args) {
        try {
            String in = "ETH";
            String out = "EUR";

            //prebrali bomo odgovor, ki ga dobimo na tem naslovu
            URL url = new URL("https://min-api.cryptocompare.com/data/price?fsym=" +in+ "&tsyms="+out);
            Scanner sc = new Scanner(url.openStream());
            //preberemo samo eno vrstico - toliko je dolg odgovor
            String odgovor = sc.nextLine();

            //iz odgovora, ki je oblike "{"EUR":znesek}" izlocimo samo znesek
            odgovor = odgovor.replace("{", "").replace("}", "");
            String[] deli = odgovor.split(":");

            System.out.println(deli[1]);

            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}