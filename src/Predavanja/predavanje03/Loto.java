package Predavanja.predavanje03;

import java.util.Random;

/**
 * Izpis 7 naključnih števil
 */
public class Loto {
    public static void main(String[] args) {
        //int seme = 1; seed
        Random rd = new Random();
        for(int i = 0; i < 5; i++) {
            int nakljucnoSt = rd.nextInt(50)+1;
            System.out.printf("%d ", nakljucnoSt);
        }
        System.out.println();
        System.out.println("--------------");

        for(int i = 0; i < 2; i++) {
            int dodatniSt = rd.nextInt(12)+1;
            System.out.printf("%d ", dodatniSt);
        }
    }
}