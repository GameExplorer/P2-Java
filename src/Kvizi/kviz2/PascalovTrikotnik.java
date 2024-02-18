package kviz2;

import java.util.Arrays;

public class PascalovTrikotnik {
    public static void main(String[] args) {
        int[] rez = pascal(5);
        System.out.println(Arrays.toString(rez));
    }

    public static int[] pascal(int n) {
        int[] pascal = new int[n];
        pascal[0] = 1;
        for (int i = 1; i < n; i++) {
            pascal[i] = (int)((long)pascal[i-1] * (n-i) / i);
        }
        return pascal;
    }

}
