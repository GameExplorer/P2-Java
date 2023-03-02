package predavanje03;


public class Stetje {
    private static void prestejPrveCrke(String[] besede) {
        int[] t = new int[26]; // v tabeli so same ničle

        //stetje
        for(int i = 0; i < besede.length; i++) {
            char crka = besede[i].charAt(0);
            int indeksCrke = crka - 'a';//a - a = 0    b - a = 1....
            t[indeksCrke]++;
        }

        //izpis
        for(int i = 0; i < t.length; i++) {
            System.out.printf("Število besed na črko '%c': %d%n", (char) i + 'a', t[i]);

        }

    }
    public static void main(String[] args) {
        String [] besede = new String [] { "pomlad", "jabolko", "jesen", "zima", "lopar", "bor"};

       prestejPrveCrke(besede);
    }

}
