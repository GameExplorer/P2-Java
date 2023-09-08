package Predavanja.predavanje06.kodiranje;

import Predavanja.predavanje06.io.BeriPisi;
import Predavanja.predavanje06.main.gui.KodiranjeOkno;

/**
 * Glavni program. Vsebuje metodo main() in metodo doKodiranje(), ki
 * opravi galvno delo kodiranja
 */
public class Kodiranje {

    /**
     * Metoda prebere datoteko in jo zakodira/odkodira in izpise v izhodno datoteko
     * @param nacin nacin kodiranja (XOR, NUM, BASE64)
     * @param smer ali gre za kodiranje ali dekodiranje
     * @param vhod vhodna datoteka
     * @param izhod izhodna datoteka
     * @param kljuc kljuc za xor kodiranje
     */
    public static void deKodiranje(String nacin, String smer, String vhod, String izhod, String kljuc) throws Exception {
        //prebere datoteko iz diska
        String vsebina = BeriPisi.preberiDatotekoOL(vhod);

        // zakodiraj vsebino datoteke
        switch (nacin) {
            case "XOR":
                if(smer.equals("code")) vsebina = Kodirniki.kodirajXOR(vsebina, kljuc);
                else vsebina = Kodirniki.odKodirajXOR(vsebina, kljuc);
                break;
            case "NUM":
                if(smer.equals("code")) vsebina = Kodirniki.kodirajNUM(vsebina);
                else vsebina = Kodirniki.OdKodirajNUM(vsebina);
                break;
            case "B64":
                if(smer.equals("code")) vsebina = Kodirniki.kodirajB64(vsebina);
                else vsebina = Kodirniki.odKodirajB64(vsebina);
                break;
        }

        BeriPisi.zapisiVDatoteko(izhod, vsebina);
    }

    /**
     * @throws Exception - delamo z datotekami
     */
    public static void main(String[] args) throws Exception {
        // ce imam argumente, jih preberem in klicem deKodiranje()
        //args = new String[]{"XOR", "decode", "veckratniki.txt", "v.txt", "abc"};
        String vsebina = BeriPisi.preberiDatoteko("src/Predavanja/predavanje06/io/veckratniki.txt");
        BeriPisi.zapisiVDatoteko("src/Predavanja/predavanje06/kodiranje/v.txt", vsebina);

        /******* TEST **********/
        String niz = "Kratko besedilo";

        niz = Kodirniki.kodirajB64(niz);
        System.out.println(niz);

        niz = Kodirniki.kodirajNUM(niz);
        System.out.println(niz);

        niz = Kodirniki.kodirajXOR(niz, "ANA");
        System.out.println(niz);

        /***** KONEC TESTA *****/

        // ce imam argumente jih preberem in klicem deKodiranje()
        if(args.length >= 1) {
            String nacin = args[0];
            String smer = args[1];
            String vhod = args[2];
            String izhod = args[3];
            String kljuc = args.length > 4 ? args[4]: "";

            deKodiranje(nacin, smer, vhod, izhod, kljuc);
        }
        else {
            //grafično okno
            KodiranjeOkno.prikaziOkno();
        }
    }
}
