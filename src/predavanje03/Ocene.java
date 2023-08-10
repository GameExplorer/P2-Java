package predavanje03;

import java.util.Scanner;

/**
 * Program bere ocene dokler uporabnik ne vpise 0 in izpise povprečje prebranih ocen
 */
public class Ocene {
    public static void main(String[] args) {
        int vsota = 0;
        double povprecje = 0;
        int trenutnoVpisanaOcena;
        int n = 0;

        do {
            System.out.print("Vpiši oceno: ");
            Scanner sc = new Scanner(System.in);
            trenutnoVpisanaOcena = sc.nextInt();
            if(trenutnoVpisanaOcena < 0 || trenutnoVpisanaOcena > 10) {
                System.out.println("Neveljavna ocena");
                continue;
            }
            if (trenutnoVpisanaOcena != 0) {
                    vsota += trenutnoVpisanaOcena;
                    n++;
            }
        }
        while(trenutnoVpisanaOcena != 0);
        if(n != 0) System.out.printf("Povprečje ocen je %.2f", 1.0*vsota / n); //ali pa castaš
        else System.out.println("Ni vpisanih ocen");
    }
}