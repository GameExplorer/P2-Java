package vaje01;

public class Pravokotnik {
    public static void main(String[] args) {
        pravokotnikStevil(12, 3);
        System.out.println();
        pravokotnik(5,7,3);
        System.out.println();
    }

    private static void pravokotnikStevil(int sirina, int visina) {
        for(int i = 1; i <= visina; i++) {
            for(int j = 1; j <= sirina; j++) {
                System.out.print((j + 1) % 10); // za a) izpišemo i za b) pa j
            }
            System.out.println();
        }
    }
    static void pravokotnik(int odmik, int sirina, int visina) {

        for(int i = 1; i <= visina; i++) {
            for(int k = 0; k < odmik; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= sirina; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

}
