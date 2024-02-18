package vaje10;

import java.io.File;
import java.util.Set;

public class CistiRacuni {
    public static void main(String[] args) {

        //Preberi podatke in jih izpiši
        Dolgovi neporavnaniRacuni = new Dolgovi();
        neporavnaniRacuni.preberiPrijatelje(new File("src/Vaje10/prijatelji.txt"));
        neporavnaniRacuni.preberiDolgove(new File("src/Vaje10/dolgovi.txt"));
        neporavnaniRacuni.izpisi();
        System.out.println();

        //poišči prijatelje brez dolgov
        Set<Prijatelji> brezDolgov = neporavnaniRacuni.vrniBrezDolga();

        if(brezDolgov.isEmpty()) {
            System.out.println("Vsi prijatelji imajo dolgove");
        }
        else {
            System.out.println("Prijatelji nimajo dolgov");
            for(Prijatelji p: brezDolgov) {
                System.out.println(p.toString());
            }
        }

        System.out.println();

        //izpiši skupni dolg vsakega prijatelja
        neporavnaniRacuni.izpisiSkupenDolg();
        System.out.println();
    }
}
