import java.awt.*;
import java.util.Random;

//Premakni datoteko iz package-a

public class Igra15 {

    /* Igralna površina */
    private static final int STEVILO_POLJ = 4; // velikost kvadrata oz. mreže je 4x4
    private static final int STEVILKA_PRAZNEGA = STEVILO_POLJ * STEVILO_POLJ; // število, ki predstavlja prazno ploščico (odvisno od velikosti mreže)
    private static final int STRANICA_KVADRATKA = 8; // velikost ene ploščice
    private static final int DEBELINA_ROBA = 2; // razmik med izrisanimi ploščicami
    private static final int VELIKOST = STEVILO_POLJ * STRANICA_KVADRATKA + (STEVILO_POLJ + 1) * DEBELINA_ROBA; // izračunana velikost igralne površine
    private static final int GLAVA = 6; // višina prostora za izpis

    /* Barve */
    private static Color BARVA_STEVILKE = Color.decode("#e1e5eb"); // izpis številk
    private static Color BARVA_OZADJA = Color.decode("#0047AB"); // barva ploščice
    private static Color BARVA_OZADJA_PRAVILNE = Color.decode("#4e941c"); // barva ploščice, če se nahaja na pravem mestu
    private static Color BARVA_PRAZNE = Color.WHITE; // barva prazne ploščice

    /* Pisave */
    private static Font PISAVA_STEVILKE = new Font("Arial", Font.BOLD, 60); // pisava za izpis številk na ploščici
    private static Font PISAVA_GLAVA = new Font("Arial", Font.BOLD, 30); // pisava za izpis števila potez

    /* Kode smernih tipk in tipke ESC */
    private static final int TIPKA_ESC = 27;
    private static final int TIPKA_LEVO = 37;
    private static final int TIPKA_GOR = 38;
    private static final int TIPKA_DESNO = 39;
    private static final int TIPKA_DOL = 40;

    /* Parametri igre */
    private static final int POCAKAJ = 100; // igro upočasnimo za boljši prikaz in lažje branje igralčevega vnosa
    private static final String NAPIS = "Število potez: "; // napis v glavi med igro
    private static final String KONEC = "Konec igre!  Poteze: "; // napis v glavi po koncu igre

    private static int[][] polja = new int[STEVILO_POLJ][STEVILO_POLJ]; // igralna površina (mreža), hrani trenutno stanje številkilk
    private static int[] indeksPrazne = new int[2]; // indeks vrstice (0) in stolpca (1) prazne ploščice
    private static boolean igranje = true; // smo v igri (še ni konec)
    private static int poteze = 0; // štejemo poteze igralca

    /* Začetne vrednosti za igro 4x4 (vnaprej določene) */
    private static final int[][] zacetnoStanje = {{9, 7, 11, 2}, {4, 16, 15, 1}, {8, 14, 3, 6}, {12, 13, 5, 10}};

    /**
     * Inicializira parametre igre: pripravi okno z igralno površino,
     * pripravi začetne številke igre, izriše začetno stanje ploščic.
     */
    static void novaIgra() {
        // nastavitev risalne površine
        StdDraw.setXscale(0, VELIKOST);
        StdDraw.setYscale(0, VELIKOST + GLAVA);

        napolniStevilke(true); //napolni z vnaprej določenimi številkami
        //napolniStevilke(); // napolni z naključno premešanimi številkami

        izrisiPolja();
    }

    /**
     * Pripravi začetno stanje igre (začetna postavitev števil v mreži).
     * true - če začetno stanje izberem naključno
     * false če uporabim vnaprej določeno začetno stanje (le pri 4x4!)
     */
    static void napolniStevilke(boolean nakljucno) {
        indeksPrazne[0] = indeksPrazne[1] = STEVILO_POLJ - 1; //koordinati prazne ploščice (zadnja pozicija desno spodaj)
        for(int i = 0; i < STEVILO_POLJ; i++) {
            for(int j = 0; j < STEVILO_POLJ; j++) {
                if(!nakljucno && zacetnoStanje.length == STEVILO_POLJ) { //napolni mrežo iz vnaprej določene tabele samo za 4x4
                    polja[i][j] = zacetnoStanje[i][j];
                    if(zacetnoStanje[i][j] == STEVILKA_PRAZNEGA) { // zapomni si koordinati prazne ploščice
                        indeksPrazne[0] = i;
                        indeksPrazne[1] = j;
                    }
                } // naključno premešana števila ... napolni mrežo s številkami po vrsti
                else polja[i][j] = STEVILO_POLJ * i + j + 1;
            }
        }
        if (nakljucno) premesaj(); //naključno premešana števila: premešaj številke v mreži
    }
    /**
     * Premeša ploščice v mreži z naključnim številom naključnih premikov prazne ploščice
     */
    static void premesaj() {
        Random rnd = new Random();
        int n = rnd.nextInt(1000) + 500;
        for (int i = 0; i < n; i++) {
            int smer = rnd.nextInt(4);
            if(smer == 0) premakniGor();
            else if(smer == 1) premakniDol();
            else if(smer == 2) premakniLevo();
            else premakniDesno();
        }
    }
    /**
     * Izriše trenutno stanje igralne površine (mreže ploščic) ter v glavi izpiše število narejenih potez.
     */
    static void izrisiPolja() {
        StdDraw.clear(); //počisti risalno površino

        //izriši ploščice
        for(int i = 0; i < STEVILO_POLJ; i++) { //vrstice koordinata y
            for(int j = 0; j < STEVILO_POLJ; j++) { //stolpci koordinata x
                int x = STRANICA_KVADRATKA / 2 + DEBELINA_ROBA  + j * (STRANICA_KVADRATKA + DEBELINA_ROBA);
                int y = STRANICA_KVADRATKA / 2 + DEBELINA_ROBA + (STEVILO_POLJ - i - 1) * (STRANICA_KVADRATKA + DEBELINA_ROBA);

                if(polja[i][j] < STEVILKA_PRAZNEGA) { //izriše kvadrat s številko
                    if (polja[i][j] == STEVILO_POLJ * i + j + 1) //preveriš ali je številka na svojem mestu
                        StdDraw.setPenColor(BARVA_OZADJA_PRAVILNE); //če je jo obarvaj zeleno
                    else
                        StdDraw.setPenColor(BARVA_OZADJA);

                    //Nariše kvadratke
                    StdDraw.filledSquare(x, y, (double) STRANICA_KVADRATKA / 2);
                    StdDraw.setPenColor(BARVA_STEVILKE);
                    StdDraw.setFont(PISAVA_STEVILKE);
                    StdDraw.text(x, y - (double) DEBELINA_ROBA / 2, Integer.toString(polja[i][j]));
                }
                else { //izriše prazno ploščico
                    StdDraw.setPenColor(BARVA_PRAZNE);
                    StdDraw.filledSquare(x,y, (double) STRANICA_KVADRATKA / 2);
                }
            }
        }

        // dodaj izpis število potez v glavi
        StdDraw.setFont(PISAVA_GLAVA);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text((double) VELIKOST / 2, VELIKOST + (double) GLAVA / 2, NAPIS + poteze);

        StdDraw.show();
        StdDraw.pause(2 * POCAKAJ);

    }
    /**
     * Pogleda, če je bila pritisnjena katera izmed tipk. Ob pritisku na tipko ECS, zaključi igro.
     * Ustrezno premakne prazno ploščico, če jo lahko, ter preveri, če je novo stanje mreže pravilna rešitev igre.
     */
    static void naslednjaPoteza() {
        if (StdDraw.isKeyPressed(TIPKA_GOR) && premakniGor() || StdDraw.isKeyPressed(TIPKA_DOL) && premakniDol() ||
            StdDraw.isKeyPressed(TIPKA_DESNO) && premakniDesno() || StdDraw.isKeyPressed(TIPKA_LEVO) && premakniLevo()) {

            poteze++;
            izrisiPolja();
            igranje = !preveriResitev();
        }
        else if (StdDraw.isKeyPressed(TIPKA_ESC)) {
            igranje = false;
        }
        else StdDraw.pause(POCAKAJ);
    }

    /**
     * Premakne prazno ploščico dol, če lahko
     * @return true če je premik uspešen sicer false
     */
    static boolean premakniDol() {
        if (indeksPrazne[0] < STEVILO_POLJ - 1) {
            polja[indeksPrazne[0]][indeksPrazne[1]] = polja[indeksPrazne[0] + 1][indeksPrazne[1]];
            indeksPrazne[0]++;
            polja[indeksPrazne[0]][indeksPrazne[1]] = STEVILKA_PRAZNEGA;
            return true;
        }
        return false;
    }
    /**
     * Premakne prazno ploščico gor, če lahko
     * @return true če je premik uspešen sicer false
     */
    static boolean premakniGor() {
        if (indeksPrazne[0] > 0) {
            polja[indeksPrazne[0]][indeksPrazne[1]] = polja[indeksPrazne[0] - 1][indeksPrazne[1]];
            indeksPrazne[0]--;
            polja[indeksPrazne[0]][indeksPrazne[1]] = STEVILKA_PRAZNEGA;
            return true;
        }
        return false;
    }

    /**
     * Premakne prazno ploščico levo, če lahko
     * @return true če je premik uspešen sicer false
     */
    static boolean premakniLevo() {
        if (indeksPrazne[1] > 0 ) {
            polja[indeksPrazne[0]][indeksPrazne[1]] = polja[indeksPrazne[0]][indeksPrazne[1] - 1];
            indeksPrazne[1]--;
            polja[indeksPrazne[0]][indeksPrazne[1]] = STEVILKA_PRAZNEGA;
            return true;
        }
        return false;
    }

    /**
     * Premakne prazno ploščico desno, če lahko
     * @return true če je premik uspešen sicer false
     */
    static boolean premakniDesno() {
        if (indeksPrazne[1] < STEVILO_POLJ - 1) {
            polja[indeksPrazne[0]][indeksPrazne[1]] = polja[indeksPrazne[0]][indeksPrazne[1] + 1];
            indeksPrazne[1]++;
            polja[indeksPrazne[0]][indeksPrazne[1]] = STEVILKA_PRAZNEGA;
            return true;
        }
        return false;
    }
    /**
     * Preveri, ali je dosežena pravilna rešitev (števila v mreži so postavljena po vrsti, naraščajoče, zadnja ploščica pa je prazna).
     * @return true - če je dosežena pravilna rešitev, sicer false
     */
    static boolean preveriResitev() {
        for(int i = 0; i < STEVILO_POLJ; i++) {
            for(int j = 0; j < STEVILO_POLJ; j++) {
                if(polja[i][j] != STEVILO_POLJ * i + j + 1) return false;
            }
        }
        return true;
    }

    /**
     * Izpiše besedilo ob koncu igre ter število potrebnih potez za rešitev.
     */
    static void konecIgre() {
        //pobriši obstoječi napis (izris belega pravokotnika)
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledRectangle(DEBELINA_ROBA, VELIKOST + GLAVA, VELIKOST, GLAVA);

        //izpis besedila
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(PISAVA_GLAVA);
        StdDraw.text((double) VELIKOST / 2, VELIKOST + (double) GLAVA / 2, KONEC + poteze);
        StdDraw.show();
    }

    /**
     * Glavni program za izvajanje igre:
     * 1) pripravi novo igro,
     * 2) ponavljaj poteze, dokler niso vsa števila na pravih mestih,
     * 3) izpiši besedilo ob koncu igre.
     */
    public static void main(String[] args) {
        // ustvari igro in inicializiraj vse parametre igre (zmešaj številke)
        novaIgra();

        while (igranje) {
            naslednjaPoteza();
            StdDraw.enableDoubleBuffering();
        }

        // izpiši konec igre in število potez
        konecIgre();
    }
}