package Predavanje06.kodiranje.kodiranje;

import Predavanje06.kodiranje.io.BeriPisi;
import Predavanje06.kodiranje.main.gui.KodiranjeOkno;

public class Kodiranje {

    /**
     * Metoda prebere datoteko in jo zakodira/odkodira in izpise v izhodno datoteko
     * @param nacin
     * @param smer
     * @param vhod
     * @param izhod
     * @param kljuc
     * @throws Exception
     */
    public static void deKodiranje(String nacin, String smer, String vhod, String izhod, String kljuc) throws Exception {
        //prebere datoteko iz diska
        String vsebina = BeriPisi.preberiDatotekoOL(vhod);

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
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // ce imam argumente, jih preberem in klicem deKodiranje()
        String vsebina = BeriPisi.preberiDatoteko("src/Predavanje06/kodiranje/io/veckratniki.txt");
        BeriPisi.zapisiVDatoteko("src/Predavanje06/kodiranje/kodiranje/v.txt", vsebina);
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
