package predavanje03;

import java.util.Scanner;
import java.util.Random;

public class Ugani {
    public static void main(String[] args) {
        System.out.print("Vnesi naključno število: ");

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
