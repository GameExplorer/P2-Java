package Izpiti.Poletni2022.Rok_3;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Preberemo binarno datoteko in ugotovaljamo ali se velikost, ki je zapisana na začetku datoteke
 * ujema z dejanskim številom bajtov v datoteki.
 * Če se velikosti ujemata program izpiše velikost, če pa je št. vseh bajtov v datoteki večje ali manjše od
 * zapisane velikosti datoteke se pa sprožii izjema
 */

class IzjemaNapacneDatoteke extends RuntimeException {
    public IzjemaNapacneDatoteke(String napaka) {
        super(napaka);
    }
}
public class Naloga32 {
    public static void main(String[] args) throws IzjemaNapacneDatoteke, IOException {
        args = new String[]{"src/predavanje13/imenik.bin"};

        FileInputStream vhod = new FileInputStream(args[0]);

        //preberem prvi bajt, ki pove koliko naslednjih bajtov imamo za velikost
        int prvi;
        if((prvi = vhod.read()) <= 0) {
            throw new IzjemaNapacneDatoteke("Velikot ni podana");
        }

        //preberem naslednje bajte, ki določajo velikost datoteke
        byte[] velikost = new byte[prvi];
        if((vhod.read()) != prvi) { //če v naslednjih 3 bajtih ni podane velikosti
            throw new IzjemaNapacneDatoteke("Velikost ni podana");
        }

        //vse bajte sestavimo v desetiško število
        long vel = 0;

        for(int i = 0; i < velikost.length; i++) {
            vel = (vel << 8) + (velikost[i] & 0xFF);
        }

        //preštejemo še preostale bajte v datoteki
        int i = 0;
        while(vhod.read() != -1) {
            i += 1;
        }

        vhod.close();

        //Preverim ali sta velikosti enaki
        if(i + prvi + 1 < vel) {
            throw new IzjemaNapacneDatoteke("Datoteka je manjsa, kot doloca velikost");
        }
        if(i + prvi + 1 > vel) {
            throw new IzjemaNapacneDatoteke("Datoteka je vecja, kot doloca velikost");
        }

        System.out.printf("Veliko datoteke je %d bajtov: %n", vel);
    }
}
