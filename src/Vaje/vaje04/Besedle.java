package vaje04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Besedle {

    // Konstante barv
    static final int BELA = 0;
    static final int CRNA = 1;
    static final int RUMENA = 2;
    static final int ZELENA = 3;

    // ANSI ukazi (za barvni izpis)
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_GREEN_BG = "\u001b[42m";
    static final String ANSI_YELLOW_BG = "\u001b[43m";
    static final String ANSI_WHITE_BG = "\u001b[47;1m";
    static final String ANSI_BLACK_BG = "\u001b[40m";
    static final String ANSI_WHITE = "\u001b[37m";
    static final String ANSI_BLACK = "\u001b[30m";

    static final String abeceda = "ABCČDEFGHIJKLMNOPRSŠTUVZŽ"; // Veljavne črke
    static final int MAX_POSKUSOV = 6; // Število poskusov

    static String[] seznamBesed; // Seznam vseh možnih besed
    static String[] slovar; // Dodatna naloga: seznam vseh veljavnih besed

    static String iskanaBeseda; // Iskana beseda trenutne igre
    static int[] barveAbecede; // Barve črk pri izpisu abecede

    static Scanner sc = new Scanner(System.in);


    //Izpiše znak v izbrani barvi
    public static void izpisZBarvo(char znak, int barva) {
        String slog;
        if (barva == ZELENA) {
            slog = ANSI_BLACK + ANSI_GREEN_BG;
        } else if (barva == RUMENA) {
            slog = ANSI_BLACK + ANSI_YELLOW_BG;
        } else if (barva == BELA) {
            slog = ANSI_BLACK + ANSI_WHITE_BG;
        } else {
            slog = ANSI_WHITE + ANSI_BLACK_BG;
        }
        System.out.print(slog + " " + znak + " " + ANSI_RESET);
    }

    //Prebere besedo iz datoteke
    public static void preberiBesede(String datoteka) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(datoteka));
        int stBesed = sc.nextInt(); // Prebere število besed


        seznamBesed = new String[stBesed]; //Seznam besed

        //Preberemo besede in jih shranimo v seznamBesed
        for(int i = 0; i < stBesed; i++) {
            seznamBesed[i] = sc.next().toUpperCase();
        }

        sc.close(); //obvezno na koncu zapremo Scanner!

    }

    /**
     * Naključno izbere besedo iz seznamBesed in jo shrani v iskanaBeseda
     * Ponastavi vse barve abecede na belo
     */
    public static void novaIgra() {
        Random rnd = new Random();

        //izbere naključno besedo iz seznamBesed in jo shrani v iskanaBeseda
        iskanaBeseda = seznamBesed[rnd.nextInt(seznamBesed.length)];

        //Nastavi barve abecede na 0 ( BELA = 0)
        barveAbecede = new int[abeceda.length()];
    }

    /**
     * Metoda izpiše vse črke v abecedi z ustreznimi barvami. Barva izpis je
     * določena v tabeli baarveAbecede.
     */
    public static void izpisiAbecedo() {
        System.out.println();
        System.out.print("Preostale črke: ");

        //Sprehodim se po abecedi in izpišem ter pobarvam vsak znak abecede z ustrezno barvo
        for(int i = 0; i < abeceda.length(); i++) {
            izpisZBarvo(abeceda.charAt(i), barveAbecede[i]);
        }
        System.out.println();
    }

    /**
     *
     * @param beseda
     * @return
     */
    public static boolean veljavnaBeseda(String beseda) {
        //Preveri dolžino besede, v primeru da ni dolga 5 javi napako
        if(beseda.length() != 5) {
            System.out.println("Nepravilna dolžina besede!");
            return false;
        }

        //Preveri ali so vsi znaki veljavni (torej, če so v abecedi)
        for(int i = 0; i < beseda.length(); i++) {
            if(abeceda.indexOf(beseda.charAt(i)) < 0) {
                System.out.println("V besedi so neveljavni znaki");
                return false;
            }
        }

        //Dodatna naloga preveri ali besede morda ni v slovarju
        if(!besedaVSlovarju(beseda)) {
            System.out.println("Besede ni v slovarju!");
            return false;
        }
        return true;
    }

    /**
     * Določi barve ugibane besede. Vsako število v tabeli določa barvo črke na tistem mestu.
     * ZELENA: ujema se s črko na istem mestu v iskani besedi
     * RUMENA: se enaka črka nahaja na katerem koli drugem mestu v iskani besedi
     * BELA: v primeru da te črke ni v iskani besedi
     * @param ugibanaBeseda
     * @return
     */
    public static int[] pobarvajBesedo(String ugibanaBeseda) {
        int[] barve = new int[ugibanaBeseda.length()];

        for(int i = 0; i < ugibanaBeseda.length(); i++) {
            int ind = abeceda.indexOf(ugibanaBeseda.charAt(i));

            //Če je črka v ugibani besedi enaka tisti v iskani besedi jo pobarvaj ZELENO
            if(ugibanaBeseda.charAt(i) == iskanaBeseda.charAt(i)) {
                barve[i] = ZELENA; //pobarva črko ZELENO v besedi
                barveAbecede[ind] = ZELENA; //pobarva črko ZELENO v abecedi
            }
            //Črka na napačnem mestu, RUMENA
            else if (iskanaBeseda.indexOf(ugibanaBeseda.charAt(i)) >= 0 ) {
                barve[i] = RUMENA; //Pobarva črko rumeno v besedi
                //Če je črka ZELENA jo pusti zeleno, sicer jo pobarvaj RUMENO
                barveAbecede[ind] = barveAbecede[ind] == ZELENA ? ZELENA : RUMENA;
            }

            //Če je črka napačna jo pobarvaj CRNO v abecedi
            else {
                barveAbecede[ind] = CRNA;
            }
        }
        return barve;
    }

    //Izpiši pobarvano ugibano besedo
    public static void izpisiBesedo(String ugibanaBeseda, int[] barve) {
        for(int i = 0; i < ugibanaBeseda.length(); i++) {
            izpisZBarvo(ugibanaBeseda.charAt(i), barve[i]);
        }
        System.out.println();
    }

    //Dodatna naloga: prebere slovar iz datoteke
    public static void preberiSlovar(String datoteka) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(datoteka));
        int stBesed = sc.nextInt();
        slovar = new String[stBesed];

        for(int i = 0; i < stBesed; i++) {
            slovar[i] = sc.next().toUpperCase();
        }
        sc.close();
    }

    //ALi je beseda v slovarju?
    public static boolean besedaVSlovarju(String beseda) {
        for(int i = 0; i < slovar.length; i++) {
            if(slovar[i].equals(beseda)) return true;
        }
        return false;
    }

    //Pobarva črke v ugibani besedi
    public static int[] pravilnoPobarvajBesedo(String ugibanaBeseda) {
        int[] stManjkajocih = new int[abeceda.length()]; //Štetje ponovitev manjkajočih črk
        int[] barve = new int[ugibanaBeseda.length()];

        //Označi zelene in preštej manjkajoče črke
        for(int i = 0; i < iskanaBeseda.length(); i++) {
            int ind = abeceda.indexOf(iskanaBeseda.charAt(i));

            if(ugibanaBeseda.charAt(i) == iskanaBeseda.charAt(i)) {
                barve[i] = ZELENA;
                barveAbecede[ind] = ZELENA;
            }
            else {
                stManjkajocih[ind]++;
            }
        }

        //Pobarvaj rumene in bele
        for(int i = 0; i < ugibanaBeseda.length(); i++) {
            int ind = abeceda.indexOf(ugibanaBeseda.charAt(i));

            if(barve[i] != ZELENA) {
                if(stManjkajocih[ind] > 0) {
                    //Če je še dovolj manjkajočih ponovitev jo pobarvaj rumeno
                    stManjkajocih[ind]--;
                    barve[i] = RUMENA;
                    barveAbecede[ind] = barveAbecede[ind] == ZELENA ? ZELENA : RUMENA;
                }
                else {
                    barve[i] = BELA; //Če so pobarvane vse ponovitve jo pobarvaj belo
                    barveAbecede[ind] = Math.max(barveAbecede[ind], CRNA);
                }
            }
        }
        return barve;
    }
    //Izvede eno igro
    public static void igra() {
        novaIgra();

        int poskus = 1;
        boolean uganil = false;
        while (poskus <= MAX_POSKUSOV) {
            izpisiAbecedo();
            System.out.printf("Poskus %d/%d: ", poskus, MAX_POSKUSOV);
            String ugibanaBeseda = sc.nextLine().toUpperCase();

            //Preverimo veljavnost
            if(!veljavnaBeseda((ugibanaBeseda))) continue;

            //Pobarvaj crke v besedi (namig)
            //int[] barve = pobarvajBesedo(ugibanaBeseda);
            int[] barve = pravilnoPobarvajBesedo(ugibanaBeseda);

            //Izpiši pobarvano besedo
            izpisiBesedo(ugibanaBeseda, barve);

            if(ugibanaBeseda.equals(iskanaBeseda)) {
                uganil = true;
                break;
            }
            poskus++;
        }

        if(uganil) {
            System.out.printf("Bravo! Besedo si uganil v %d poskusih%n", poskus);
        }
        else {
            System.out.printf("Žal ti ni uspelo. Pravilan beseda: %s%n", iskanaBeseda);

        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {
        //izpisZBarvo('D', RUMENA);
        preberiBesede("src/vaje04/besede.txt");
        preberiSlovar("src/vaje04/slovar.txt");

        while (true) {
            igra();
            System.out.print("Nova igra? (d/n): ");
            String odg = sc.nextLine();
            if(odg.toLowerCase().charAt(0) != 'd') {
                break;
            }
        }
    }
}
