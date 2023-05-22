package predavanje13;

import java.net.URL;
import java.util.Scanner;

/**
 * Izpis HTML kode spletne strani
 */
public class Internet {
    public static void main(String[] args) {
        try {
            URL link = new URL("http://www.dilladimension.com/");
            Scanner sc = new Scanner(link.openStream());
            
            while(sc.hasNextLine()) {
                String vrstica = sc.nextLine();
                System.out.println(vrstica);
            }

            sc.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
