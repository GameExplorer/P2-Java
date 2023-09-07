package Predavanja.predavanje12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Izjeme2 {

    static Scanner odpriDatoteko(String imeDatoteke) throws FileNotFoundException {
        return new Scanner(new File(imeDatoteke));
    }

    public static void main(String[] args) /*throws Exception*/ { //moram napisati throw ali pa v try bloku
        // za obravnavo preverljivih izjem (metoda odpriDatoteko lahko sproži
        // šreverljivo izjemo tipa FileNotFoundException) moramo napisati try-catch blok
        try  {
            Scanner sc = odpriDatoteko("src/Predavanja.predavanje11/Fis/drzave.txt");
            System.out.println("Uspešno odprta datoteka");
        }
        catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

        //Ker smo v glavi napisali throws Exception lahko kličemo brez try-catch bloka
        //Scanner sc1 = odpriDatoteko("src/Predavanja.predavanje11/Fis/drzave.txt");
    }
}
