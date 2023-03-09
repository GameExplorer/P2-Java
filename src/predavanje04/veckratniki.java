package predavanje04;

import java.util.Scanner;

public class veckratniki {
    public static void main(String[] args) {
        System.out.print("Vpiši n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print("Vpiši a: ");
        int a = sc.nextInt();

        System.out.print("Vpiši b: ");
        int b = sc.nextInt();

        for(int i = a; i <= b; i++) {
            System.out.printf("%d * %d = %d", i,n, i * n);
        }
    }
}

