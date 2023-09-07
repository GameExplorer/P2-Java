package Predavanja.predavanje05;

import java.util.Scanner;

/**
 * Sah - program, ki dvema igralcema omogoča igranje igre šah:                            <br>
 *                                                                                        <br>
 *    - program izdela ”igralno ploščo”, na kateri je začetna postavitev
 *      in ploščo izriše;                                                                 <br>
 *                                                                                        <br>
 *    - program izmenjaje omogoča izvajanje potez: izmenjaje ”kliče” igralca,
 *      da vpiše potezo v obliki: izhodišče-cilj (na primer: c2-c4);                      <br>
 *                                                                                        <br>
 *    - program si zapomni izvedena poteze za izpis zgodovine in za izvajanje
 *      operacije razveljavitev (undo) *      in ploščo izriše;                           <br>
 *                                                                                        <br>
 *    - poleg potez lahko uporabnik vpiše tudi ukaze :konec (konec izvajanja programa)
 *      :undo (razveljavi potezo), :zgodovina (izpis zgodovine potez), :obrni
 *      (obrat igralne plčošče)                                                           <br>
 *                                                                                        <br>
 *    Igralno ploščo izrišemo s pomočjo Unicode znakov (bele figure imajo kode
 *    od 0x2654, črne pa od 0x265A naprej).                                               <br>
 *                                                                                        <br>
 *    Primer izrisane igralne plošče na začetku igre                                      <br>
 *                                                                                        <br>
 <pre style="font-family:Courier New;">
 A   B   C   D   E   F   G   H
 ┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓
 1 ┃ ♖ ┃ ♘ ┃ ♗ ┃ ♔ ┃ ♕ ┃ ♗ ┃ ♘ ┃ ♖ ┃
 ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
 2 ┃ ♙ ┃ ♙ ┃ ♙ ┃ ♙ ┃ ♙ ┃ ♙ ┃ ♙ ┃ ♙ ┃
 ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
 3 ┃   ┃   ┃   ┃   ┃   ┃   ┃   ┃   ┃
 ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
 4 ┃   ┃   ┃   ┃   ┃   ┃   ┃   ┃   ┃
 ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
 5 ┃   ┃   ┃   ┃   ┃   ┃   ┃   ┃   ┃
 ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
 6 ┃   ┃   ┃   ┃   ┃   ┃   ┃   ┃   ┃
 ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
 7 ┃ ♟ ┃ ♟ ┃ ♟ ┃ ♟ ┃ ♟ ┃ ♟ ┃ ♟ ┃ ♟ ┃
 ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
 8 ┃ ♜ ┃ ♞ ┃ ♝ ┃ ♚ ┃ ♛ ┃ ♝ ┃ ♞ ┃ ♜ ┃
 ┗━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┛
 </pre>
 *
 *
 * @author tomaz
 */
public class Sah {
    /**
     * Unicode koda za znaka za belega kralja; ostale bele figure imajo kode beliKralj+1, beliKralj+2, ...
     */
    public static int beliKralj = 0x2654;

    /**
     * Unicode koda za znaka za črnega kralja; ostale črne figure imajo kode crniKralj+1, crniKralj+2, ...
     */
    public static int crniKralj = 0x265A;

    // tabeli, ki ju bomo napolnili z znaki za bele in črne figure
    static char[] beleFigure;
    static char[] crneFigure;

    /**
     * Potrebujem za izpis igralca (da vemo, kdo je na potezi)
     */
    public static String[] igralca = new String[] {"beli", "črni"};

    /**
     * Metoda vrne tabelo znakov s kodamo odKje, okKje+1, odKje/2, ..., odKje+koliko-1.
     * Primer: klic vrniTabelo(97, 26) tabelo vseh malih črk angleške abecede,
     * klic vrniTabelo(beliKralj, 6); pa vse bele šahovske figure.
     *
     * @param odKje začetna Unicode koda
     * @param koliko koliko znakov naj vsebuje tabela
     * @return tabelo zaporednih znakov
     */
    public static char[] vrniTabelo(int odKje, int koliko) {
        char[] rezultat = new char[koliko];

        for (int i = 0; i < koliko; i++)
            rezultat[i] = (char) (odKje+i);

        return rezultat;
    }

    /**
     * Metoda napolni dvodimenzionalno tabelo s šahovskimi figurami.
     * Napolnimo 1., 2, (z belimi) 7. in 8. (s črnimi) vrsto fugurami,
     * v ostale vrste pa pišemo presledke (kot nevidni znak - označuje
     * prazno polje).
     * @param sahovnica sahovnica, v katero zapišem znake
     */
    public static void napolniSahovnico(char[][] sahovnica) {
        // figure prve vrste; v tabeli beleFigure so (po vrsti) zapisane figure:
        // Kralj(0), Kraljica(1), Trdnjava(2), Tekač(3), Konj(4) in Kmet(5)
        sahovnica[0][0] = sahovnica[0][7] = beleFigure[2]; //trdnjavi
        sahovnica[0][1] = sahovnica[0][6] = beleFigure[4]; //konja
        sahovnica[0][2] = sahovnica[0][5] = beleFigure[3]; //tekača
        sahovnica[0][3] = beleFigure[0]; // kralj
        sahovnica[0][4] = beleFigure[1]; // kraljica

        // figura zadnje (8.) vrste
        sahovnica[7][0] = sahovnica[7][7] = crneFigure[2];
        sahovnica[7][1] = sahovnica[7][6] = crneFigure[4];
        sahovnica[7][2] = sahovnica[7][5] = crneFigure[3];
        sahovnica[7][3]                   = crneFigure[0];
        sahovnica[7][4]                   = crneFigure[1];

        for (int i = 0; i < 8; i++)  { // kmetje
            sahovnica[1][i] = beleFigure[5];
            sahovnica[6][i] = crneFigure[5];
        }

        // prazna polja (vrste od 3 do vključno 6)
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j < 8; j++) {
                sahovnica[i][j] = ' ';
            }
        }
    }

    /**
     * Pomožna metoda za izpis ene vrstice znakov za okvir. V posamezni vrsti se 8-krat
     * ponovi isti vzorec (znak---), pri tem je "znak" v prvem izpisu vzorca drugačen
     * drugačen (a0), v ostalih izpisih pa enak (a). Vodoravna črta je zapisana v b.
     * Vrstica se konča z znakom c.
     * Metodo uporabljamo za izpis prve vrstice <br>
     *    ┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓     <br>
     * vmesni vrstic                            <br>
     *    ┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫     <br>
     * in zadnje vrstice okvirja                <br>
     *    ┗━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┻━━━┛     <br>
     * @param a0 znak za levi rob
     * @param a  znak za sredinsko mejo
     * @param b  znak za vodoravno črto
     * @param c   znak za desni rob
     */
    public static void izpisiVrsticoZnakov(char a0, char a, char b, char c) {
        System.out.print("  ");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%c%c%c%c", (i==0 ? a0 : a), b, b, b);
        }
        System.out.println(c);
    }

    /**
     * Izpis šahovnice z okvirjem in oznakami (A-H, 1-8). Okvir rišem s pomočjo
     * metode izpisiVrsticoZnakov(), ki jo kličem na tri načine (za spodnjo, srednjo
     * in zgornjo vrstico).
     * Elemente šahovnice (šahovske figure) preberem iz sahovnica[i][j]
     * in izpisujem v vmesnih vrsticah med okviri.
     * @param sahovnica sahovica, v katero zapišem znake
     */
    public static void izpisiSahovnico(char[][] sahovnica) {
        System.out.print("   ");
        for (int i = 0; i < 8; i++) {
            System.out.printf(" %c  ", 'A'+i);
        }
        System.out.println("");
        izpisiVrsticoZnakov((char)0x250F, (char)0x2533, (char)0x2501, (char)0x2513);
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d %c", i+1, 0x2503);
            // izpis posamezne vrstice
            for (int j = 0; j < 8; j++) {
                System.out.printf(" %c %c", sahovnica[i][j], 0x2503);
            }
            System.out.println("");
            if (i<7)
                izpisiVrsticoZnakov((char)0x2523, (char)0x254B, (char)0x2501, (char)0x252B);
            else
                izpisiVrsticoZnakov((char)0x2517, (char)0x253B, (char)0x2501, (char)0x256F);

        }
    }

    /**
     * Branje naslednje poteze.
     * @param igralec igralec, ki je ne potezi
     * @return prebrano potezo
     */
    public static String preberiPotezo(int igralec) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Vpiši potezo (%s): ", igralca[igralec]);
        String poteza = sc.next();

        return poteza;
    }

    /**
     * Metoda pretvori iz vhoda, ki je oblike  v tabelo, ki vsebuje 4
     * števila - koordinati izhodišča in cilja poteze. Primer: metoda potezo
     * "a2-d4" pretvori v tabela z elementi (0, 1, 3, 3).
     * @param poteza poteza (oblike ci-ci), ki jo pretvarjam
     * @return tabela s koordinatami poteze
     */
    public static int[] pretvoriPotezo(String poteza) {
        int [] t = new int [4];

        t[1] = poteza.charAt(0) - 'a';
        t[0] = poteza.charAt(1) - '1';
        t[3] = poteza.charAt(3) - 'a';
        t[2] = poteza.charAt(4) - '1';

        return t;
    }

    /**
     * Preverjanje pravilnosti poteze. Metoda preveri le osnovna pravila, ne
     * upošteva pa šahovskih pravil za premikanje različnih figur. Metoda preveri:
     * - ali je poteza oblike ci-ci (dolžina 5 znakov, znak - na tretjem mestu),
     * - ali so "koordinate" v pravih mejah (0-7)
     * - ali je na polju, od koder igralec včele figuro, igralčeva figura
     * - ali polju, kamor bo igralec postavil figuro, NI njegove figure
     * @param sahovnica trenutna postavitev igre
     * @param poteza poteza, ki jo preverjamo
     * @param igralec igralec, ki je na potezi
     * @return true, če je poteza pravilan, false sicer
     */
    public static boolean jePravilnaPoteza(char[][] sahovnica, String poteza, int igralec) {
        // poteza mora biti oblike ci-ci (npr. a4-b5)
        if ((poteza.length() != 5) || (poteza.charAt(2) != '-'))
            return false;

        int [] t = pretvoriPotezo(poteza); // potezo pretvorimo v koordinate ...
        // ... in preverimo, ali so koordinate v pravih mejah (med 0 in 7)
        if (t[0] >= 0 && t[0] <= 7 && t[1] >= 0 && t[1] <= 7 &&
                t[2] >= 0 && t[2] <= 7 && t[3] >= 0 && t[3] <= 7) {

            // igralčeve figure
            char[] mojeFigure = (igralec == 0 ? beleFigure : crneFigure);

            // figura, ki jo igralec želi premakniti
            char f = sahovnica[t[0]][t[1]];

            // najprej preverim, ali želi igralec premakniti svojo figuro
            boolean premikanMojoFiguro = false;
            for (int i = 0; i < 6; i++) {
                if (f == mojeFigure[i]) premikanMojoFiguro = true;
            }
            // če želi premakniti nasprotnikovo figuro -> poteza ni pravilna
            if (!premikanMojoFiguro) return false;

            // preverim še, kaj je na mestu, kamor želi premakniti svojo figuro
            boolean jeNaCiljuMojaFigura = false;
            f = sahovnica[t[2]][t[3]]; // figura na cilju
            for (int i = 0; i < 6; i++) {
                if (f == mojeFigure[i]) jeNaCiljuMojaFigura = true;
            }
            // če je na cilju moja figura -> poteza ni pravilna (sebe ne smem pozreti!)
            if (jeNaCiljuMojaFigura) return false;
        } else {
            return false;
        }

        return true;
    }

    /**
     * Glavna metoda, v kateri je implementirana vsa logika igre:
     *<pre>
     *   igraj():
     *     inicializiraj igro
     *     ponavljaj
     *       narisi igralno ploščo
     *       preberi potezo ali ukaz
     *       če je vpisan ukaz  (:konec, :undo, :zgodovina, :obrni)
     *         če gre za pravi ukaz
     *           izvrši ukaz
     *         sicer
     *           javi napako (napačen ukaz)
     *       sicer
     *         preveri pravilnost poteze
     *         če je poteza pravilna
     *           izvrši potezo
     *           zapomni si potezo za zgodovino
     *           zapomni si potezo za razveljavitev
     *           preklopi na naslednjega igralca
     *         sicer
     *           javi napako (nepravilna poteza)
     *</pre>
     */
    public static void igraj() {
        // dvodimenzionalna tabela velikost 8x8
        char[][] sahovnica = new char[8][8];

        // inicializacija igre
        beleFigure = vrniTabelo(beliKralj, 6);
        crneFigure = vrniTabelo(crniKralj, 6);
        napolniSahovnico(sahovnica);

        // kdo je na potezi: 0 ... prvi igralec, 1 ... drugi igralec; med igro bom
        // manjal med igralcema z ukazom "igralec = 1 - igralec"
        int igralec = 0;

        // Zgodovino potez bom shranjeval kot niz znakov, na primer takole: "a2-a4;b7-b5;b2-b4"
        // Ker je tip "String" namenjen predvsem shranjevanju fiksnih nizov, bom niz potez
        // (torej niz, ki se bo med igro spreminjal) shranil v spremenljivki tipa StringBuilder.
        // Razred StringBuilder je podoben razredu String (metode, ki jih pozna String, pozna tudi
        // StringBuilder). Poleg tega StringBuilder mogoča tudi spreminjanje niza (na primer
        // z metodma setCharAt() in append()).
        StringBuilder zgodovina = new StringBuilder();

        // Poteze za razveljavitev bom vodil s pomočjo tabele, ki jo bom uporabil kot
        // sklad; v tabelo bom "na vrh" odlagal zadnje poteze, ob akciji "undo" pa bom iz
        // vrha prebral podatke o zadnjem stanju šahovnice.
        // Za rezveljavitev poteze si zapomnim zapomnim vsebino dveh mest v šahovnici:
        // mesto, kjer se je nahajala figura in mesto, kamor sem figuro prestavil. Za
        // zapis teh dveh podatkov potrebujem 6 mest v tabeli (2x koordinata (x,y) in
        // 2x vsebina sahovnice).
        int [] undoSklad = new int[6 * 1000];
        int vrhSklada = 0;

        while (true) { // neskončna zanka
            izpisiSahovnico(sahovnica);
            String poteza = preberiPotezo(igralec);

            if (poteza.startsWith(":")) { // izvršim ukaz
                switch (poteza) {
                    case ":konec" :
                        System.exit(0);  // konec izvajanja programa (edini izhod iz while zanke)
                        break;
                    case ":zgodovina":
                        // pravi niz iz StringBuilderja dobim z ukazom toString()
                        String zgodovinaString = zgodovina.toString();

                        // niz lahko z metodo split() razbijem na posamezne dele, rezultat
                        // je tabela nizov; primer "a2-a4;b7-b5" z ukazom split(";") razbijem
                        // in dobim tabelo z elementi {"a2-a4", "b7-b5"}
                        String[] deliZgodovine = zgodovinaString.split(";");
                        System.out.println("Zgodovina:");
                        for (int i = 0; i < deliZgodovine.length; i++) {
                            System.out.println(deliZgodovine[i]);
                        }
                        break;
                    case ":undo":
                        if (vrhSklada > 0) {
                            // pred uporabo vrednosti iz sklada najprej zmanjšam števec - zato, da se bom
                            // na elemente skliceval z enakimi indeksi, kot sem se pri dodajanju na sklad
                            vrhSklada -= 6;
                            // iz sklada preberem koordinati in vsebino sahovnice pred potezo
                            sahovnica[undoSklad[vrhSklada+1]][undoSklad[vrhSklada+2]] = (char)undoSklad[vrhSklada];
                            sahovnica[undoSklad[vrhSklada+4]][undoSklad[vrhSklada+5]] = (char)undoSklad[vrhSklada+3];

                            // ko razveljavim potezo, moram seveda preklopiti tudi med igralecma
                            igralec = 1-igralec;
                            zgodovina.append(";:undo");
                        } else
                            System.out.println("Ni potez za razveljavitev");
                        break;
                    case ":obrni":
                        // sahovnico bom prepisal v novo tabelo in to vrnil kot rezultat
                        char [][] novaSahovnica = new char[8][8];
                        // pri prepisu sahovnico "zavrtim" - preslikam jo preko X in Y osi
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                novaSahovnica[i][j] = sahovnica[7-i][7-j];
                            }
                        }
                        sahovnica = novaSahovnica;
                        break;
                    default:
                        System.out.println("Napačen ukaz!");
                }
            } else { // uporabnik je vpisal potezo - poskusim jo izvesti
                if (jePravilnaPoteza(sahovnica, poteza, igralec)) {
                    int[] t = pretvoriPotezo(poteza);

                    // zapomni si potezo za razveljavitev (podatke o koordinatah začetka
                    // in konca poteze ter o vsebini šahovnice na teh dveh mestih)
                    // shranim na sklad ...
                    undoSklad[vrhSklada]   = sahovnica[t[0]][t[1]];
                    undoSklad[vrhSklada+1] = t[0];
                    undoSklad[vrhSklada+2] = t[1];
                    undoSklad[vrhSklada+3] = sahovnica[t[2]][t[3]];
                    undoSklad[vrhSklada+4] = t[2];
                    undoSklad[vrhSklada+5] = t[3];
                    // ... in povečam števec, ki kaže na vrh sklada
                    vrhSklada += 6;


                    // izvrši potezo: prestavi figuro ...
                    sahovnica[t[2]][t[3]] = sahovnica[t[0]][t[1]];
                    // ... in sprazni mesto, kjer je bila figura prej
                    sahovnica[t[0]][t[1]] = ' ';

                    // zapomni si potezo za zgodovino (dodam v StringBuilder)
                    if (zgodovina.length() > 0) zgodovina.append(";");
                    zgodovina.append(poteza);

                    // preklopi na naslednjega igralca na tri načine:
//          if (igralec == 0)
//            igralec = 1;
//          else
//            igralec = 0;
//        ... ali
//          igralec = (igralec == 0) ? 1 : 0;
//        ... ali
                    igralec = 1 - igralec;

                } else {
                    System.out.println("Napačna poteza");
                }
            }

        }
    }

    /**
     * Metoda <code>main()</code> kliče metodo <code>igraj()</code>, kjer je zbrana vsa logika igre.
     * @param args Program <code>Sah</code> ne uporablja argumentov.
     */
    public static void main(String[] args) {
        igraj();
    }

}
