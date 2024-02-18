package kviz3;

import java.util.Arrays;

public class SestejPolinom {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sestejPolinoma(new int[] {1,2,3,}, new int[]{4,5,6})));
    }
    public static int[] sestejPolinoma(int[] a, int[] b) {
        int[] c = new int[Math.max(a.length, b.length)];

        for(int i = 0; i < a.length; i++) c[i] += a[i];
        for(int i = 0; i < b.length; i++) c[i] += b[i];

        return c;
    }
}