package predavanje03;

import java.util.Random;
public class Loto {
    public static void main(String[] args) {
        //int seme = 1; seed
        Random rd = new Random();
        for(int i = 0; i < 7; i++) {
            int nakljucnoSt = rd.nextInt(39)+1;
            System.out.printf("%d ", nakljucnoSt);
        }
        System.out.println();

    }
}
