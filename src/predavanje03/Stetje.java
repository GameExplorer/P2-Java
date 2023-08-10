package predavanje03;

/**
 * Program pošteje, koliko besed v podani tabeli se začne
 * na posamezno črke angleške besede
 */

public class Stetje {
    private static void prestejPrveCrke(String[] besede) {
        int[] t = new int[26]; // v tabeli so same ničle ko jo ustvarim

        /*
        Sprehod čez vse besede, pri vsaki besedi vzamem njeno prvo crko in v tabeli t povečam
        stevec, ki steje pojavitve te crke
         */

        for(int i = 0; i < besede.length; i++) {
            char crka = besede[i].charAt(0);
            int indeksCrke = crka - 'a';//a - a = 0    b - a = 1.... ascii
            t[indeksCrke]++;
        }

        //izpis podatkov (stevcev) iz tabele t
        for(int i = 0; i < t.length; i++) {
            System.out.printf("Število besed na črko '%c': %d%n", (char) i + 'a', t[i]);

        }

    }
    public static void main(String[] args) {
        //ustvarim tabelo z besedami
        String [] besede = new String [] { "pomlad", "jabolko", "jesen", "zima", "lopar", "bor"};

       prestejPrveCrke(besede);
    }
}