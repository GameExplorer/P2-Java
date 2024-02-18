package vaje02;

public class Fakulteta {
    public static void main(String[] args) {
        //1
        System.out.println(fakulteta(10));
        System.out.println(stirlingFormula(10));

        System.out.println();
        //3 do 21 oz. do 20
        //4
        System.out.println(fakultetaD(8));
        System.out.println(stirlingD(8));

        //2
        System.out.println();
        izpisTabele();

        //5
        System.out.println();
        izpisTabele100();

        //Dodatni izzivi

        //6
        System.out.println();
        izracunajPi(5);
        izracunajPiRekurzivno(5);

        System.out.println();
        izpisTabelePi();

    }

    private static long fakulteta(int n) {
        long rezultat = 1;
        for(long i = 1; i <= n; i++) {
            rezultat *= i;
        }
        return rezultat;
    }

    private static double fakultetaD(int n) {
        double rezultat = 1;
        for(long i = 1; i <= n; i++) {
            rezultat *= i;
        }
        return rezultat;
    }

    private static long stirlingFormula(int n) {
        return Math.round(Math.sqrt(2 * Math.PI * n) * Math.pow((n/Math.E),n));
    }
    private static double stirlingD(int n) {
        return Math.sqrt(2 * Math.PI * n) * Math.pow((n/Math.E),n);
    }

    private static void izpisTabele() {
        System.out.printf("%3s %15s %22s %15s%n", "n", "n!", "Stirling(n)", "napaka (%)");

        //izpis glave
        for(int i = 0; i < 58; i++) System.out.print("-");
        System.out.println();

        for(int i = 1; i <= 20; i++) { //long največ gre do
            long factorial = fakulteta(i);
            long stirling = stirlingFormula(i);
            double napaka = 100.0 * (factorial - stirling) / factorial;
            System.out.printf("%3d %20d %20d %11.7f%n", i, factorial, stirling, napaka);
        }
    }

    //izpis do 100 vrednosti
    private static void izpisTabele100() {
        System.out.printf("%3s %15s %22s %15s%n", "n", "n!", "Stirling(n)", "napaka (%)");

        //izpis glave
        for(int i = 0; i < 58; i++) System.out.print("-");
        System.out.println();

        for(int i = 1; i <= 100; i++) {
            double factorial = fakultetaD(i);
            double stirling = stirlingD(i);
            double napaka = 100.0 * (factorial - stirling) / factorial;
            System.out.printf("%3d %20.9e %20.9e %11.7f%n", i, factorial, stirling, napaka);
        }
    }


    public static double izracunajPi(int k) {
        double rez = 0.0;
        for (int i = k - 1; i > 0; i--) {
            rez = (i * i) / ((2.0 * i + 1.0) + rez);
        }
        return 4.0 / (1.0 + rez);
    }

    private static double ulomek(int x, int max) {
        if (x == max) {
            return 0.0;
        }
        return (x * x) / ((2.0 * x + 1.0) + ulomek(x + 1, max));
    }

    private static double izracunajPiRekurzivno(int k) {
        return 4.0 / (1 + ulomek(1, k));

    }

    private static void izpisTabelePi() {
        System.out.printf("%3s %15s %30s %25s %15s%n", "k", "Math.PI", "PI (rekurzivno)", "PI (iterativno)", "razlika");

        for(int i = 0; i <= 101; i++) {
            System.out.print("-");
        }
        System.out.println();
        for(int i = 1; i <= 22; i++) {
            double rez = Math.PI - izracunajPiRekurzivno(i);
            System.out.printf("%3d %23.15f %23.15f %25.15f %23.15f%n", i, Math.PI, izracunajPiRekurzivno(i), izracunajPi(i), rez );
        }
    }
}
