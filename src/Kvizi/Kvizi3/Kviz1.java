package Kvizi.Kvizi3;

import java.util.Arrays;

public class Kviz1 {
    public static int[] sestejPolinoma(int[] a, int[] b) {
        int[] x = new int[Math.max(a.length, b.length)];

        for(int i = 0; i < a.length; i++) {
            x[i] += a[i];
        }

        for(int i = 0; i < b.length; i++) {
            x[i] += b[i];
        }

        return x;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sestejPolinoma(new int[]{1,2,3}, new int[]{4,5,6})));
    }
}