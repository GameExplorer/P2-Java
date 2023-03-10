package predavanje04;

public class MnozicaBitov {
    public static void main(String[] args) {
        int mnozica1 = getPraznaMnozica();
        mnozica1 = dodajElement(mnozica1, 'a');
        mnozica1 = dodajElement(mnozica1, 'e');
        mnozica1 = dodajElement(mnozica1, 'i');
        mnozica1 = dodajElement(mnozica1, 'z');
        System.out.printf("Množica1 = %s%n", toString1(mnozica1));


        int mnozica2 = getPraznaMnozica();
        mnozica2 = dodajElement(mnozica2, 'a');
        mnozica2 = dodajElement(mnozica2, 'e');
        mnozica2 = dodajElement(mnozica2, 'r');
        mnozica2 = dodajElement(mnozica2, 'i');
        mnozica2 = dodajElement(mnozica2, 's');
        mnozica2 = dodajElement(mnozica2, 'w');
        System.out.printf("Mnozica2 = %s%n", toString1(mnozica2));

        int presek = presek(mnozica1, mnozica2);
        int unija = unija(mnozica1, mnozica2);

        System.out.printf("presek (%s %s) = %s%n", toString1(mnozica1), toString1(mnozica2), toString1(presek));
        System.out.printf("unija (%s %s) = %s%n", toString1(mnozica1), toString1(mnozica2), toString1(unija));
    }

    private static int getPraznaMnozica() {
        return 0;
    }

    private static int dodajElement(int mnozica, char c) {
        int i = bitZnaka(c);

        //pržgemo i-ti bit v množici
        mnozica = mnozica | (1 << i);
        return mnozica;
    }

    //metoda vrne bit, ki pripada znaku
    // 0 .. a
    // 25 .. z
    private static int bitZnaka(char c) {
        return c - 'a';
    }

    private static String toString1(int mnozica) {
        String result = "";
        int bit = 1;
        for(char c = 'a'; c <= 'z'; c++) {
            if((mnozica & bit) != 0) result = result + (result.isEmpty() ? "" : ",") + c;

            bit = bit << 1;
        }
        return "[ " + result + " ]";
    }

    private static int presek(int m1, int m2) {
        return m1 & m2;
    }

    private static int unija(int m1, int m2) {
        return m1 | m2;
    }
}
