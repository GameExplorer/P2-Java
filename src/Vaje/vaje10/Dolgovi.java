package vaje10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dolgovi {
    private final List<Prijatelji> vsiPrijatelji = new ArrayList<>();

    /*
    Prebere podatke o prijateljih in jih shrani
     */
    public void preberiPrijatelje(File datoteka) {
        try (Scanner sc = new Scanner(datoteka)) {
            String vrstica = sc.nextLine();
            if(!vrstica.isEmpty()) {
                Prijatelji p = new Prijatelji(vrstica);
                this.vsiPrijatelji.add(p);
            }
        } catch (FileNotFoundException fne) {
            System.out.println(fne);
        }
    }

    private Prijatelji vrniPrijatelja(String ime) {
        for(Prijatelji p : vsiPrijatelji) {
            if(p.getIme().equals(ime)) return p;
        }
        return null;
    }

    /**
     * Iz podane datoteke prebere podatke o trenutnih dolgovih
     * @param datoteka
     */

    public void preberiDolgove(File datoteka) {
        try (Scanner sc = new Scanner(datoteka)) {
            while(sc.hasNextLine()) {
                String[] elementi = sc.nextLine().split(";");
                if(elementi.length < 3) //vnos ni popoln ga preskočimo
                    continue;

                Prijatelji dolznik = vrniPrijatelja(elementi[0]);
                Prijatelji upnik = vrniPrijatelja(elementi[1]);
                if(upnik == null || dolznik == null) //imena ni v seznamu prijateljev
                    continue;

                double znesek = Double.parseDouble(elementi[2]);

                // zamenjaj dolznika in upnika
                if(znesek < 0) {
                    Prijatelji tmp = upnik;
                    upnik = dolznik;
                    dolznik = tmp;
                    znesek *= -1;
                }
                dolznik.dodajDolg(upnik, znesek);
            }
        }
        catch(FileNotFoundException fne) {
            System.out.println(fne);
        }
    }

    public void izpisi() {
        Collections.sort(this.vsiPrijatelji, new Comparator<Prijatelji>() {
            @Override
                public int compare(Prijatelji p1, Prijatelji p2) {
                    return p1.getIme().compareTo(p2.getIme());
                }
        });

        for(Prijatelji p : vsiPrijatelji) {
            System.out.println(p.vrniOpisZDolgovi());
        }
    }

    /**
     * Mnozica prijateljev, ki ne dolgujejo
     * @return
     */
    public Set<Prijatelji> vrniBrezDolga() {
        Set<Prijatelji> tmp = new TreeSet<>();
        for(Prijatelji p: this.vsiPrijatelji) {
            if(!p.imaDolg()) {
                tmp.add(p);
            }
        }
        return tmp;
    }

    /**
     * Skupen dolg vseh prijateljev
     */
    public void izpisiSkupenDolg() {
        double vsiDolgovi = 0.0;

        Collections.sort(this.vsiPrijatelji, new Comparator<Prijatelji>() {
            @Override
            public int compare(Prijatelji p1, Prijatelji p2) {
                return Double.compare(p2.vrniSkupniZnesekDolga(), p1.vrniSkupniZnesekDolga());
            }
        });

        for(Prijatelji p : vsiPrijatelji) {
            double dolg = p.vrniSkupniZnesekDolga();
            System.out.printf("%s: skupaj dolguje %.2f EUR %n", p.toString(), dolg);
            vsiDolgovi += dolg;
        }

        System.out.printf("Vsi prijatelji skupaj imajo %.2f EUR dolgov %n", vsiDolgovi);
    }
}
