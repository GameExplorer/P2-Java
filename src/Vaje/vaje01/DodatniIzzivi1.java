package vaje01;

import static vaje01.Pravokotnik.pravokotnik;

public class DodatniIzzivi1 {
    public static void main(String[] args) {
        rombA(5, 3);

        System.out.println();
        rombPrazen(3,5);

        System.out.println();
        iks(3);
    }

    private static void rombA(int odmik, int velikosti) {
        for(int i = 0; i < velikosti; i++) {
            for(int j = 0; j < odmik + velikosti - i - 1; j++) {
                System.out.print("  ");
            }
            for(int j = 0; j < 2 * i + 1; j++) {
                System.out.print("# ");
            }

            System.out.println();
        }

        for (int i = velikosti - 2; i >= 0; i--) {
            for(int j = 0; j < odmik + velikosti - i - 1; j++) {
                System.out.print("  ");
            }
            for(int j = 0; j < 2 * i + 1; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    private static void rombPrazen(int odmik, int velikost) {
        for (int vrstica = 0; vrstica < velikost; vrstica++) {
            for (int stolpec = 0; stolpec < odmik; stolpec++) {
                System.out.print("  ");
            }
            for (int stolpec = 0; stolpec < 2 * velikost - 1; stolpec++) {
                if ((stolpec > velikost - vrstica - 1) && (stolpec < velikost + vrstica - 1)) {
                    System.out.print("  ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
        for (int vrstica = velikost - 2; vrstica >= 0; vrstica--) {
            for (int stolpec = 0; stolpec < odmik; stolpec++) {
                System.out.print("  ");
            }
            for (int stolpec = 0; stolpec < 2 * velikost - 1; stolpec++) {
                if ((stolpec > velikost - vrstica - 1) && (stolpec < velikost + vrstica - 1)) {
                    System.out.print("  ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }

    public static void dvaPravokotnika(int odmik, int sirina, int visina, int razmik) {
        for (int i = 0; i < visina; i++) {
            for (int k = 0; k < odmik; k++) {
                System.out.print(" ");
            }
            for (int k = 0; k < sirina; k++) {
                System.out.print("X");
            }
            for (int k = 0; k < razmik; k++) {
                System.out.print(" ");
            }
            for (int k = 0; k < sirina; k++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

    public static void iks(int n) {
        for (int i = 0; i < n - 1; i++) {
            dvaPravokotnika(5 * i, 5, 3, 5 * (2 * ((n - 1) - i) - 1));
        }
        pravokotnik(5 * (n - 1), 5, 3);
        for (int i = n - 2; i >= 0; i--) {
            dvaPravokotnika(5 * i, 5, 3, 5 * (2 * ((n - 1) - i) - 1));
        }
    }


}
