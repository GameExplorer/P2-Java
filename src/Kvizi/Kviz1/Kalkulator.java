package Kviz1;

public class Kalkulator {
    public static void main(String[] args) {
        kalkulator(42, 13);

    }

    private static void kalkulator(int a, int b) {
        if (b == 0) {
            System.out.println("Napaka: deljenje z 0");
        }
        else {
            System.out.printf("%d + %d = %d\n", a, b, a + b);
            System.out.printf("%d - %d = %d\n", a, b, a - b);
            System.out.printf("%d x %d = %d\n", a, b, a * b);
            System.out.printf("%d / %d = %d\n", a, b, a / b);
            System.out.println(a + " % " + b + " = " + a % b);
        }
    }
}
