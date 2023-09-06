package Kvizi.Kvizi3;

import java.util.Arrays;

public class Kviz2 {
    public static int[] zmnoziPolinoma(int[] a, int[] b) {
        int[] c = new int[a.length + b.length - 1];

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++) {
                c[i + j] += a[i] * b[j];
            }
        }

        return c;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(zmnoziPolinoma(new int[]{1,2,3}, new int[]{4,5,6})));
    }
}
