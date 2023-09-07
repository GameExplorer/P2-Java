package Predavanja.predavanje04;

import java.util.Arrays;

/**
 * uporaba i++, ++i, i=+1; i+1
 */
public class Ipp {
    public static void main(String[] args) {
        int[] t;
        int i = 0;

        t = new int[]{1,2,3};
        t[i++] = 5; //najprej zapiše 5 nato poveča števec
        System.out.printf("i=%d t=%s%n", i, Arrays.toString(t)); // i = 1 t=[5,2,3]

        t = new int[]{1,2,3}; i = 0;
        t[++i] = 5; //najprej poveča števec nato zapiše 5
        System.out.printf("i=%d t=%s%n", i, Arrays.toString(t)); // i = 1 t=[1,5,3]

        t = new int[]{1,2,3}; i = 0;
        t[i=i+1] = 5; //podoben zapis kot pri drugem primeru
        System.out.printf("i=%d t=%s%n", i, Arrays.toString(t)); // i = 1 t=[1,5,3]

        t = new int[]{1,2,3}; i = 0;
        t[i+1] = 5; //podoben zapis kot pri drugem primeru
        System.out.printf("i=%d t=%s%n", i, Arrays.toString(t)); // i = o t=[1,5,3]

    }
}
