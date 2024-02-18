package vaje01;

public class Trikotnik {
    public static void main(String[] args) {
        trikotnikStevil(3); //a) in b)
        System.out.println();

        trikotnikStevilObrnjen(3); //c)
        System.out.println();

        trikotnikstevil(5);
        System.out.println();

        trikotnik(5,3);
        System.out.println();

        trikotnikObrnjen(5, 3);
    }


    private static void trikotnikStevil(int visina) {
        for(int i = 1; i <= visina; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j); // za a) izpišemo i za b) pa j
            }
            System.out.println();
        }
    }

    private static void trikotnikStevilObrnjen(int visina) {
        for(int i = visina; i > 0; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print(i); // za a) izpišemo i za b) pa j
            }
            System.out.println();
        }
    }

    public static void trikotnikstevil(int visina) {
        for(int i = 1; i <= visina; i++) {
            for(int k = 0; k <= visina - i; k++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*i-1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void trikotnik(int odmik, int visina) {
        for(int i = 0; i < visina; i++) {
            for(int k = 0; k < odmik + (visina - i - 1); k++) {
                System.out.print(" ");
            }
            for(int j = 0; j < 2*i+1; j++) {
                System.out.print("*"); //"*" za f) primer
            }
            System.out.println();
        }
    }

    static void trikotnikObrnjen(int odmik, int visina) {
        for(int i = visina - 1; i >= 0; i--) {
            for(int k = 0; k < odmik + (visina - i - 1); k++) {
                System.out.print(" ");
            }
            for(int j = 0; j < 2*i+1; j++) {
                System.out.print("*"); // za a) izpišemo i za b) pa j

            }
            System.out.println();
        }
    }
}
