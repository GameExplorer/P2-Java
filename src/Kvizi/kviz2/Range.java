package kviz2;

import java.util.Arrays;

public class Range {
    public static void main(String[] args) {
        int[] rez = {0,10,2};
        System.out.println(Arrays.toString(rez));
    }

    public static int[] range(int a, int b, int c) {
        // Izračunamo število elementov v tabeli
        int count = (int) Math.ceil((double) (b - a) / c);
        // Ustvarimo tabelo z ustreznim številom elementov
        int[] result = new int[count];
        // Napolnimo tabelo z elementi a, a+c, a+2c, a+3c, ...
        for (int i = 0; i < count; i++) {
            result[i] = a + i * c;
        }
        // Če zadnji element v tabeli preseže ali doseže b, ga odstranimo
        if (result[result.length - 1] >= b) {
            result = Arrays.copyOf(result, result.length - 1);
        }
        return result;
    }

}
