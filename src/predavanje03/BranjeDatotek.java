package predavanje03;

import java.io.File;
import java.util.Scanner;

public class BranjeDatotek {
    /**
     * Če v metodi delam nekaj nevarnega (branje iz datoteke) moram v glavo
     * metode dodati "throws Exception" sicer se program ne prevede.
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //odpiranje s prvim argumentom
        //Scanner sc = new Scanner(new File(args[0]));

        //odpiranje s podanim imenom
        Scanner sc = new Scanner(new File("src/predavanje03/bitcoin.txt"));

        //Brali bomo vrstico po vrstici, dokler ne bomo prišli do konca datoteke
        while(sc.hasNextLine()) {
            String vrstica = sc.nextLine();
            System.out.println(vrstica);
        }

        //datoteko OBVEZNO zaprem
        sc.close();
    }
}
