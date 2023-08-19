package predavanje04;

/**
 * Program za delo z mnozico znakov
 * v enem stevilu tipa int imam na razpolago 31 bitov, ki jih lahko porabim za
 * implementacijo množice, če je bit prizgan, je pripadajoci element v mnozici,
 * sicer elementa ni v mnozici.
 * Ker ima angleška abeceda 26 črk, imamo v int-u dovolj prostora, da si zapomnimo
 * katere črke so v mnozici in katere niso
 *a si zapo
 * Bit '0' pripada crki 'a', bit '1' pripada crki 'b',...
 */
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

    // v prazni mnozici ni nobenega elementa (vsi biti so ugasnjeni)
    private static int getPraznaMnozica() {
        return 0;
    }

    // element dodam v mnozico tako, da prizgem bit, ki temu elementu pripada
    private static int dodajElement(int mnozica, char c) {
        // naprej ugotovim kateri bit pripada temu znaku
        int i = bitZnaka(c);

        // nato pržgemo i-ti bit v množici
        mnozica = mnozica | (1 << i);

        return mnozica;
    }

    // Preslikava med crko in bitom, ki tej crki pripada a -> 0, b -> 1,...
    // Metoda vrne zaporedno stevilko bita
    // 0 .. a
    // 25 .. z
    private static int bitZnaka(char c) {
        return c - 'a';
    }

    /*
    po vrsti pregledam bit in za vsak prizgan bit v rezultat dodam znak, ki temu bitu pripada
    Primer: če so v mnozici znaki 'a', 'f' in 'z' metoda vrne niz "[a,f,z]"
     */
    private static String toString1(int mnozica) {
        String result = "";
        int bit = 1;
        for(char c = 'a'; c <= 'z'; c++) {
            if((mnozica & bit) != 0) result = result + (result.isEmpty() ? "" : ",") + c;

            bit = bit << 1;
        }
        return "[ " + result + " ]";
    }

    /**
     * Presek dveh mnozic: v rezultatu obdrzim le tiste bite, ki so prizgani pri obeh mnozicah
     */
    private static int presek(int m1, int m2) {
        return m1 & m2;
    }

    /**
     * Unija dveh mnozic: v rezultatu obdrzim vse tiste bite, ki so prizgani v vsaj eni od obeh mnozic
     */
    private static int unija(int m1, int m2) {
        return m1 | m2;
    }
}