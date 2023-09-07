package Predavanja.predavanje05;

import java.io.File;
import java.util.Scanner;

/**
 * Preberem datoteko passwd in izpišem uporabniška imena (prvi podatek) in uid(tretji podatek) iz vsake
 * vrstice
 */
public class Users {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/Predavanja.predavanje05/passwd.txt"));

        while(sc.hasNextLine()) {
            String vrstica = sc.nextLine();
            String[] deli = vrstica.split(":"); //regularni izraz
            System.out.printf("Ime: %s, uid: %s\n", deli[0], deli[2]);
        }
    }
}
