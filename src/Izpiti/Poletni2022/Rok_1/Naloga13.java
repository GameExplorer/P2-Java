package Izpiti.Poletni2022.Rok_1;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

class Datoteka implements Comparable<Datoteka> {
    private String ime; // ime datoteke brez poti
    private String pot; // ime datoteke vključno s potjo
    private long velikost; // velikost datoteke v bajtih

    public Datoteka(String ime, String pot, long velikost) {
        this.ime = ime;
        this.pot = pot;
        this.velikost = velikost;
    }

    public String toString() {
        return String.format("%s (%d)", this.pot, this.velikost / 1024 / 1024);
    }

    // Primerjamo datoteke
    public int compareTo(Datoteka d) {
        //primerjaj po velikost
        int primerjava = Long.compare(this.velikost, d.velikost);

        if(primerjava == 0) {
            // če sta velikosti enaki potem primerjaj po imenu
            int primerjavaImen = this.ime.compareTo(d.ime);
            if(primerjavaImen == 0) {
                // če sta imeni enaki pa primerjaj celo pot po abecedi
                return this.pot.compareTo(d.pot);
            }
            return primerjavaImen;
        }
        return -1 * primerjava;
    }
}
public class Naloga13 {

    private static ArrayList<Datoteka> datoteke = new ArrayList<>(); //ustvarimo seznam datotek

    /**
     * Metoda preveri ali gre za datoteko ali direktorij.
     *
     * @param dat - datoteke ali pot ki pregleda
     * @param velikost - velikost datotek
     */
    public static void zberiVelikeDatoteke(File dat, int velikost) {
        if(dat.isDirectory()) { //če je direktorij
            for(File d : dat.listFiles()) { //se sprehodi po njegovi vsebini
                zberiVelikeDatoteke(d, velikost); // izbere velike datoteke
            }
        }
        else if(dat.isFile()) { //če je datoteka
            long velikostDatoteke = dat.length(); // velikost datoteke v bajtih
            if(velikostDatoteke >= (long) velikost * 1024 * 1024) { //če je datoteka večja od velikosti, ki smo jo podali
                datoteke.add(new Datoteka(dat.getName(), dat.getPath(), velikostDatoteke)); //jo dodaj v seznam datotek
            }
        }
    }

    public static void main(String[] args) {
        args = new String[]{"src", "1"};
        zberiVelikeDatoteke(new File(args[0]), Integer.parseInt(args[1]));

        Collections.sort(datoteke); //Uredim podatke

        // Izpis podatkov
        for(Datoteka datoteka : datoteke) {
            System.out.println(datoteka);
        }
    }
}
