package Predavanja.predavanje03;

import java.util.Scanner;
import java.util.Random;

/**
 * Uporabnik poskuša uganiti število. Sami izberemo interval, nato z random iz tega intervala izberemo
 * naključno število, ki ga poskušamo uganiti. Na koncu se izpiše število poskusov
 */
public class Ugani {
    public static void main(String[] args) {
        System.out.print("Vnesi interval (MAX ŠTEVILO): ");

        Scanner sc = new Scanner(System.in);
        int r_st = sc.nextInt();

        Random rnd = new Random();
        int nakljuno_St = rnd.nextInt(r_st)+1;

        int poskusi = 0;
        int prebranoSt = 0;

        do{
            poskusi++;
            System.out.print("Vnesi število: ");
            prebranoSt = sc.nextInt();
            if (prebranoSt > nakljuno_St) System.out.println("PREVEČ!");
            else if (prebranoSt < nakljuno_St) System.out.println("PREMALO!");
            else break;


        } while(true);

        System.out.printf("BRAVO uganil si število. Število %d je ta pravo ugotovil si v %d poskusih", prebranoSt,poskusi);
    }
}
