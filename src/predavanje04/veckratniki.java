package predavanje04;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class veckratniki {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Vpiši n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print("Vpiši a: ");
        int a = sc.nextInt();

        System.out.print("Vpiši b: ");
        int b = sc.nextInt();

        sc.close();
        PrintWriter pw = new PrintWriter("veckratniki.tx");

        for(int i = a; i <= b; i++) {
            pw.printf("%d * %d = %d", i,n, i * n);
        }

        pw.close();
    }
}

